package com.studyproject.boardproject.dto.response;

import com.studyproject.boardproject.dto.ArticleCommentDto;
import com.studyproject.boardproject.dto.ArticleWithCommentsDto;
import com.studyproject.boardproject.dto.HashtagDto;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public record ArticleWithCommentsResponse(
        Long id,
        String title,
        String content,
        Set<String> hashtags,
        String userId,
        String nickname,
        String email,
        Set<ArticleCommentResponse> articleCommentsResponse,
        LocalDateTime createdAt
) {

    public static ArticleWithCommentsResponse of(Long id, String title, String content, Set<String> hashtags, String userId, String nickname, String email, Set<ArticleCommentResponse> articleCommentsResponse, LocalDateTime createdAt) {
        return new ArticleWithCommentsResponse(id, title, content, hashtags, userId, nickname, email, articleCommentsResponse, createdAt);
    }

    public static ArticleWithCommentsResponse from(ArticleWithCommentsDto dto) {
        String nickname = dto.userAccountDto().nickname();

        if (nickname == null || nickname.isBlank()) {
            nickname = dto.userAccountDto().userId();
        }

        return new ArticleWithCommentsResponse(
                dto.id(),
                dto.title(),
                dto.content(),
                dto.hashtagDtos().stream()
                        .map(HashtagDto::hashtagName)
                        .collect(Collectors.toUnmodifiableSet())
                ,
                dto.userAccountDto().userId(),
                nickname,
                dto.userAccountDto().email(),
                organizeChildComments(dto.articleCommentDtos()),
                dto.createdAt()
        );
    }

    private static Set<ArticleCommentResponse> organizeChildComments(Set<ArticleCommentDto> dtos) {
        // [articleComment의 id, ArticleCommentResponse] 로 매핑
        Map<Long, ArticleCommentResponse> map = dtos.stream()
                .map(ArticleCommentResponse::from)
                .collect(Collectors.toMap(ArticleCommentResponse::id, Function.identity()));

        // 부모 comment가 있을 경우 자식 comment를 부모 comment의 Set에 포함
        // [articleComment의 id, ArticleCommentResponse.childComments안에 포함]
        map.values().stream()
                .filter(ArticleCommentResponse::hasParentComment)
                .forEach(comment -> {
                    ArticleCommentResponse parentComment = map.get(comment.parentCommentId());
                    parentComment.childComments().add(comment);
                });
        
        // 댓글 순서를 정렬
        return map.values().stream()
                .filter(comment -> !comment.hasParentComment())
                .collect(Collectors.toCollection(() ->
                        // 순서를 가져야 하므로 TreeSet사용
                        new TreeSet<>(Comparator
                                .comparing(ArticleCommentResponse::createdAt)
                                .reversed()
                                .thenComparing(ArticleCommentResponse::id)
                        )
                    ));
    }
}

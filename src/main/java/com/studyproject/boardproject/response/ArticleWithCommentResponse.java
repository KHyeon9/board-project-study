package com.studyproject.boardproject.response;

import com.studyproject.boardproject.dto.ArticleWithCommentsDto;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record ArticleWithCommentResponse(
        Long id,
        String title,
        String content,
        String hashtag,
        String nickname,
        String email,
        Set<ArticleCommentResponse> articleCommentResponses,
        LocalDateTime createdAt
) {

    public static ArticleWithCommentResponse of(Long id, String title, String content, String hashtag, String nickname, String email, Set<ArticleCommentResponse> articleCommentResponses, LocalDateTime createdAt) {
        return new ArticleWithCommentResponse(id, title, content, hashtag, nickname, email, articleCommentResponses, createdAt);
    }

    public static ArticleWithCommentResponse from(ArticleWithCommentsDto dto) {
        String nickname = dto.userAccountDto().nickname();

        if (nickname == null || nickname.isBlank()) {
            nickname = dto.userAccountDto().userId();
        }

        return new ArticleWithCommentResponse(
                dto.id(),
                dto.title(),
                dto.content(),
                dto.hashtag(),
                nickname,
                dto.userAccountDto().email(),
                dto.articleCommentDtos().stream()
                        .map(ArticleCommentResponse::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new)),
                dto.createdAt()
        );
    }
}

package com.studyproject.boardproject.dto.response;

import com.studyproject.boardproject.dto.ArticleCommentDto;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public record ArticleCommentResponse(
        Long id,
        String content,
        String userId,
        String nickname,
        Long parentCommentId,
        Set<ArticleCommentResponse> childComments,
        String email,
        LocalDateTime createdAt
) {
    public static ArticleCommentResponse of(Long id, String content, String userId, String nickname, String email, LocalDateTime createdAt) {
        return ArticleCommentResponse.of(id, content, userId, nickname, null, email, createdAt);
    }

    public static ArticleCommentResponse of(Long id, String content, String userId, String nickname, Long parentCommentId, String email, LocalDateTime createdAt) {
        // 대댓글이 시간의 순서대로 출력되야 하므로 순서를 셋팅하는 로직
        Comparator<ArticleCommentResponse> childCommentComparator = Comparator
                .comparing(ArticleCommentResponse::createdAt) // 시간의 순서대로 , 반대로 할경우 reverse()를 사용
                .thenComparingLong(ArticleCommentResponse::id); // 만약 시간이 완전히 똑같을 경우 아이디로 순서를 적용
        return new ArticleCommentResponse(id, content, userId, nickname, parentCommentId, new TreeSet<>(childCommentComparator), email, createdAt);
    }

    public static ArticleCommentResponse from(ArticleCommentDto dto) {
        String nickname = dto.userAccountDto().nickname();

        if (nickname == null || nickname.isBlank()) {
            nickname = dto.userAccountDto().userId();
        }

        return ArticleCommentResponse.of(
                dto.id(),
                dto.content(),
                dto.userAccountDto().userId(),
                nickname,
                dto.parentCommentId(),
                dto.userAccountDto().email(),
                dto.createdAt()
        );
    }

    public boolean hasParentComment() {
        return parentCommentId != null;
    }
}

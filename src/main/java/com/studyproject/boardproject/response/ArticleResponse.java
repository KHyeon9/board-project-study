package com.studyproject.boardproject.response;

import com.studyproject.boardproject.dto.ArticleDto;

import java.time.LocalDateTime;

public record ArticleResponse(
        Long id,
        String title,
        String content,
        String hashtag,
        String nickname,
        String email,
        LocalDateTime createdAt
) {

    public static ArticleResponse of(Long id, String title, String content, String hashtag, String nickname, String email, LocalDateTime createdAt) {
        return new ArticleResponse(id, title, content, hashtag, nickname, email, createdAt);
    }

    public static ArticleResponse from(ArticleDto dto) {
        String nickname = dto.userAccountDto().nickname();

        if (nickname == null || nickname.isBlank()) {
            nickname = dto.userAccountDto().userId();
        }

        return new ArticleResponse(
                dto.id(),
                dto.title(),
                dto.content(),
                dto.hashtag(),
                nickname,
                dto.userAccountDto().email(),
                dto.createdAt()
        );
    }
}

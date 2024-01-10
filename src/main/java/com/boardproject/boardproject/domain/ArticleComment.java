package com.boardproject.boardproject.domain;

import java.time.LocalDateTime;

public class ArticleComment {
    private Long id;
    // article과 연결
    private Article article; // article id
    private String content; // 내용

    private LocalDateTime createdAt; // 생성 일시
    private String createdBy; // 생성자
    private LocalDateTime modifiedAt; // 수정 일시
    private String modifiedBy; // 수정자
}

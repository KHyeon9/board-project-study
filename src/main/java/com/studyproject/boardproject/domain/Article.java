package com.studyproject.boardproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class Article extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User Account와 연결
    // joinColum으로 userId와 연결
    @Setter
    @JoinColumn(name = "userId")
    @ManyToOne(optional = false)
    private UserAccount userAccount; // 유저 정보 (ID)

    @Setter @Column(nullable = false) private String title; // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 내용

    @ToString.Exclude // 순환 참조 방지
    @JoinTable(
            name = "article_hashtag", // 조인되서 출력될 테이블의 명
            joinColumns = @JoinColumn(name = "articleId"), // 주인 입장에서 조인할 컬럼
            inverseJoinColumns = @JoinColumn(name = "hashtagId") // 다른 테이블의 조인할 컬럼
    )
    // 삭제시 다른 게시글의 해시태그도 삭제 될 수 있으므로 insert와 update시만 casecade되도록함
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // psersist = insert, merge = update
    private Set<Hashtag> hashtags = new LinkedHashSet<>();

    @ToString.Exclude
    @OrderBy("createdAt DESC")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    protected Article() {}

    private Article(UserAccount userAccount, String title, String content) {
        this.userAccount = userAccount;
        this.title = title;
        this.content = content;
    }

    public static Article of(UserAccount userAccount, String title, String content) {
        return new Article(userAccount, title, content);
    }

    public void addHashtag(Hashtag hashtag) {
        this.getHashtags().add(hashtag);
    }

    public void addHashtags(Collection<Hashtag> hashtags) {
        this.getHashtags().addAll(hashtags);
    }

    public void clearHashtags() {
        this.getHashtags().clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return this.getId() != null && Objects.equals(this.getId(), article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}

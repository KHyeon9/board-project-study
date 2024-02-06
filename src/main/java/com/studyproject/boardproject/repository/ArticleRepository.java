package com.studyproject.boardproject.repository;

import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.studyproject.boardproject.domain.Article;
import com.studyproject.boardproject.domain.QArticle;
import com.studyproject.boardproject.repository.querydsl.ArticleRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends
        JpaRepository<Article, Long>,
        ArticleRepositoryCustom,
        // 해당 엔티티 안에 있는 모든 필드에 대한 기본 검색 기능  추가
        QuerydslPredicateExecutor<Article>,
        QuerydslBinderCustomizer<QArticle> {

    Page<Article> findByTitleContaining(String title, Pageable pageable);
    Page<Article> findByContentContaining(String content, Pageable pageable);
    Page<Article> findByUserAccount_UserIdContaining(String userId, Pageable pageable);
    Page<Article> findByUserAccount_NicknameContaining(String nickname, Pageable pageable);

    void deleteByIdAndUserAccount_UserId(Long articleId, String userid);

    @Override
    default void customize(QuerydslBindings bindings, QArticle root) {
        // 리스팅하지 않는 프로퍼티를 제외시키는 것
        bindings.excludeUnlistedProperties(true);
        // 검색 가능한 속성들 설정
        bindings.including(root.title, root.content, root.hashtags, root.createdAt, root.createdBy);
        // 완전한 일치로 검색하기 때문에 해당 부분 설정
        // (path, value) -> path.eq(value)을 람다로 변경
        // 대소문자 구분 안하고 하당 단어가 포함되어 있을 경우 검색
        // likeIgnoreCase와 containsIgnoreCase의 차이점
        // likeIgnoreCase -> like '${value}'이고 containsIgnoreCase는 like '%${value}}%'이다
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.hashtags.any().hashtagName).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
    }
}

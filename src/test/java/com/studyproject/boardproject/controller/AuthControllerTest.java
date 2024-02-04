package com.studyproject.boardproject.controller;

import com.studyproject.boardproject.config.SecurityConfig;
import com.studyproject.boardproject.config.TestSecurityConfig;
import com.studyproject.boardproject.service.ArticleService;
import com.studyproject.boardproject.service.PaginationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View Controller - 인증")
@Import(TestSecurityConfig.class)
@WebMvcTest(Void.class)
class AuthControllerTest {

    private final MockMvc mvc;

    @MockBean private ArticleService articleService;
    @MockBean private PaginationService paginationService;

    public AuthControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[View/GET] 로그인 페이지 - 정상 호출 ")
    @Test
    void givenNothing_whenTryToLogIn_thenReturnsLogInViwe() throws Exception {
        // Given

        // When&Then
        mvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));

        then(articleService).shouldHaveNoInteractions();;
        then(paginationService).shouldHaveNoInteractions();;
    }
}

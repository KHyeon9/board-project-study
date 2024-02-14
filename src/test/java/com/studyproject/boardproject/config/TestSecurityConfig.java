package com.studyproject.boardproject.config;

import com.studyproject.boardproject.dto.UserAccountDto;
import com.studyproject.boardproject.service.UserAccountService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {

    @MockBean private UserAccountService userAccountService;

    @BeforeTestMethod // 각 테스트 메소드가 실행되지 직전에 실행
    public void securitySetUp() {
        given(userAccountService.searchUser(anyString()))
                .willReturn(Optional.of(createUserAccountDto()));
        given(userAccountService.saveUser(anyString(), anyString(), anyString(), anyString(), anyString()))
                .willReturn(createUserAccountDto());;
    }

    // fixture
    private UserAccountDto createUserAccountDto() {
        return UserAccountDto.of(
                "hyeonTest",
                "dummy",
                "hyeon-test@email.com",
                "HyeonTest",
                "test memo"
        );
    }
}

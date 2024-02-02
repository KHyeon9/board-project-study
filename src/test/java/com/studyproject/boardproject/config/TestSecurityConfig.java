package com.studyproject.boardproject.config;

import com.studyproject.boardproject.domain.UserAccount;
import com.studyproject.boardproject.repository.UserAccountRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {

    @MockBean private UserAccountRepository userAccountRepository;

    @BeforeTestMethod // 각 테스트 메소드가 실행되지 직전에 실행
    public void securitySetUp() {
        given(userAccountRepository.findById(anyString())).willReturn(Optional.of(UserAccount.of(
            "hyeonTest",
                "dummy",
                "hyeon-test@email.com",
                "HyeonTest",
                "test memo"
        )));
    }
}

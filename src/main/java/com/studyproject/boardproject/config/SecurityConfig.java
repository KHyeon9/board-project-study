package com.studyproject.boardproject.config;

import com.studyproject.boardproject.domain.UserAccount;
import com.studyproject.boardproject.dto.UserAccountDto;
import com.studyproject.boardproject.dto.security.BoardPrincipal;
import com.studyproject.boardproject.repository.UserAccountRepository;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        // webSecurityCustomizer의 부분을 아래로 옮김
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers(
                                HttpMethod.GET,
                                "/",
                                "/articles",
                                "/articles/search-hashtag"
                        ).permitAll() // 위에 선언된 주소만 허용
                        .anyRequest().authenticated() // 나머지는 인증 적용
                )
                .formLogin(withDefaults())
                .logout(logout -> logout.logoutSuccessUrl("/"))
                .build();
    }
    // 하지만 이렇게 제외하게 되면 공격에 취약한 부분이 생기므로 securityFilterChain여기서 제외하는 것을 권고함
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        // 여기에 설정한 곳은 아예 스프링 시큐리티 검사에서 제외한다.
//        // static resource, css, js 같은 파일들
//        // PathRequest.toStaticResources().atCommonLocations()는 스프링에서 지원하는 static자원 모든 부분을 가리킴
//        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//    }

    @Bean
    public UserDetailsService userDetailsService(UserAccountRepository userAccountRepository) {
        return username -> userAccountRepository
                .findById(username)
                .map(UserAccountDto::from)
                .map(BoardPrincipal::from)
                // optional이므로 오류났을 경우에 행동 지정
                .orElseThrow(() -> new UsernameNotFoundException(("유저를 찾을 수 없습니다 - username: " + username)));
    }

    // spring security의 인증을 구현할때 password encoder를 구현해야 합니다.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

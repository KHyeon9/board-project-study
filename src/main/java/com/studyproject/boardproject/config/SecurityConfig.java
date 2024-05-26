package com.studyproject.boardproject.config;

import com.studyproject.boardproject.dto.UserAccountDto;
import com.studyproject.boardproject.dto.security.BoardPrincipal;
import com.studyproject.boardproject.dto.security.KakaoOAuth2Response;
import com.studyproject.boardproject.repository.UserAccountRepository;
import com.studyproject.boardproject.service.UserAccountService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

import java.util.UUID;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService
    ) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        // webSecurityCustomizer의 부분을 아래로 옮김
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/api/**").permitAll()
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
                .oauth2Login(oAuth -> oAuth
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(oAuth2UserService)
                        )
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"))
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
    public UserDetailsService userDetailsService(UserAccountService userAccountService) {
        return username -> userAccountService
                .searchUser(username)
                .map(BoardPrincipal::from)
                // optional이므로 오류났을 경우에 행동 지정
                .orElseThrow(() -> new UsernameNotFoundException(("유저를 찾을 수 없습니다 - username: " + username)));
    }

    /**
     * <p>
     * OAuth 2.0 기술을 이용한 인증 정보를 처리한다.
     * 카카오 인증 방식을 선택.
     *
     * <p>
     * TODO: 카카오 도메인에 결합되어 있는 코드. 확장을 고려하면 별도 인증 처리 서비스 클래스로 분리하는 것이 좋지만,
     * 현재 다른 OAuth 인증 플랫폼을 사용할 예정이 없어 이렇게 마무리한다.
     *
     * @param userAccountService  게시판 서비스의 사용자 계정을 다루는 서비스 로직
     * @param passwordEncoder 패스워드 암호화 도구
     * @return {@link OAuth2UserService} OAuth2 인증 사용자 정보를 읽어들이고 처리하는 서비스 인스턴스 반환
     */
    @Bean
    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService(
            UserAccountService userAccountService,
            PasswordEncoder passwordEncoder
    ) {
        // spring에서 제공하는 기본 구현체
        final DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();

        return userRequest -> {
            OAuth2User oAuth2User = delegate.loadUser(userRequest);

            KakaoOAuth2Response kakaoResponse = KakaoOAuth2Response.from(oAuth2User.getAttributes());
            String registrationId = userRequest.getClientRegistration().getRegistrationId(); // "kakao" -> yaml파일의 registration의 id
            String providerId = String.valueOf(kakaoResponse.id());
            String username = registrationId + "_" + providerId;
            String dummyPassword = passwordEncoder.encode("{bcrypt}" + UUID.randomUUID());

            return userAccountService.searchUser(username)
                    .map(BoardPrincipal::from)
                    .orElseGet(() ->
                            BoardPrincipal.from(
                                    userAccountService.saveUser(
                                            username,
                                            dummyPassword,
                                            kakaoResponse.email(),
                                            kakaoResponse.nickname(),
                                            null
                                    )
                            )
                    );
        };
    }

    // spring security의 인증을 구현할때 password encoder를 구현해야 합니다.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

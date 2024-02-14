package com.studyproject.boardproject.dto.security;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;

@DisplayName("DTO - Kakao OAuth 2.0 인증 응답 데이터 테스트")
class KakaoOAuth2ResponseTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @DisplayName("인증 결과를 Map(deserialized json)으로 받으면, 카카오 인증 응답 객체로 바환한다.")
    @Test
    public void givenMapFromJson_whenInstantiating_thenReturnsKakaoResponseObject() throws Exception {
        // Given
        String serializedResponse = """
                {
                    "id": 1234567890,
                    "connected_at": "2024-02-11T20:10:34Z",
                    "properties": {
                        "nickname": "홍길동"
                    },
                    "kakao_account": {
                        "profile_nickname_needs_agreement": false,
                        "profile": {
                            "nickname": "홍길동"
                        },
                        "has_email": true,
                        "email_needs_agreement": false,
                        "is_email_valid": true,
                        "is_email_verified": true,
                        "email": "test@email.com"
                    }
                }
                """;
        Map<String, Object> attributes = mapper.readValue(serializedResponse, new TypeReference<Map<String, Object>>() {});

        // When
        KakaoOAuth2Response result = KakaoOAuth2Response.from(attributes);

        // Then
        assertThat(result)
                .hasFieldOrPropertyWithValue("id", 1234567890L)
                .hasFieldOrPropertyWithValue("connectedAt", ZonedDateTime.of(2024, 2, 11, 20, 10, 34, 0, ZoneOffset.UTC)
                        .withZoneSameInstant(ZoneId.systemDefault())
                        .toLocalDateTime()
                )
                .hasFieldOrPropertyWithValue("kakaoAccount.profile.nickname", "홍길동")
                .hasFieldOrPropertyWithValue("kakaoAccount.email", "test@email.com");

    }

}
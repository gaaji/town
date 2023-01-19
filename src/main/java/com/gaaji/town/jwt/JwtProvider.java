package com.gaaji.town.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaaji.town.controller.dto.TownToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    @Value("${key.jwt}")
    private String secretKey;
    private final long TOWN_TOKEN_EXPIRATION = 1000 * 60 * 60 * 24 * 30L;

    private final Logger LOGGER = LoggerFactory.getLogger(JwtProvider.class);

    @PostConstruct // init() 메소드
    protected void init() {  // secretKey를 Base64형식으로 인코딩함. 인코딩 전후 확인 로깅
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    private String createToken(long expirationTime, TownToken dto) {
        // 토큰 생성 시작
        Claims claims = null;
        try {
            claims = Jwts.claims().setSubject(new ObjectMapper().writeValueAsString(dto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, secretKey) // 암호화 알고리즘, secret 값 세팅
                .compact();
    }


    public String createTownToken(TownToken dto) {
        return createToken(TOWN_TOKEN_EXPIRATION, dto);
    }

    public Claims validateToken(String token) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        return claims.getBody();
    }


}

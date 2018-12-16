package fr.pisur4.configservice.security;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

public class JwtConfig {

    @Getter
    @Value("${security.jwt.uri:/auth/**}")
    private String Uri;

    @Getter
    @Value("${security.jwt.header:Authorization}")
    private String header;

    @Getter
    @Value("${security.jwt.prefix:Bearer }")
    private String prefix;

    @Getter
    @Value("${security.jwt.expiration:#{24*60*60}}")
    private int expiration;

    @Getter
    @Value("${security.jwt.secret:JwtSecretKey}")
    private String secret;

    public JwtConfig() {}
}

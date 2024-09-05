package com.jtre;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class AppConfig {
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        String serverIP = "172.22.7.161";
        int serverPort = 7700;
        String pwd = "qwe";
        RedisStandaloneConfiguration rs = new RedisStandaloneConfiguration(serverIP, serverPort);
        rs.setPassword(pwd);

        // (way 2) sophisticated call of redis
        // LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder().useSsl().and().commandTimeout(Duration.ofSeconds(2)).shutdownTimeout(Duration.ZERO).build();

        // (way 3) use socket
        // new LettuceConnectionFactory(new RedisSocketConfiguration("/var/run/redis.sock"));

        return new LettuceConnectionFactory(rs);
    }

}

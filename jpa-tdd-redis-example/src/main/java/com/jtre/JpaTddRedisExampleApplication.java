package com.jtre;

import com.jtre.redis.RedisApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaTddRedisExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaTddRedisExampleApplication.class, args);
		RedisApplication redisApplication = new RedisApplication();
	}

}

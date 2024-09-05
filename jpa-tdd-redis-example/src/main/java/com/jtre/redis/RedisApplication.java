package com.jtre.redis;

import com.jtre.AppConfig;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class RedisApplication {
    final Log LOG = LogFactory.getLog(RedisApplication.class);
    public RedisApplication() {
        AppConfig appConfig = new AppConfig();
        LettuceConnectionFactory cntFactory = appConfig.redisConnectionFactory();
        cntFactory.afterPropertiesSet();

        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(cntFactory);
        template.setDefaultSerializer(StringRedisSerializer.UTF_8);
        template.afterPropertiesSet();

        template.opsForValue().set("key1", "value1");
        String result ="value at key1 : " + template.opsForValue().get("key1");
        LOG.info(result);
        System.out.println(result);

        cntFactory.destroy();
    }
}

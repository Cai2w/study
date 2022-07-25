package wang.caicai.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

/**
 * @author wangpeixu
 * @date 2022/04/30 23:00
 */
@Configuration
public class CacheConfiguration {

    @Autowired
    private RedisConfiguration redisConfiguration;

    @Bean("redisCacheManager1Days")
    @Primary
    public RedisCacheManager cacheManager1Days() {
        RedisCacheConfiguration redisCacheConfiguration = redisCacheConfiguration().entryTtl(Duration.ofDays(1));
        return redisCacheManager(redisCacheConfiguration);
    }

    @Bean("redisCacheManager10Minutes")
    public RedisCacheManager cacheManager10Minutes() {
        RedisCacheConfiguration redisCacheConfiguration = redisCacheConfiguration().entryTtl(Duration.ofMinutes(10));
        return redisCacheManager(redisCacheConfiguration);
    }

    @Bean("redisCacheManager1Minutes")
    public RedisCacheManager cacheManager1Minutes() {
        RedisCacheConfiguration redisCacheConfiguration = redisCacheConfiguration().entryTtl(Duration.ofMinutes(1));
        return redisCacheManager(redisCacheConfiguration);
    }

    @Bean("redisCacheManager30Minutes")
    public RedisCacheManager cacheManager30Minutes() {
        RedisCacheConfiguration redisCacheConfiguration = redisCacheConfiguration().entryTtl(Duration.ofMinutes(30));
        return redisCacheManager(redisCacheConfiguration);
    }

    @Bean("redisCacheManager12Hours")
    public RedisCacheManager cacheManager12Hours() {
        RedisCacheConfiguration redisCacheConfiguration = redisCacheConfiguration().entryTtl(Duration.ofHours(12));
        return redisCacheManager(redisCacheConfiguration);
    }

    @Bean("redisCacheManagerSerialize30Minutes")
    public RedisCacheManager cacheManagerSerialize30Minutes() {
        RedisCacheConfiguration redisCacheConfiguration = redisCacheSerializeConfiguration().entryTtl(Duration.ofMinutes(30));
        return redisCacheManager(redisCacheConfiguration);
    }

    @Bean("redisCacheManagerSerialize4Hours")
    public RedisCacheManager cacheManager4Hours() {
        RedisCacheConfiguration redisCacheConfiguration = redisCacheSerializeConfiguration().entryTtl(Duration.ofHours(4));
        return redisCacheManager(redisCacheConfiguration);
    }

    private RedisCacheConfiguration redisCacheSerializeConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisConfiguration.stringRedisSerializer()));
    }

    private RedisCacheConfiguration redisCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                        .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisConfiguration.stringRedisSerializer()))
                        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisConfiguration.jackson2JsonRedisSerializer()));
    }

    private RedisCacheManager redisCacheManager(RedisCacheConfiguration redisCacheConfiguration) {
        return RedisCacheManager.builder(
                RedisCacheWriter.nonLockingRedisCacheWriter(redisConfiguration.buildConnectionFactory(redisConfiguration.jedisPoolConfig(), 14))
        ).cacheDefaults(redisCacheConfiguration).build();
    }
}

package com.mbeju;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

@SpringBootApplication
@EnableCaching
public class GraphqlCachingExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlCachingExampleApplication.class, args);
	}

	@Primary
	@Bean(value = "producerCache")
	public CacheManager producerCacheManager() {
		CaffeineCacheManager cacheManager = new CaffeineCacheManager();
		cacheManager.setCaffeine(caffineCacheBuilder(20));
		return cacheManager;
	}

	@Bean(value = "postCache")
	public CacheManager postCacheManager() {
		CaffeineCacheManager cacheManager = new CaffeineCacheManager();
		cacheManager.setCaffeine(caffineCacheBuilder(5));
		return cacheManager;
	}

	Caffeine<Object, Object> caffineCacheBuilder(int ttl) {
		return Caffeine.newBuilder()
				.initialCapacity(10)
				.maximumSize(10)
				.expireAfterWrite(Duration.ofSeconds(ttl))
				.recordStats();
	}
}

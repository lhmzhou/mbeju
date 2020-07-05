package com.mbeju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
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
	
	}

	@Bean(value = "postCache")
	public CacheManager postCacheManager() {

	}

}


package com.config;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
@EnableCaching
public class CacheConfig {

	public static final int DEFAULT_MAXSIZE = 50000;
	public static final int DEFAULT_TTL = 10;

	public enum Caches {
		
		getPersonById(5), getSomething, getOtherthing(300, 1000),;

		Caches() {
		}

		Caches(int ttl) {
			this.ttl = ttl;
		}

		Caches(int ttl, int maxSize) {
			this.ttl = ttl;
			this.maxSize = maxSize;
		}

		private int maxSize = DEFAULT_MAXSIZE;
		private int ttl = DEFAULT_TTL;

		public int getMaxSize() {
			return maxSize;
		}

		public int getTtl() {
			return ttl;
		}
	}

	@Bean
	@Primary
	public CacheManager caffeineCacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();

		ArrayList<CaffeineCache> caches = new ArrayList<CaffeineCache>();
		for (Caches c : Caches.values()) {
			caches.add(new CaffeineCache(c.name(), Caffeine.newBuilder().recordStats()
					.expireAfterWrite(c.getTtl(), TimeUnit.SECONDS).maximumSize(c.getMaxSize()).build()));
		}

		cacheManager.setCaches(caches);

		return cacheManager;
	}

}

package org.lgx.springboot_jsp_shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import java.util.Collection;
import java.util.Set;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.cache
 * @ClassName: RedisCache
 * @Author: lgx
 * @Date: 2020/10/28 14:46
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */
public class RedisManager implements CacheManager {
    @Override
    public <K, V> Cache<K, V> getCache (String cacheName) throws CacheException {
        System.out.println(cacheName);
        return new RedisCache<>(cacheName);
    }
}

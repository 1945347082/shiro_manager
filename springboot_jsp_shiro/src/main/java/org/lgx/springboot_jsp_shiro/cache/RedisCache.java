package org.lgx.springboot_jsp_shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.lgx.springboot_jsp_shiro.utils.ApplicationContextUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Collection;
import java.util.Set;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.cache
 * @ClassName: RedisCache
 * @Author: lgx
 * @Date: 2020/10/28 14:49
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */
public class RedisCache<k,v> implements Cache<k,v> {
    private String cacheName;

    public RedisCache () {
    }

    public RedisCache (String cacheName) {
        this.cacheName=cacheName;
    }
    @Override
    public v get (k k) throws CacheException {
        System.out.println("get key:"+k);
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return (v) redisTemplate.opsForValue().get(k.toString());
    }

    @Override
    public v put (k k, v v) throws CacheException {
        System.out.println("put key:"+k);
        System.out.println("put value:"+v);
        RedisTemplate redistemplate = getRedisTemplate();
       redistemplate.setKeySerializer(new StringRedisSerializer());
       redistemplate.opsForValue().set(k.toString(),v);
        return null;
    }

    @Override
    public v remove (k k) throws CacheException {
        System.out.println("=======move========");
        return null;
    }
    @Override
    public void clear () throws CacheException {
        System.out.println("=========clear============");
        getRedisTemplate().delete(this.cacheName);
    }

    @Override
    public int size () {
        return 0;
    }

    @Override
    public Set<k> keys () {
        return null;
    }

    @Override
    public Collection<v> values () {
        return null;
    }

    private RedisTemplate getRedisTemplate(){
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");

        return redisTemplate;
    }
}

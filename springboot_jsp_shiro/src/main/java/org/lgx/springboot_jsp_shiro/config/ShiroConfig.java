package org.lgx.springboot_jsp_shiro.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.lgx.springboot_jsp_shiro.cache.RedisManager;
import org.lgx.springboot_jsp_shiro.shiro.realms.CustomerRealm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.config
 * @ClassName: ShiroConfig
 * @Author: lgx
 * @Date: 2020/10/23 15:36
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description: 整合shiro配置
 */
@Configuration
public class ShiroConfig {
    //shiroFilter
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置系统公共资源和受限资源
        HashMap<String, String> map = new HashMap<>();
        //公共资源
        map.put("/user/register","anon");
        map.put("/user/login","anon");
        map.put("/register.jsp","anon");

        //受限资源
        map.put("/**","authc");
        //默认认证界面路径
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
    //SecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }
    //Realm
    @Bean
    public Realm getRealm(){
        CustomerRealm customerRealm = new CustomerRealm();
        //修改品证匹配校验器
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();

        //使用Md5加密
        matcher.setHashAlgorithmName("md5");
        //使用1024散列
        matcher.setHashIterations(1024);
        customerRealm.setCredentialsMatcher(matcher);
        //开启缓存管理器
        customerRealm.setCacheManager(new RedisManager());
        //开启全局缓存
        customerRealm.setCachingEnabled(true);
        //开启认证缓存
        customerRealm.setAuthenticationCachingEnabled(true);
        customerRealm.setAuthenticationCacheName("authenticationEhcahe");
        //设置认证缓存名
        //开启授权缓存
        customerRealm.setAuthorizationCachingEnabled(true);
        //开启授权缓存名
        customerRealm.setAuthorizationCacheName("authorizationEhcahe");

        return customerRealm;
    }

}

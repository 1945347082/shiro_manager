package org.lgx.springboot_jsp_shiro.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.utils
 * @ClassName: ApplicationContextUtils
 * @Author: lgx
 * @Date: 2020/10/23 21:36
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */

@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext context;
    @Override
    public void setApplicationContext (ApplicationContext applicationContext) throws BeansException {
       context=applicationContext;
    }

    /**
     *根据Bean的名字获取工厂中的Bean
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
       return context.getBean(beanName);
    }
}

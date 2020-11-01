package org.lgx.springboot_jsp_shiro.utils;

import java.util.Random;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.utils
 * @ClassName: SaltUtils
 * @Author: lgx
 * @Date: 2020/10/23 20:12
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */
public class SaltUtils {
    /**
     * 随机生成salt
     * @param n
     * @return
     */
    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!@#$%^&?".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<n;i++){
            int num = new Random().nextInt(chars.length);
            char aChar=chars[num];
            stringBuilder.append(aChar);

        }
        return stringBuilder.toString();
    }

    /**
     * 测试生产随机salt的方法getSalt
     * @param args
     */
    public static void main (String[] args) {
        String salt = getSalt(8);
        System.out.println(salt);
    }


}

package org.lgx.springboot_jsp_shiro.service.impl;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.lgx.springboot_jsp_shiro.Dao.UserDao;
import org.lgx.springboot_jsp_shiro.pojo.Pers;
import org.lgx.springboot_jsp_shiro.pojo.Role;
import org.lgx.springboot_jsp_shiro.pojo.User;
import org.lgx.springboot_jsp_shiro.service.UserService;
import org.lgx.springboot_jsp_shiro.utils.SaltUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.service.impl
 * @ClassName: UserServiceImpl
 * @Author: lgx
 * @Date: 2020/10/23 20:04
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    /**
     * 根据角色ID获取权限集合
     * @param id
     * @return
     */
    @Override
    public ArrayList<Pers> findPersByRoleId (int id) {
        return userDao.findPersByRoleId(id);
    }

    /**
     * 通过用户名获取用户角色信息
     * @param username
     * @return
     */
    @Override
    public User findRoleByUsername (String username) {
        return userDao.findRoleByUsername(username);
    }

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    @Override
    public User findByUsername (String username) {
        return userDao.findByUsername(username);
    }

    /**
     * 生产Md5密码，并保存用户信息
     * @param user
     */
    @Override
    public void register (User user) {

        //调用Dao
        //根据铭文密码，生产Md5+salt+1024散列
        String salt = SaltUtils.getSalt(4);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
        String s = md5Hash.toHex();
        user.setPassword(s);
        userDao.add(user);
    }
}

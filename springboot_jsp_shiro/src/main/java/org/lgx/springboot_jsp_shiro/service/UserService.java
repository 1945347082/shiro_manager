package org.lgx.springboot_jsp_shiro.service;

import org.lgx.springboot_jsp_shiro.pojo.Pers;
import org.lgx.springboot_jsp_shiro.pojo.Role;
import org.lgx.springboot_jsp_shiro.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.service
 * @ClassName: UserService
 * @Author: lgx
 * @Date: 2020/10/23 20:03
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */
public interface UserService {
    void register(User user);

    User findByUsername(String username);

    User findRoleByUsername(String username);

    ArrayList<Pers> findPersByRoleId(int id);
}

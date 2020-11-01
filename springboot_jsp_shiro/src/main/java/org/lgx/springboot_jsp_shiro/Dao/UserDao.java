package org.lgx.springboot_jsp_shiro.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.lgx.springboot_jsp_shiro.pojo.Pers;
import org.lgx.springboot_jsp_shiro.pojo.Role;
import org.lgx.springboot_jsp_shiro.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.Dao
 * @ClassName: UserDao
 * @Author: lgx
 * @Date: 2020/10/23 19:58
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */
@Mapper
public interface UserDao {
    void add(User user);

    User findByUsername(String username);

   User findRoleByUsername(String username);

   //根据角色ID查询权限集合
    ArrayList<Pers> findPersByRoleId(int id);
}

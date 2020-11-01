package org.lgx.springboot_jsp_shiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.pojo
 * @ClassName: User
 * @Author: lgx
 * @Date: 2020/10/23 19:54
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String salt;

    private List<Role> roles;



}

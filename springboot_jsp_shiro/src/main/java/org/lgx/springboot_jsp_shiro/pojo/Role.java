package org.lgx.springboot_jsp_shiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.pojo
 * @ClassName: Role
 * @Author: lgx
 * @Date: 2020/10/24 14:35
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Role implements Serializable {
    private int id;
    private String rolename;

   private ArrayList<Pers> list;
}

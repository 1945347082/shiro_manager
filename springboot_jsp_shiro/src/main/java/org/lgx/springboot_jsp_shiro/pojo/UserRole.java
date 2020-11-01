package org.lgx.springboot_jsp_shiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.pojo
 * @ClassName: UserRole
 * @Author: lgx
 * @Date: 2020/10/24 14:41
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private int id;
    private int userid;
    private int roleid;


}

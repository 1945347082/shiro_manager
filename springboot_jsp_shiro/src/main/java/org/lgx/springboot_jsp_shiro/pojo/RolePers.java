package org.lgx.springboot_jsp_shiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.pojo
 * @ClassName: RolePers
 * @Author: lgx
 * @Date: 2020/10/24 14:39
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class RolePers {
    private int id;
    private int roleid;
    private int persid;

    @Override
    public String toString () {
        return "RolePers{" +
                "id=" + id +
                ", roleid=" + roleid +
                ", persid=" + persid +
                '}';
    }
}

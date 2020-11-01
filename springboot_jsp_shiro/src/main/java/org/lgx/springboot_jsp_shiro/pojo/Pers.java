package org.lgx.springboot_jsp_shiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.pojo
 * @ClassName: Pers
 * @Author: lgx
 * @Date: 2020/10/24 14:37
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Pers implements Serializable {
    private int id;
    private String persname;

    @Override
    public String toString () {
        return "Pers{" +
                "id=" + id +
                ", persname='" + persname + '\'' +
                '}';
    }
}

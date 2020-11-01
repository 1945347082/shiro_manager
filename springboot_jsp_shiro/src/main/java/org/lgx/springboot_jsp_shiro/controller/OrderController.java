package org.lgx.springboot_jsp_shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.controller
 * @ClassName: OrderController
 * @Author: lgx
 * @Date: 2020/10/24 10:47
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */
@Controller
@RequestMapping("order")
public class OrderController {

    @RequestMapping("add")
    @RequiresRoles("admin")
    public String add(){
        System.out.println("=============");
        //获取主体对象
//        Subject subject = SecurityUtils.getSubject();
//        //判断角色或权限
//        if (subject.hasRole("admin")) {
//            System.out.println("可以保存");
//        }else {
//            System.out.println("无权访问");
//        }
        return "redirect:/index.jsp";
    }

}

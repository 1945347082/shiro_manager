package org.lgx.springboot_jsp_shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.lgx.springboot_jsp_shiro.pojo.User;
import org.lgx.springboot_jsp_shiro.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.controller
 * @ClassName: UserController
 * @Author: lgx
 * @Date: 2020/10/23 18:32
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;



    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public String register(User user){
        try {
            //调用业务层
            userService.register(user);
            return "redirect:/login.jsp";
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/register";
        }

    }
    /**
     * 用户登录
     */
    @RequestMapping("/login")
    public String login(String username,String password){
        //获取用户名和密码
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);

            System.out.println("登录成功");
            return "redirect:/index.jsp";
        }catch (UnknownAccountException u){
            u.printStackTrace();
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException in){
            in.printStackTrace();
            System.out.println("密码错误");
        }
        return "redirect:/login.jsp";
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.jsp";
    }

}

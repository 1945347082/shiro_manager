package org.lgx.springboot_jsp_shiro.shiro.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.lgx.springboot_jsp_shiro.Dao.UserDao;
import org.lgx.springboot_jsp_shiro.pojo.Pers;
import org.lgx.springboot_jsp_shiro.pojo.Role;
import org.lgx.springboot_jsp_shiro.pojo.User;
import org.lgx.springboot_jsp_shiro.salt.MyByteSource;
import org.lgx.springboot_jsp_shiro.service.UserService;
import org.lgx.springboot_jsp_shiro.utils.ApplicationContextUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @PackgeName: org.lgx.springboot_jsp_shiro.shiro.realms
 * @ClassName: CustomerRealm
 * @Author: lgx
 * @Date: 2020/10/23 15:48
 * @project name: springboot_jsp_shiro
 * @Version: V1.0
 * @Description:
 */
public class CustomerRealm extends AuthorizingRealm {

    /**
     * 授权
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo (PrincipalCollection principal) {
        //获取主角色
        String primaryPrincipal = (String) principal.getPrimaryPrincipal();
        //获取授权对象
        UserService service = (UserService) ApplicationContextUtils.getBean(primaryPrincipal);

        //获取用户角色
        User user = service.findRoleByUsername(primaryPrincipal);
        //把角色放到授权中
        if (!CollectionUtils.isEmpty(user.getRoles())){
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            user.getRoles().forEach(role-> {
                authorizationInfo.addRole(role.getRolename());
            //获取角色权限集合
                ArrayList<Pers> pers = service.findPersByRoleId(role.getId());
                if (!CollectionUtils.isEmpty(pers)){
                    pers.forEach(per->authorizationInfo.addStringPermission(per.getPersname()));
                }
            });
            return authorizationInfo;
        }

        return null;
    }

    /**
     * 用户认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo (AuthenticationToken token) throws AuthenticationException {

        String principal = (String) token.getPrincipal();
        SimpleAuthenticationInfo info=null;
        UserService service = (UserService) ApplicationContextUtils.getBean("userService");
        User user = service.findByUsername(principal);
        if (!ObjectUtils.isEmpty(user)){
            info=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), new MyByteSource(user.getSalt()),this.getName());
            return info;
        }
        return info;
    }
}

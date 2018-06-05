package com.demo.mvc.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//@RunWith(SpringJUnit4ClassRunner.class)
public class ShiroTest {

    @Test
    public void testAuthentication(){

        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        // 4、创建登陆token
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            //4、登录，即身份验证: 委托给security
            // a， 完成登陆验证
            // b， 创建登陆后的subject
            // c,  登陆成功通知
            // d,  登陆session创建

            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();
    }

    @Test
    public void testAuthorization(){

        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        // 4、创建登陆token
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            //4、登录，即身份验证: 委托给security
            // a， 完成登陆验证
            // b， 创建登陆后的subject
            // c,  登陆成功通知
            // d,  登陆session创建
            subject.login(token);
            // 权限验证： 登录后完成用户角色权限
           Assert.assertEquals(subject.hasRole("role2"), true);
           Assert.assertEquals(subject.hasAllRoles(Arrays.asList("role1,role2".split(","))), true);
           Assert.assertEquals(subject.isPermitted("user:create"), true);
           Assert.assertEquals(subject.isPermitted("user:update1"), true);
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();
    }
}

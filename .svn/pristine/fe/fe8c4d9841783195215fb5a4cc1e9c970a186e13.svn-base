package com.demo.mvc.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.realm.Realm;

public class MyRealm implements Realm {

    private PasswordService passwordService = new DefaultPasswordService();

    @Override
    public String getName() {
        return "MyRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String username = (String) upToken.getPrincipal();  //得到用户名
        String password = new String ((char[])upToken.getCredentials()) ;

        if(! "zhang".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }

        if(! "123".equals(password)) {
            throw new IncorrectCredentialsException(); // 密码错误
        }
        return new SimpleAuthenticationInfo(
                username,
                passwordService.encryptPassword(password), getName());
    }
}

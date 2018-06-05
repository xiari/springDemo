package com.demo.mvc.service;

import com.demo.mvc.MapperInterface.*;
import com.demo.mvc.model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by XYY78 on 2016/9/1.
 */

@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public PermissionMapper permissionMapper;

    @Autowired
    public RoleMapper roleMapper;

    @Autowired
    public UserRoleMapper userRoleMapper;

    @Autowired
    public RolePermissionMapper rolePermissionMapper;

    @Autowired
    public PasswordHelper passwordHelper;

    public void createEndUser(User user) {
        if(user == null || StringUtils.isAnyEmpty(user.getUsername(), user.getPassword())){
            return ;
        }
        // 密码加密
        passwordHelper.encryptPassword(user);
        userMapper.createEndUser(user);
    }

    public User queryEndUserInfo(String userName , String passWord) {

        if(StringUtils.isAnyEmpty(userName, passWord)){
            return null;
        }
        return userMapper.getUserInfo(userName, passWord);
    }

    public Role queryRoleInfo(String roleId){
        if(roleId ==null) {
            return  null;
        }
        return roleMapper.getRoleInfo(Long.valueOf(roleId));
    }

    public Permission queryPermissionInfo ( String permissionId){

        if(permissionId == null) {
            return  null;
        }
        return permissionMapper.getPermissionInfo(Long.valueOf(permissionId));
    }

    public List<UserRole> queryUserRoleList(String userId){
        if(StringUtils.isEmpty(userId)) {
            return null;
        }
        return userRoleMapper.getRoleByUserId(Long.valueOf(userId));
    }
    public List<RolePermission> queryRolePermissionList(String roleId){
        if(StringUtils.isEmpty(roleId)) {
            return null;
        }
        return rolePermissionMapper.getPermissionByRoleId(Long.valueOf(roleId));
    }

    public User findUserByName(String userName) {
        if(StringUtils.isEmpty(userName)) {
            return null;
        }
        return userMapper.findUserByName(userName);
    }

    public Set<String> findUserRoleByName(String userName) {
        if(StringUtils.isEmpty(userName)) {
            return null;
        }
        return new HashSet<>(userMapper.findUserRoleByName(userName));
    }

    public Set<String> findUserPermissionByName(String userName) {
        if(StringUtils.isEmpty(userName)) {
            return null;
        }
        return new HashSet<>(userMapper.findUserPermissionByName(userName));
    }
}

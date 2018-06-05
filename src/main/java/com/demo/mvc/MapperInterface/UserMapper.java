package com.demo.mvc.MapperInterface;

import com.demo.mvc.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by XYY78 on 2016/9/1.
 */

public interface UserMapper {

    User getUserInfo(@Param(value = "userName") String userName,
                     @Param(value = "passWord") String passWord);

    User findUserByName(@Param(value = "userName") String userName);

    List<String> findUserRoleByName(@Param(value = "userName") String userName);

    List<String> findUserPermissionByName(@Param(value = "userName") String userName);

    // 用户信息创建
    // userId生成规则：10位数递增
    // 订单Id生成规则
    void createEndUser(User user);
}

package com.demo.mvc.MapperInterface;

import com.demo.mvc.model.Role;
import com.demo.mvc.model.StudentEntity;
import com.demo.mvc.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by XYY78 on 2016/9/1.
 */

public interface RoleMapper {

    Role getRoleInfo(@Param(value = "roleId") Long roleId);
}

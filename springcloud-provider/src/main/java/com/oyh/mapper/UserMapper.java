package com.oyh.mapper;

import com.oyh.model.Dept;
import com.oyh.model.Role;
import com.oyh.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    Integer queryCount(User user);

    List<User> queryUser(@Param("start") Integer start, @Param("rows")Integer rows, @Param("u")User user);


    @Select("select role_id as roleId,role_name as roleName  from t_role")
    List<Role> getRoleList();

    @Select("select dept_id as deptId,dept_name as deptName  from t_dept")
    List<Dept> getDeptList();

    @Insert("insert into t_user(user_name,user_password,user_role,user_dept,user_money,user_motto) values(#{userName},#{userPassword},#{userRole},#{userDept},#{userMoney},#{userMotto})")
    void add(User user);

    void delUserById(String[] split);
}

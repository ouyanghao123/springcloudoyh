package com.oyh.service;

import com.oyh.model.Dept;
import com.oyh.model.Role;
import com.oyh.model.User;

import java.util.List;
import java.util.Map;

public interface UserService2 {

    Map<String, Object> queryUser(Integer page, Integer rows, User user);

    List<Role> getRoleList();

    List<Dept> getDeptList();

    String add(User user);

    void delUserById(String ids);
}

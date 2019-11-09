package com.oyh.service;

import com.oyh.model.Dept;
import com.oyh.model.Role;
import com.oyh.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserServiceError implements UserService{
    public Map<String, Object> queryUser(Integer page, Integer rows, User user) {
        return null;
    }

    public List<Role> getRoleList() {
        return null;
    }

    public List<Dept> getDeptList() {
        return null;
    }

    public String add(User user) {
        return null;
    }

    public String delUserById(String ids) {
        System.out.println("删除失败");
        return "删除失败";
    }
}

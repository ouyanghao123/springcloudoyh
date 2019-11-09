package com.oyh.controller;

import com.oyh.model.Dept;
import com.oyh.model.Role;
import com.oyh.model.User;
import com.oyh.service.UserService;
import com.oyh.service.UserService2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class UserController implements UserService {

    @Resource
    private UserService2 userService2;


    @GetMapping("queryUser")
    @Override
    public Map<String, Object> queryUser(Integer page, Integer rows, User user) {
        return userService2.queryUser(page,rows,user);
    }

    @GetMapping("/getRoleList")
    @Override
    public List<Role> getRoleList() {
        return userService2.getRoleList();
    }

    @GetMapping("/getDeptList")
    @Override
    public List<Dept> getDeptList() {
        return userService2.getDeptList();
    }

    @PostMapping("/add")
    @Override
    public String add(User user) {

        return userService2.add(user);
    }


    @RequestMapping("delUserById")
    @Override
    public String delUserById(String ids) {
        userService2.delUserById(ids);
        return "删除成功";
    }
}

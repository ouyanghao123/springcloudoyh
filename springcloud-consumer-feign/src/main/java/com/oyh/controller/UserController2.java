package com.oyh.controller;


import com.oyh.model.Dept;
import com.oyh.model.Role;
import com.oyh.model.User;
import com.oyh.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@RestController
public class UserController2 {

    @Resource
    private UserService userService;

    @RequestMapping("queryUser")
    public Map<String,Object> queryUser(Integer page , Integer rows , User user){
        return userService.queryUser(page,rows,user);
    }

    @RequestMapping("toAddUser")
    public String toAddUser(Model model){
        List<Role> roleList = userService.getRoleList();
        List<Dept> deptList = userService.getDeptList();
        model.addAttribute("roleList", roleList);
        model.addAttribute("deptList", deptList);

        return "addUser";
    }
    @RequestMapping("add")
    @ResponseBody
    public String add(User user){
        return userService.add(user);
    }

    @RequestMapping("delUserById")
    public String delUserById(String ids, HttpServletResponse response) throws IOException {
        String info=  userService.delUserById(ids);
        if(info.equals("删除失败")){
            /* 设置格式为text/json */
            response.setContentType("text/json");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("网络异常！！！");
            printWriter.flush();
            printWriter.close();
        }
        return info;
    }

}

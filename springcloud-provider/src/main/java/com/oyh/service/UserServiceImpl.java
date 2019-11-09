package com.oyh.service;

import com.oyh.mapper.UserMapper;
import com.oyh.model.Dept;
import com.oyh.model.Role;
import com.oyh.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService2 {

    @Resource
    private UserMapper userMapper;


    @Override
    public Map<String, Object> queryUser(Integer page, Integer rows, User user) {

        Integer count = userMapper.queryCount(user);

        int start =(page-1)*rows;

        List<User> list = userMapper.queryUser(start,rows,user);

        Map<String, Object> map = new HashMap<>();

        map.put("total",count);

        map.put("rows",list);

        return map;
    }

    @Override
    public void delUserById(String ids) {
        String[] split = ids.split(",");
        userMapper.delUserById(split);
    }

    @Override
    public List<Role> getRoleList() {
        return userMapper.getRoleList();
    }

    @Override
    public List<Dept> getDeptList() {
        return userMapper.getDeptList();
    }

    @Override
    public String add(User user) {
        userMapper.add(user);
        return "新增成功";
    }
}

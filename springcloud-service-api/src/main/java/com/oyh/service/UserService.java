package com.oyh.service;

import com.oyh.model.Dept;
import com.oyh.model.Role;
import com.oyh.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "cloud-provider",fallback = UserServiceError.class)
public interface UserService {

    @GetMapping("queryUser")
    Map<String, Object> queryUser(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows, @SpringQueryMap User user);


    @GetMapping("/getRoleList")
    List<Role> getRoleList();

    @GetMapping("/getDeptList")
    List<Dept> getDeptList();

    @PostMapping("/add")
    String add(@RequestBody User user);

    @RequestMapping("delUserById")
    String delUserById(@RequestParam("ids") String ids);
}

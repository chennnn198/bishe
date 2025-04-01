package com.pearadmin.coderH.controller;


import com.alibaba.fastjson.JSONObject;
import com.pearadmin.coderH.util.SessionUser;
import com.pearadmin.coderH.util.SessionUtil;
import com.pearadmin.common.web.domain.response.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 */
@Controller
@RequestMapping("coderH")
public class DoLoginController {

    @GetMapping("login")
    public String login() {
        return "coderH/login" ;
    }


    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute(SessionUtil.SESSION_USER, null);
        return "redirect:/coderH/index" ;
    }


    @PostMapping("toLogin")
    @ResponseBody
    public Result<?> toLogin(@RequestBody JSONObject object, HttpServletRequest request) {
        String username = object.getString("username");
        String password = object.getString("password");
        // check login
        SessionUser sessionUser = new SessionUser(username, password);
        request.getSession().setAttribute(SessionUtil.SESSION_USER, sessionUser);
        return Result.success(object.toJSONString());
    }

    @GetMapping("register")
    public String register() {
        return "coderH/register" ;
    }

    @PostMapping("toRegister")
    @ResponseBody
    public Result<?> toRegister(@RequestBody JSONObject object) {
        String username = object.getString("username");
        String password = object.getString("password");
        String password2 = object.getString("password2");
        // do register


        return Result.success(object);
    }


    @GetMapping("doUpdatePwd")
    @ResponseBody
    public Result<?> doUpdatePwd(String oldpwd, String newpwd, HttpServletRequest request) {
        //check oldpwd
        SessionUser sessionUser = SessionUtil.getSessionUser(request);
        //update newpwd
        return Result.success(oldpwd);
    }


}

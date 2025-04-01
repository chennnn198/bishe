package com.pearadmin.coderH.controller;

import com.pearadmin.coderH.util.SessionUser;
import com.pearadmin.coderH.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 */
@Controller
@RequestMapping("coderH")
public class FrontController {

    @GetMapping("index")
    public String index(HttpServletRequest request) {
        SessionUser sessionUser = SessionUtil.getSessionUser(request);
        System.out.println(sessionUser);
        System.out.println(SessionUtil.checkLogin(request));
        return "coderH/index" ;
    }


    @GetMapping("personal")
    public String personal() {
        return "coderH/personal" ;
    }


    @GetMapping("about")
    public String about() {
        return "coderH/about" ;
    }


    @GetMapping("updatepwd")
    public String updatepwd() {
        return "coderH/updatepwd" ;
    }

}

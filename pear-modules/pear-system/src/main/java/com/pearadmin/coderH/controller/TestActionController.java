package com.pearadmin.coderH.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 */
@RestController
@RequestMapping("coderH")
public class TestActionController {

    @GetMapping("testGet")
    @ResponseBody
    public String testGet(HttpServletRequest request) {
        return "concat";
    }
}

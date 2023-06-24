package com.example.jwtdemo.controller;

import com.example.jwtdemo.common.RestResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/cookie")
public class LoginWithCookieController {


    @PostMapping("/login")
    public RestResult login(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @CookieValue(value = "uid", required = false) String uid,
                            HttpServletResponse response) {
        if (uid != null) {
            return new RestResult(200, uid + "已经登录");
        }
        if (username.equals("admin") && password.equals("admin")) {
            Cookie cookie = new Cookie("uid", "123456");
            response.addCookie(cookie);
            return new RestResult(200, "登录成功");
        }
        return new RestResult(400, "登录失败");
    }
}

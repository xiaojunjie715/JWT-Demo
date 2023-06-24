package com.example.jwtdemo.controller;


import com.example.jwtdemo.common.RestResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.example.jwtdemo.util.JWTTokenUtil.token;
import static com.example.jwtdemo.util.JWTTokenUtil.verify;

@RestController
@RequestMapping("/token")
public class LoginWithTokenController {

    @PostMapping("/login")
    public RestResult login(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.split(" ").length == 2) { // Bearer token
            String token = authorization.split(" ")[1];
            if (token != null && verify(token)) {
                return new RestResult(200, "已登录");
            }
        }
        if (username.equals("admin") && password.equals("admin")) {
            String token = token(username, password);
            return new RestResult(200, "登录成功", token);
        }
        return new RestResult(400, "登录失败", null);
    }

}

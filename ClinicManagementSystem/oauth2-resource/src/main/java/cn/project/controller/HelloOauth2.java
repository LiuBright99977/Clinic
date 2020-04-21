package cn.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloOauth2 {
    @RequestMapping("/oauth2/demo")
    public String hello(){
        return "Hello Oauth2";
    }
}

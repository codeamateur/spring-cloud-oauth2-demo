package com.zjx.dev.authserver.controller;

import com.zjx.dev.authserver.domain.SysUserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/user")
    public SysUserEntity user() {
        return new SysUserEntity();
    }
}

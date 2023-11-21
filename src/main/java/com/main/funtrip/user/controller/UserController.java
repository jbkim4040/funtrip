package com.main.funtrip.user.controller;

import com.main.funtrip.user.service.UserService;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/v1")
    public String login() {
        return "성공적으로 로그인 됨";
    }

    @PostMapping("/v1/info")
    public String registerUserInfo() {
        return "성공적으로 등록됨";
    }

    @GetMapping("/v1/info")
    public String getUserInfo(String userId) {
        return userId + "님의 데이터가 성공적으로 조회됨";
    }

    @PutMapping("/v1/info")
    public String modifyUserInfo() {
        return "성공적으로 수정됨";
    }

    @ApiModelProperty
    @GetMapping("/v1/{userId}")
    public String test(@PathVariable String userId) {
        userService.test(userId);

        return "데이터 저장 성공";
    }
}

package com.main.funtrip.user.controller;

import com.main.funtrip.user.dto.UserDTO;
import com.main.funtrip.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/v1/login")
    public boolean logIn(@RequestBody UserDTO userDTO) {
        return userService.logIn(userDTO);
    }

    @GetMapping("/v1/logout")
    public boolean logOut() {
        return userService.logOut();
    }

    @PostMapping("/v1/info")
    public List<UserDTO> registerUserInfo(@RequestBody UserDTO userDTO) throws Exception {
        return userService.registerUserInfo(userDTO);
    }

    @GetMapping("/v1/info")
    public UserDTO getUserInfo(String userId) {
        return userService.getUserInfo(userId);
    }

    @PutMapping("/v1/info")
    public List<UserDTO> modifyUserInfo(@RequestBody UserDTO userDTO) throws Exception {
        return userService.modifyUserInfo(userDTO);
    }

    @DeleteMapping("/v1/info")
    public List<UserDTO> deleteUserInfo(String userId) {
        return userService.deleteUserInfo(userId);
    }
}

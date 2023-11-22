package com.main.funtrip.common.config;

import com.main.funtrip.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class AopConfig {

    /** 암호화를 위한 Encoder */
    private final PasswordEncoder passwordEncoder;


    @Pointcut(
            "execution(* *..controller.*.register*(.., com.main.funtrip.user.dto.UserDTO, ..)) || " +
            "execution(* *..controller.*.modify*(.., com.main.funtrip.user.dto.UserDTO, ..))"
            )
    public void standardForUserInfoSecurity() {}

    @Before("standardForUserInfoSecurity()")
    public void beforeParameterLog(JoinPoint joinPoint) {
        try{
            UserDTO userDTO = (UserDTO)joinPoint.getArgs()[0];
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            log.info("PASSWORD ENCRYPTS SUCCESSFUL!!!");
        }catch(Exception e) {
            log.error("PASSWORD ENCRYPTS FAILED...");
        }
    }
}

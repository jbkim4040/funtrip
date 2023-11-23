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
    public void encryptUserInfo(JoinPoint joinPoint) {
        try{
            for(Object obj : joinPoint.getArgs()) {
                if(obj instanceof UserDTO){
                    UserDTO userDTO = (UserDTO)obj;
                    userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
                    log.info("PASSWORD ENCRYPTED SUCCESSFUL!!!");
                }
            }
        }catch(Exception e) {
            log.error("PASSWORD ENCRYPTED FAILED...");
        }
    }
}

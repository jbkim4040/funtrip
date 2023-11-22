package com.main.funtrip.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @ApiModelProperty(name = "유저 ID")
    private String id;

    @ApiModelProperty(name = "유저 이메일")
    private String email;

    @ApiModelProperty(name = "유저 비밀번호")
    private String password;
}

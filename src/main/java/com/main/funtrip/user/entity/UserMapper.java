package com.main.funtrip.user.entity;

import com.main.funtrip.user.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * packageName    : com.main.funtrip.user.entity
 * fileName       : UserMapper
 * author         : jbkim
 * date           : 2023-11-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-22        jbkim       최초 생성
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
    List<UserDTO> toUserDTOList(List<User> users);
}

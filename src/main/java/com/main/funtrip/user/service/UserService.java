package com.main.funtrip.user.service;

import com.main.funtrip.common.util.SessionUtil;
import com.main.funtrip.user.dto.UserDTO;
import com.main.funtrip.user.entity.UserMapper;
import com.main.funtrip.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    /** Repository */
    private final UserRepository userRepository;

    /** Mapper */
    private final UserMapper userMapper;

    /** etc... */
    private final PasswordEncoder passwordEncoder;


    public UserDTO getUserInfo(String userId) {
        try{
            return userMapper.toUserDTO(userRepository.findById(userId).get());
        }catch(Exception e) {
            return new UserDTO();
        }
    }

    public List<UserDTO> getAllUserInfo() {
        return userMapper.toUserDTOList(userRepository.findAll());
    }

    public boolean logIn(UserDTO userDTO) {
        UserDTO userInfo = getUserInfo(userDTO.getId());
        if(passwordEncoder.matches(userDTO.getPassword(), userInfo.getPassword())){
            SessionUtil.setAttribute("userId", userDTO.getId());
            return true;
        }
        return false;
    }

    public boolean logOut() {
        try{
            SessionUtil.removeAttribute("userId");
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    public List<UserDTO> registerUserInfo(UserDTO userDTO) throws Exception {
        SessionUtil.setAttribute("userId", userDTO.getId());
        userRepository.save(userMapper.toUser(userDTO));
        SessionUtil.removeAttribute("userId");
        return getAllUserInfo();
    }

    public List<UserDTO> modifyUserInfo(UserDTO userDTO) throws Exception {
        registerUserInfo(userDTO);
        return getAllUserInfo();
    }

    public List<UserDTO> deleteUserInfo(String userId) {
        userRepository.deleteById(userId);
        return getAllUserInfo();
    }
}

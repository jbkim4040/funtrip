package com.main.funtrip.user.service;

import com.main.funtrip.user.entity.User;
import com.main.funtrip.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void test(String userId) {
        User user = User.builder().id(userId).build();

        userRepository.save(user);
    }
}

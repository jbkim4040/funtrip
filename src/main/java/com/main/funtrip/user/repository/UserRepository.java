package com.main.funtrip.user.repository;

import com.main.funtrip.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.main.funtrip.user.repository
 * fileName       : UserRepository
 * author         : jbkim
 * date           : 2023-11-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-21        jbkim       최초 생성
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
}

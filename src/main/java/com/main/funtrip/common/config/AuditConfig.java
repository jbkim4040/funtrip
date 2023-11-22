package com.main.funtrip.common.config;

import com.main.funtrip.common.util.SessionUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * packageName    : com.main.funtrip.common.config
 * fileName       : AuditConfig
 * author         : jbkim
 * date           : 2023-11-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        jbkim       최초 생성
 */
@Configuration
public class AuditConfig implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String userId = SessionUtil.getAttribute("userId");
        return Optional.of(userId == null ? "test" : userId);
    }
}

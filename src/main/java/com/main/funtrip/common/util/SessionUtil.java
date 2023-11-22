package com.main.funtrip.common.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * packageName    : com.main.funtrip.common.util
 * fileName       : SessionUtil
 * author         : jbkim
 * date           : 2023-11-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        jbkim       최초 생성
 */
public class SessionUtil {

    public static String getAttribute(String key) {
        return (String)RequestContextHolder.getRequestAttributes().getAttribute(key, RequestAttributes.SCOPE_SESSION);
    }

    public static void setAttribute(String key, String value) {
        RequestContextHolder.getRequestAttributes().setAttribute(key, value, RequestAttributes.SCOPE_SESSION);
    }

    public static void removeAttribute(String key) throws Exception {
        RequestContextHolder.getRequestAttributes().removeAttribute(key, RequestAttributes.SCOPE_SESSION);
    }
}

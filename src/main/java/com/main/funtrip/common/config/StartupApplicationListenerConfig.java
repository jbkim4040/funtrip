package com.main.funtrip.common.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class StartupApplicationListenerConfig implements
        ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG
            = Logger.getLogger(String.valueOf(StartupApplicationListenerConfig.class));

    public static int counter;

    @Override public void onApplicationEvent(ContextRefreshedEvent event) {
        LOG.info("■■■■■■■■■■■■■■■■■■■ Bean 초기화 완료 ■■■■■■■■■■■■■■■■■■■");
        counter++;
    }
}

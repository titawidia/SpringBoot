package com.itc.springboot.impl;

import com.itc.springboot.config.ApplicationProperties;
import com.itc.springboot.config.CloudProperties;
import com.itc.springboot.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.TimeZone;

@Service
public class GreetingServiceImpl implements GreetingService {

    Logger log = LoggerFactory.getLogger(GreetingServiceImpl.class);
    private ApplicationProperties appProperties;

    private CloudProperties cloudProperties;

    public GreetingServiceImpl(ApplicationProperties appProperties, CloudProperties cloudProperties) {
        this.appProperties = appProperties;
        this.cloudProperties = cloudProperties;
    }

    @Override
    public String sayGreeting() {
        log.trace("this is log TRACE");
        log.debug("this is log DEBUG");
        log.info("this is log INFO");
        log.warn("this is log WARN");
        log.error("this is log ERROR");
        System.out.println(cloudProperties.getApikey());
        TimeZone timezone = TimeZone.getTimeZone(appProperties.getTimeZone());
        return appProperties.getWelcomeText()+
                ", our timezone :"+timezone.getDisplayName()+
                ", our currency:"+appProperties.getCurrency();

    }
}

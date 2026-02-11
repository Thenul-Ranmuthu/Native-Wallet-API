package com.native_wallet.native_wallet.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class KeepAliveService {
    
    @Value("${app.keep-alive.url}")
    private String url;

    @Scheduled(fixedRate = 60000 * 10)
    public void ping(){
        try {
            new RestTemplate().getForObject(url,String.class);
        } catch (Exception e) {
        }
    }
}

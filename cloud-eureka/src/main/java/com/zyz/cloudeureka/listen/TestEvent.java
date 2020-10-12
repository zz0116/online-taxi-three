package com.zyz.cloudeureka.listen;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class TestEvent {
    public void listen(EurekaInstanceCanceledEvent e) {
        // 发邮件 短信
        System.out.println("下线： " + e.getServerId());
    }
}

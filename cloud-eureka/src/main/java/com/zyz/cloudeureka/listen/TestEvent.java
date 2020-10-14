package com.zyz.cloudeureka.listen;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TestEvent {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent e) {
        // 发邮件 短信
        System.out.println("下线： " + e.getServerId());
    }
}

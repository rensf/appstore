package com.sys.appstore.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
    @Scheduled(cron="0/5 * * * * ?")
    public void job(){
        System.out.println("每五秒执行一次");
    }
}

package com.unionman.elk.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class Listening {

    /**
     * 定时任务
     */
    @Scheduled(cron = "00/1 * * * * ?")
    public void send(){

        String message = UUID.randomUUID().toString() + "-" + System.currentTimeMillis();

        log.info("springboot -elk  测试 {}", message);

    }







}




package com.kaikeventura.scheduler;

import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Log
@EnableAsync
@Component
public class Schedulers {

    @Scheduled(fixedRate = 5000)
    public void runFixed() {
        log.info(String.format("Scheduler hour [runFixed()] => %s", LocalDateTime.now()));
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void runEvery30Seconds() throws InterruptedException {
        log.info(String.format("Scheduler hour [runEvery30Seconds()] => %s", LocalDateTime.now()));
    }

    @Async
    @Scheduled(cron = "*/30 * * * * *")
    public void runEvery30SecondsAsync() throws InterruptedException {
        log.info(String.format("Scheduler hour [runEvery30SecondsAsync()] => %s", LocalDateTime.now()));
        Thread.sleep(60000L);
    }

    @Scheduled(cron = "* * 6-23 2-5 * *")
    public void runFrom6AmTo11PmFromDays2To5() {
        log.info(String.format("Scheduler hour [runFrom6AmTo11PmFromDays2To5()] => %s", LocalDateTime.now()));
    }

    @Schedules({
            @Scheduled(cron = "* * 0-23 * * *"),
            @Scheduled(cron = "* * 6-23 2-5 * *")
    })
    public void runFrom6AmTo11PmFromDays2To5AndEvery1HourOnOtherDays() {
        log.info(String.format("Scheduler hour [runFrom6AmTo11PmFromDays2To5AndEvery1HourOnOtherDays()] => %s", LocalDateTime.now()));
    }

    @Scheduled(cron = "* 30 9 13 SEP *")
    public void runAt9_30AmOnSeptember13th() {
        log.info(String.format("Scheduler hour [runAt9_30AmOnSeptember13th()] => %s", LocalDateTime.now()));
        log.info("Happy programmer's day!");
    }

    @Scheduled(cron = "* * 12 * * MON-FRI")
    public void runMondayToFridayAt12Pm() throws InterruptedException {
        log.info(String.format("Scheduler hour [runMondayToFridayAt12Pm()] => %s", LocalDateTime.now()));
    }
}

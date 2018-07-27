package com.sankalpa.auction.scheduler;

import com.sankalpa.auction.model.Auction;
import org.quartz.*;
import org.quartz.core.QuartzScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DailyJobService {

    @Autowired
    private Scheduler scheduler;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void executeSampleJob(List<Auction> auctionList) {

        logger.info("The daily job has begun...");
        // TODO: fire individual event jobs here for every event

        for (Auction auction : auctionList){
            JobDataMap dataMap = new JobDataMap();

            LocalTime time = LocalTime.parse(auction.getAuctionTime());
            LocalTime duration = LocalTime.parse(auction.getAuctionDuration());
            LocalTime endDate = time.plusSeconds(duration.getSecond())
                    .plusMinutes(duration.getMinute())
                    .plusHours(duration.getHour());

            dataMap.put("auctionId", auction.getAuctionId());
            dataMap.put("startTime", auction.getAuctionTime());

            JobDetail jobDetail = JobBuilder.newJob(AuctionEventJob.class)
                    .setJobData(dataMap)
                    .build();

//            SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
//            trigger.setJobDetail(jobDetail);
//            trigger.setRepeatCount(1);
//            trigger.setStartTime(Time.valueOf(time));
//            trigger.setName("Event_Trigger");

//            SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
//                    .simpleSchedule()
//                    .withRepeatCount(1);

            Trigger trigger = TriggerBuilder.newTrigger()
                    .forJob(jobDetail)
                    .startAt(Time.valueOf(time))
                    .endAt(Time.valueOf(endDate))
                    //.withSchedule(scheduleBuilder)
                    .build();

            try {
                scheduler.scheduleJob(jobDetail, trigger);
            } catch (SchedulerException e) {
                e.printStackTrace();
            }

        }
    }
}
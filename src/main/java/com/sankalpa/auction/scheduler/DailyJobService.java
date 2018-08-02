package com.sankalpa.auction.scheduler;

import com.sankalpa.auction.model.Auction;
import org.apache.tomcat.jni.Local;
import org.quartz.*;
import org.quartz.core.QuartzScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerAccessor;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DailyJobService {

    @Autowired
    private SchedulerFactoryBean scheduler;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void executeSampleJob(List<Auction> auctionList) {


        logger.info("The daily job has begun...");
        // TODO: fire individual event jobs here for every event

        for (Auction auction : auctionList){

            LocalTime time = LocalTime.parse(auction.getAuctionTime());
//            LocalTime duration = LocalTime.parse(auction.getAuctionDuration());
//            LocalTime endTime = time.plusSeconds(duration.getSecond())
//                    .plusMinutes(duration.getMinute())
//                    .plusHours(duration.getHour());
            Long duration = Long.valueOf(auction.getAuctionDuration());
            LocalTime endTime = time.plusSeconds(duration);

            String startDateStr = auction.getAuctionDate() + " " + time.toString();
            String endDateStr = auction.getAuctionDate() + " " + endTime.toString();

            java.util.Date startDate = null;
            java.util.Date endDate = null;

            try {
                startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(startDateStr);
                endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(endDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            JobDataMap startDataMap = new JobDataMap();

            startDataMap.put("auctionId", auction.getAuctionId());
            startDataMap.put("startTime", auction.getAuctionTime());
            startDataMap.put("message", "start");

            JobDetail startJobDetail = JobBuilder.newJob(AuctionEventJob.class)
                    .setJobData(startDataMap)
                    .build();

            JobDataMap endDataMap = new JobDataMap();

            endDataMap.put("auctionId", auction.getAuctionId());
            endDataMap.put("endTime", endTime.toString());
            endDataMap.put("message", "end");

            JobDetail endJobDetail = JobBuilder.newJob(AuctionEventJob.class)
                    .setJobData(endDataMap)
                    .build();

            // this here is real comment
//            SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
//            trigger.setJobDetail(jobDetail);
//            trigger.setRepeatCount(1);
//            trigger.setStartTime(Time.valueOf(time));
//            trigger.setName("Event_Trigger");

//            SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
//                    .simpleSchedule()
//                    .withRepeatCount(1);
            // upto here


//            SimpleTriggerFactoryBean triggerBean = new SimpleTriggerFactoryBean();
//            triggerBean.setJobDetail(jobDetail);
//            triggerBean.setStartTime(Time.valueOf(time));

            Trigger startTrigger = TriggerBuilder.newTrigger()
                    .forJob(startJobDetail)
                    .startAt(startDate)
                    //.endAt(endDate)
                    //.withSchedule(scheduleBuilder)
                    .build();

            Trigger endTrigger = TriggerBuilder.newTrigger()
                    .forJob(endJobDetail)
                    .startAt(endDate)
                    //.endAt(endDate)
                    //.withSchedule(scheduleBuilder)
                    .build();

            logger.info(startTrigger.getStartTime().toString());
            try {
                //scheduler.scheduleJob(jobDetail, trigger);
                scheduler.getScheduler().scheduleJob(startJobDetail, startTrigger);
                scheduler.getScheduler().scheduleJob(endJobDetail, endTrigger);
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }

    }

}
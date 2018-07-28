package com.sankalpa.auction.service;

//import com.sankalpa.auction.AuctionJob;
//import com.sankalpa.auction.HelloJob;
import com.sankalpa.auction.model.Auction;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScheduledAcutionsService {

    // TODO: how large can this list grow ?
    private List<Auction> scheduledList;    // these auctions are already scheduled
    private List<Auction> unScheduledList;  // these are fresh events
    private List<Pair<JobDetail, Trigger>> pairs;

    public ScheduledAcutionsService(){
        this.scheduledList = new ArrayList<>();
        this.unScheduledList = new ArrayList<>();
    }

    public ScheduledAcutionsService(List<Auction> scheduledList, List<Auction> unScheduledList) {
        this.scheduledList = scheduledList;
        this.unScheduledList = unScheduledList;
    }

    public List<Pair<JobDetail, Trigger>> getPairs() {
        return pairs;
    }

    public void setPairs(List<Pair<JobDetail, Trigger>> pairs) {
        this.pairs = pairs;
    }

    public List<Auction> getScheduledList() {
        return scheduledList;
    }

    public void setScheduledList(List<Auction> scheduledList) {
        this.scheduledList = scheduledList;
    }

    public List<Auction> getUnScheduledList() {
        return unScheduledList;
    }

    public void setUnScheduledList(List<Auction> unScheduledList) {
        this.unScheduledList = unScheduledList;
    }

//    public void generatePairs(List<Auction> auctions)/* throws SchedulerException */{
//
//        pairs = new ArrayList<>();
////        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
////        scheduler.start();
//
//        // create a pair for every unscheduled auction
//        for (Auction auction : auctions){
//
//            JobDataMap dataMap = new JobDataMap();
//            dataMap.put("auctionId", auction.getAuctionId());
//
//            LocalTime time = LocalTime.parse(auction.getAuctionTime());
//            LocalTime duration = LocalTime.parse(auction.getAuctionDuration());
//            LocalTime endTime = time.plusSeconds(duration.getSecond())
//                    .plusMinutes(duration.getMinute())
//                    .plusHours(duration.getHour());
//
//            String startDateStr = auction.getAuctionDate() + " " + auction.getAuctionTime();
//            String endDateStr = auction.getAuctionDate() + " " + endTime.toString();
//
//            Date startDate = null;
//            Date endDate = null;
//
//            try {
//                startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(startDateStr);
//                endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(endDateStr);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//
//            JobDetail jobDetail = JobBuilder.newJob(AuctionJob.class)
//                    .withIdentity("AuctionJob " + auction.getAuctionId(), "AuctionGroup")
//                    .setJobData(dataMap)
//                    .build();
//
//            Trigger trigger = TriggerBuilder.newTrigger()
//                    .withIdentity("Trigger for AuctionJob " + auction.getAuctionId(), "AuctionGroup")
//                    .startAt(startDate)
//                    .endAt(endDate)
//                    .build();
//
//            pairs.add(Pair.of(jobDetail, trigger));
//            scheduledList.add(auction);
//            //scheduler.scheduleJob(jobDetail, trigger);
//        }
//
//        unScheduledList = new ArrayList<>();
//    }

    public List<Long> getScheduledAuctionsIds(){
        List<Long> ids = new ArrayList<>();
        for (Auction auction : scheduledList){
            ids.add(auction.getAuctionId());
        }
        return ids;
    }
}

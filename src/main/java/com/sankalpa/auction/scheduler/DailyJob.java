package com.sankalpa.auction.scheduler;

import com.sankalpa.auction.model.Auction;
import com.sankalpa.auction.service.AuctionService;
import com.sankalpa.auction.service.ScheduledAcutionsService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DailyJob implements Job {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private DailyJobService dailyJobService;

    @Autowired
    private ScheduledAcutionsService scheduledAuctionsService;

    public void execute(JobExecutionContext context) throws JobExecutionException {

        logger.info("Daily job ** {} ** fired @ {}", context.getJobDetail().getKey().getName(), context.getFireTime());

        logger.info("Getting all the events happening at day " + LocalDate.now());

        List<Auction> allAuctionsOnDate = auctionService.getAllAuctionOnDate(LocalDate.now());
        List<Auction> unScheduledAcutions = new ArrayList<>();
        List<Auction> scheduledAuctions = scheduledAuctionsService.getScheduledList();
        List<Long> scheduledAuctionIds = scheduledAuctionsService.getScheduledAuctionsIds();

        // TODO: a binary search would shaZam here
        for (Auction auction : allAuctionsOnDate){
//          logger.info(auction.getAuctionName() + " time: " + auction.getAuctionTime());

            if (scheduledAuctionIds.contains(auction.getAuctionId()) == false){
                // add to the unscheduled auctions list
                unScheduledAcutions.add(auction);
                // add to scheduled list
                scheduledAuctionsService.getScheduledList().add(auction);
            }
        }

//        logger.info("Total auctions in scheduled auctions list is: (after scheduling) ");
//        for (Auction a : scheduledAuctions){
//            logger.info(a.getAuctionId() + " ");
//        }

        // then schedule the auctions
        dailyJobService.executeSampleJob(unScheduledAcutions);
        logger.info("Next job scheduled @ {}", context.getNextFireTime());
    }
}
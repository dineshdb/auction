package com.sankalpa.auction.scheduler;

import com.sankalpa.auction.model.Auction;
import com.sankalpa.auction.service.AuctionService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DailyJob implements Job {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private DailyJobService dailyJobService;

    public void execute(JobExecutionContext context) throws JobExecutionException {

        logger.info("Daily job ** {} ** fired @ {}", context.getJobDetail().getKey().getName(), context.getFireTime());

        logger.info("Getting all the events happening at day " + LocalDate.now());

        List<Auction> auctionsToday = auctionService.getAllAuctionOnDate(LocalDate.now());

        for (Auction auction : auctionsToday){
            logger.info(auction.getAuctionName() + " time: " + auction.getAuctionTime());
        }

        dailyJobService.executeSampleJob(auctionsToday);
        logger.info("Next job scheduled @ {}", context.getNextFireTime());
    }
}
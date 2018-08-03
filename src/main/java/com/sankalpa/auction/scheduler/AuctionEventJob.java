package com.sankalpa.auction.scheduler;

import com.sankalpa.auction.model.Auction;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuctionEventJob implements Job {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuctionEventJobService auctionEventJobService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        logger.info("AuctionEvent job ** {} ** fired @ {}", context.getJobDetail().getKey().getName(),
                context.getFireTime());

        String msg = context.getMergedJobDataMap().getString("message");
        auctionEventJobService.executeSampleJob(context.getMergedJobDataMap().getLong("auctionId"), msg);
    }
}

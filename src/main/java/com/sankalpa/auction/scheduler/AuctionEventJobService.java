package com.sankalpa.auction.scheduler;

import com.sankalpa.auction.model.Auction;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuctionEventJobService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void executeSampleJob(Long auctionId) {

        logger.info("The auction event job with auciton id {} has begun...", auctionId);
        // TODO: fire individual event jobs here for every event

//        try {
//
//        } catch (InterruptedException e) {
//            logger.error("Error while executing sample job", e);
//        } finally {
//            logger.info("Daily job has finished...");
//        }
    }
}

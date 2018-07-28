package com.sankalpa.auction.websocket;

import com.sankalpa.auction.Holder.AuctionWatchInfo;
import com.sankalpa.auction.Holder.HighestBidInfo;
import com.sankalpa.auction.model.StringResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LiveUpdateController {

    Logger log = LoggerFactory.getLogger(getClass());

    @SendTo("/auction/highestBid")
    public void sendHighestBid(String highestBidderId, String highestBidId, String highestBidAmount,
                String itemId, String auctionId){

        HighestBidInfo info = new HighestBidInfo(highestBidderId, highestBidId, highestBidAmount, itemId, auctionId);
        template.convertAndSend("/auction/highestBid", info);
        // TODO: send highestBidderId and highestBidAmount

    }

    @Autowired
    SimpMessagingTemplate template;

    //@Scheduled(fixedDelay = 1000L)
    @SendTo("/auction/watch")
    public void sendAuctionId(Long auctionId, String action) {
        log.info("auctionId: " + String.valueOf(auctionId));
        AuctionWatchInfo info = new AuctionWatchInfo(String.valueOf(auctionId), action);
        template.convertAndSend("/auction/watch", info);
        //return new StringResponse(String.valueOf(auctionId));
        template.convertAndSend("/auction/1", "pong (periodic)");
    }

    @Scheduled(fixedDelay = 1000L)
    public void ping(){
        auctionBid(1, 2, 100);
    }

    public void auctionBid(int auctionId, int user, int bid){
        sendLive("/auction/"+ auctionId, "bid " + user + " " + bid);
    }

    public void auctionEnd(int auctionId){
        sendLive("/auction/"+ auctionId, "end");
    }

    public void auctionStart(int auctionId){
        sendLive("/auction/"+ auctionId, "start");
    }
    public void sendLive(String path, String message){
        template.convertAndSend(path, message);
    }
}

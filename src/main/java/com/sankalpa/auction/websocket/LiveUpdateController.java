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

    @Autowired
    SimpMessagingTemplate template;

    Logger log = LoggerFactory.getLogger(getClass());

    @SendTo("/auction/{auctionId}")
    public void sendHighestBid(@DestinationVariable("auctionId") Long auctionId, String itemId,
                               String highestBidderId, String highestBidId, String highestBidAmount){

        //HighestBidInfo info = new HighestBidInfo(highestBidderId, highestBidId, highestBidAmount, itemId.toString(), auctionId);
        template.convertAndSend("/auction/" + auctionId.toString(), "bid " + auctionId + " " + highestBidderId + " "
                 + highestBidAmount);
        // auctionId, userId, bidAmount
    }

    @SendTo("/auction/{auctionId}")
    public void sendAuctionId(@DestinationVariable("auctionId") Long auctionId, String action) {
        log.info("auctionId: " + String.valueOf(auctionId));
        //AuctionWatchInfo info = new AuctionWatchInfo(String.valueOf(auctionId), action);
        template.convertAndSend("/auction/" + auctionId.toString(), "start");

//        AuctionWatchInfo info = new AuctionWatchInfo(String.valueOf(auctionId), action);
//        template.convertAndSend("/auction/watch", info);
//        //return new StringResponse(String.valueOf(auctionId));
//        template.convertAndSend("/auction/1", "pong (periodic)");
    }

//    @Scheduled(fixedDelay = 1000L)
//    public void ping(){
//        auctionBid(1, 2, 100);
//    }

//    public void auctionBid(int auctionId, int user, int bid){
//        sendLive("/auction/"+ auctionId, "bid " + user + " " + bid);
//    }
//
//    public void auctionEnd(int auctionId){
//        sendLive("/auction/"+ auctionId, "end");
//    }
//
//    public void auctionStart(int auctionId){
//        sendLive("/auction/"+ auctionId, "start");
//    }
//
//    public void sendLive(String path, String message){
//        template.convertAndSend(path, message);
//    }
}

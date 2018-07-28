package com.sankalpa.auction.websocket;

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
    @SendTo("/auction/{product}")
    public LiveUpdateMessage update(@DestinationVariable("product") String product, String msg){
    	System.out.println(product + msg);
        return new LiveUpdateMessage(product);
    }

    @Autowired
    SimpMessagingTemplate template;

    public void sendPong() {
        template.convertAndSend("/auction/1", "pong (periodic)");
    }

    @Scheduled(fixedDelay = 1000L)
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

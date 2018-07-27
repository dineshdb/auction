package com.sankalpa.auction.websocket;

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

    @SendTo("/auction/{product}")
    public LiveUpdateMessage update(@DestinationVariable("product") String product, String msg){
    	log.info(product + msg);
        return new LiveUpdateMessage(product);
    }

    @Autowired
    SimpMessagingTemplate template;

    //@Scheduled(fixedDelay = 1000L)
    @SendTo("/auction/1")
    public void sendPong(Long auctionId) {
        log.info("auctionId: " + String.valueOf(auctionId));
        template.convertAndSend("/auction/1", new StringResponse(String.valueOf(auctionId)));
        //return new StringResponse(String.valueOf(auctionId));
    }
}

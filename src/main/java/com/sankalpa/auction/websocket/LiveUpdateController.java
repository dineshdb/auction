package com.sankalpa.auction.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LiveUpdateController {
    @MessageMapping("/bid/{product}")
    @SendTo("/auction/{product}")
    public LiveUpdateMessage update(@DestinationVariable("product") String product, String msg){
    	System.out.println(product + msg);
        return new LiveUpdateMessage(product);
    }   
}

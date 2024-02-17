package com.madan.zerodha.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Controller
public class WsController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(@RequestBody String msg){
        System.out.println(msg);
        return "hello";
    }
}

package com.madan.zerodha.ws;

import com.madan.zerodha.dto.OrderBookWithTicker;
import com.madan.zerodha.dto.OrderDetails;
import com.madan.zerodha.service.OrderBookImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class WsController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
    public void sendListUpdate(String ticker,List<OrderDetails> msg){
        OrderBookWithTicker build = OrderBookWithTicker
                .builder()
                .ticker(ticker)
                .orderBook(msg)
                .build();
        simpMessagingTemplate.convertAndSend("/topic/Details",build);
    }

    @MessageMapping("/orderList")
    @SendTo("/topic/Details")
    public OrderBookWithTicker sendOrderBook(@RequestBody String ticker){
        System.out.println("Received ticket"+ticker);
        return OrderBookWithTicker.builder().ticker(ticker).orderBook(OrderBookImpl.buyOrderBook.get(ticker)).build();
    }
}

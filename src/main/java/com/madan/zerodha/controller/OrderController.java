package com.madan.zerodha.controller;

import com.madan.zerodha.dto.OrderDetails;
import com.madan.zerodha.service.OrderBookImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderBookImpl orderBook;
    @PostMapping("/place/buy")
    public ResponseEntity<?> palaceBuyOrder(@RequestBody OrderDetails orderDetails){
        orderDetails.setOrderId(UUID.randomUUID());
        return ResponseEntity.ok()
                .location(URI.create("/order/place/buy"))
                .body(orderBook.placeBuyOrder(orderDetails));
    }
    @PostMapping("/place/sell")
    public ResponseEntity<?> palaceSellOrder(@Valid @RequestBody OrderDetails orderDetails){
        orderDetails.setOrderId(UUID.randomUUID());
        return ResponseEntity.ok()
                .location(URI.create("/order/place/sell"))
                .body(orderBook.placeSellOrder(orderDetails));
    }
    @GetMapping("/getBuyOrderBook")
    public ResponseEntity<Map<String, List<OrderDetails>>> getBuyOrderBook(){
        return ResponseEntity
                .ok()
                .body(OrderBookImpl.buyOrderBook);
    }

    @GetMapping("/getSellOrderBook")
    public ResponseEntity<Map<String, List<OrderDetails>>> getSellOrderBook(){
        return ResponseEntity
                .ok()
                .body(OrderBookImpl.sellOrderBook);
    }
}

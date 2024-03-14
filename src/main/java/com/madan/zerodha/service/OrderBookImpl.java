package com.madan.zerodha.service;

import com.madan.zerodha.dto.OrderDetails;
import com.madan.zerodha.ws.WsController;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@Slf4j
@Data
public class OrderBookImpl {
    @Autowired
    private WsController wsController;
    public static Map<String, List<OrderDetails>> buyOrderBook;
    public static Map<String, List<OrderDetails>> sellOrderBook;
    public OrderBookImpl(){
        log.info("Order Book created for buy and sell");
        buyOrderBook = new HashMap<>();
        sellOrderBook = new HashMap<>();
    }
    private void buyOrder(String ticker,OrderDetails orderDetails){
        addInOrderList(ticker, orderDetails, buyOrderBook);
    }

    private void sellOrder(String ticker,OrderDetails orderDetails){
        addInOrderList(ticker,orderDetails, sellOrderBook);
    }

    private void addInOrderList(String ticker, OrderDetails orderDetails, Map<String, List<OrderDetails>> orderBook) {
        List<OrderDetails> orderList = orderBook.get(ticker)!=null? orderBook.get(ticker): new ArrayList<OrderDetails>();
        int index =orderList.size();
        for(int i = 0;i< orderList.size();i++){
            if(orderList.get(i).getPrice().compareTo(orderDetails.getPrice()) == -1){
                index = i;
                break;
            }
        }
        orderList.add(index,orderDetails);
        if(orderBook.get(ticker)==null) orderBook.put(ticker,orderList);
    }

    public boolean placeBuyOrder(OrderDetails orderDetails){

        if(orderDetails.getOrderType().equalsIgnoreCase(OrderDetails.orderTypes.LIMIT.toString())){
            buyOrder(orderDetails.getTicker(),orderDetails);
        }
        wsController.sendListUpdate(orderDetails.getTicker(),buyOrderBook.get(orderDetails.getTicker()),sellOrderBook.get(orderDetails.getTicker()));
        return true;
    }

    public boolean placeSellOrder(OrderDetails orderDetails){
        if(orderDetails.getOrderType().equalsIgnoreCase(OrderDetails.orderTypes.LIMIT.toString())){
            sellOrder(orderDetails.getTicker(),orderDetails);
        }
        wsController.sendListUpdate(orderDetails.getTicker(),buyOrderBook.get(orderDetails.getTicker()),sellOrderBook.get(orderDetails.getTicker()));
        return true;
    }

}

package com.madan.zerodha.service;

import com.madan.zerodha.dto.OrderDetails;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExecuteOrderImpl {
    public void executeBuyOrder(OrderDetails orderDetails){
        List<OrderDetails> sellOrderBook = OrderBookImpl.sellOrderBook.get(orderDetails.getTicker());
        Long quantity = orderDetails.getQuantity();
        BigDecimal amount = new BigDecimal(0);
        for (int i = sellOrderBook.size()-1; i >=0; i--) {
            quantity = getaLong(sellOrderBook, quantity, amount, i);
        }
        sellOrderBook
                .stream()
                .filter(x->x.getQuantity().compareTo(0L) == 0);
    }

    public void executeSellOrder(OrderDetails orderDetails){
        List<OrderDetails> buyOrderBook = OrderBookImpl.buyOrderBook.get(orderDetails.getTicker());
        Long quantity = orderDetails.getQuantity();
        BigDecimal amount = new BigDecimal(0);
        for(int i=0;i<buyOrderBook.size();i++){
            quantity = getaLong(buyOrderBook, quantity, amount, i);
            if (quantity == null) break;
        }
        buyOrderBook
                .stream()
                .filter(x->x.getQuantity().compareTo(0L) == 0);
    }

    private Long getaLong(List<OrderDetails> orderBook, Long quantity, BigDecimal amount, int i) {
        if(quantity<= orderBook.get(i).getQuantity()){
            amount.add(orderBook.get(i).getPrice().multiply(BigDecimal.valueOf(orderBook.get(i).getQuantity())));
            quantity -= orderBook.get(i).getQuantity();
            orderBook.get(i).setQuantity(0L);
        } else{
            amount.add(orderBook.get(i).getPrice().multiply(BigDecimal.valueOf(quantity)));
            orderBook.get(i).setQuantity(orderBook.get(i).getQuantity()-quantity);
            quantity = 0L;
        }
        if(quantity.compareTo(0L) == 0) return null;
        return quantity;
    }
}

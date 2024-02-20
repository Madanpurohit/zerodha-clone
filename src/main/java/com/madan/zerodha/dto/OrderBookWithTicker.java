package com.madan.zerodha.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderBookWithTicker {
    private String ticker;
    List<OrderDetails> orderBook;
}

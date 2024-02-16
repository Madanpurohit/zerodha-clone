package com.madan.zerodha.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class OrderDetails {
    private UUID orderId;
    @NotNull(message = "ticker is missing")
    private String ticker;
    @NotNull(message = "quantity is missing")
    private Long quantity;
    @NotNull(message = "OrderType missing")
    private String orderType;
    private BigDecimal price;
    public enum orderTypes{
        MARKET,
        LIMIT
    }
}

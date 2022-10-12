package com.mandarinrobotics.externalorderserver.dto;

import com.google.gson.Gson;
import com.mandarinrobotics.externalorderserver.model.OriginOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class OriginOrderCancellationDto {
    @NotBlank
    private String orderId;

    @NotBlank
    private String orderCancellationTime;

    public OriginOrder convertToOriginOrder() {
        OriginOrder order = new OriginOrder();

        order.setOrderId(orderId);
        order.setOrderCanceledTime(orderCancellationTime);

        return order;
    }
}

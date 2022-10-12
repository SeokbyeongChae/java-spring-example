package com.mandarinrobotics.externalorderserver.dto;

import com.mandarinrobotics.externalorderserver.model.OriginOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class OriginOrderCompletedDto {
    @NotBlank
    private String orderId;

    @NotBlank
    private String orderCompleteTime;

    public OriginOrder convertToOriginOrder() {
        OriginOrder order = new OriginOrder();

        order.setOrderId(orderId);
        order.setOrderCompleteTime(orderCompleteTime);

        return order;
    }
}

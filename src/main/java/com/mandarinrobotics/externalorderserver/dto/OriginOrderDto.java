package com.mandarinrobotics.externalorderserver.dto;

import com.google.gson.Gson;
import com.mandarinrobotics.externalorderserver.model.OriginOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
public class OriginOrderDto {
    @NotBlank
    private String storeCode;

    @NotBlank
    private String orderId;

    @NotNull
    @Min(1)
    @Max(3)
    private int orderType;

    @NotNull
    private String orderAddress;

    @NotBlank
    private String orderCreateTime;

    @NotBlank
    private String orderCompleteTime;

    @Valid
    @NotNull
    private List<OriginOrderMenuDto> orderItemList;

    public OriginOrder convertToOriginOrder() {
        OriginOrder order = new OriginOrder();

        order.setStoreCode(storeCode);
        order.setOrderId(orderId);
        order.setOrderType(orderType);
        order.setOrderAddress(orderAddress);
        order.setOrderCreateTime(orderCreateTime);
        order.setOrderCompleteTime(orderCompleteTime);

        String json = new Gson().toJson(orderItemList);
        order.setOrderItemList(json);

        return order;
    }
}

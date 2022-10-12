package com.mandarinrobotics.externalorderserver.service;

import com.mandarinrobotics.externalorderserver.model.OriginOrder;
import com.mandarinrobotics.externalorderserver.repository.OriginOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class OriginOrderService {
    @Autowired
    private OriginOrderRepository originOrderRepository;

    public OriginOrder saveOriginOrder(OriginOrder originOrder) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        originOrder.setCreationMicrotime(Long.toString(timestamp.getTime() * 1000));
        originOrder.setUpdateMicrotime(Long.toString(timestamp.getTime() * 1000));
        return originOrderRepository.save(originOrder);
    }

    public OriginOrder updateOriginOrder(OriginOrder originOrder) {
        OriginOrder temp = originOrderRepository.findByOrderId(originOrder.getOrderId()).orElseThrow(() -> new RuntimeException());

        temp.setStoreCode(originOrder.getStoreCode());
        temp.setOrderType(originOrder.getOrderType());
        temp.setOrderAddress(originOrder.getOrderAddress());
        temp.setIsCanceled(originOrder.getIsCanceled());
        temp.setOrderItemList(originOrder.getOrderItemList());
        temp.setOrderCreateTime(originOrder.getOrderCreateTime());
        temp.setOrderCompleteTime(originOrder.getOrderCompleteTime());
        temp.setOrderCanceledTime(originOrder.getOrderCanceledTime());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        temp.setUpdateMicrotime(Long.toString(timestamp.getTime() * 1000));

        return originOrderRepository.save(temp);
    }

    public OriginOrder cancelOriginOrder(OriginOrder originOrder) {
        OriginOrder temp = originOrderRepository.findByOrderId(originOrder.getOrderId()).orElseThrow(() -> new RuntimeException());

        temp.setIsCanceled(1);
        temp.setOrderCanceledTime(originOrder.getOrderCanceledTime());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        temp.setUpdateMicrotime(Long.toString(timestamp.getTime() * 1000));

        return originOrderRepository.save(temp);
    }

    public OriginOrder doneOriginOrder(OriginOrder originOrder) {
        OriginOrder temp = originOrderRepository.findByOrderId(originOrder.getOrderId()).orElseThrow(() -> new RuntimeException());

        temp.setOrderCompleteTime(originOrder.getOrderCompleteTime());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        temp.setUpdateMicrotime(Long.toString(timestamp.getTime() * 1000));

        return originOrderRepository.save(temp);
    }
}

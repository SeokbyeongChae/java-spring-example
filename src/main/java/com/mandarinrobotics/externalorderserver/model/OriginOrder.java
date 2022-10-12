package com.mandarinrobotics.externalorderserver.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "origin_orders", uniqueConstraints={@UniqueConstraint(columnNames={"order_id"})})
public class OriginOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "store_code", nullable = false)
    private String storeCode;

    @Column(name = "order_id", unique = true, nullable = false)
    private String orderId;

    @Column(name = "order_type", nullable = false)
    private int orderType;

    @Column(name = "order_address", nullable = true)
    private String orderAddress;

    @Column(name = "is_canceled", nullable = true)
    private int isCanceled;

    @Column(name = "order_item_list", nullable = false)
    private String orderItemList;

    @Column(name = "order_create_time", nullable = false)
    private String orderCreateTime;

    @Column(name = "order_complete_time", nullable = false)
    private String orderCompleteTime;

    @Column(name = "order_canceled_time", nullable = true)
    private String orderCanceledTime;

    @Column(name = "creation_microtime", nullable = true)
    private String creationMicrotime;

    @Column(name = "update_microtime")
    private String updateMicrotime;
}

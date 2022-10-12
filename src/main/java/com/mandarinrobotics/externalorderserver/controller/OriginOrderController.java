package com.mandarinrobotics.externalorderserver.controller;

import com.mandarinrobotics.externalorderserver.dto.OriginOrderCancellationDto;
import com.mandarinrobotics.externalorderserver.dto.OriginOrderCompletedDto;
import com.mandarinrobotics.externalorderserver.dto.OriginOrderDto;
import com.mandarinrobotics.externalorderserver.service.OriginOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OriginOrderController {
    @Autowired
    private OriginOrderService originOrderService;

    @PostMapping
    public ResponseEntity<?> order(@RequestBody @Valid OriginOrderDto order) {
        try {
            originOrderService.saveOriginOrder(order.convertToOriginOrder());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage(), e);
        }

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateOrder(@RequestBody @Valid OriginOrderDto order) {
        System.out.println("test1");
        try {
            System.out.println("test2");
            originOrderService.updateOriginOrder(order.convertToOriginOrder());
        } catch (Exception e) {
            System.out.println("test3");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
        System.out.println("test4");

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping("/cancel")
    public ResponseEntity<?> cancelOrder(@RequestBody @Valid OriginOrderCancellationDto order) {
        try {
            originOrderService.cancelOriginOrder(order.convertToOriginOrder());
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping("/done")
    public ResponseEntity<?> doneOrder(@RequestBody @Valid OriginOrderCompletedDto order) {
        try {
            originOrderService.doneOriginOrder(order.convertToOriginOrder());
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}

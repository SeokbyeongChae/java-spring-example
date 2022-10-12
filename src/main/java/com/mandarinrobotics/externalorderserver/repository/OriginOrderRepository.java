package com.mandarinrobotics.externalorderserver.repository;

import com.mandarinrobotics.externalorderserver.model.OriginOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.Optional;

public interface OriginOrderRepository extends CrudRepository<OriginOrder, BigInteger> {
    boolean existsByOrderId(@Param("orderId") String orderId);

    Optional<OriginOrder> findByOrderId(@Param("orderId") String orderId);
}

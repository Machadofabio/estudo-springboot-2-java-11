package com.example.course.repositories;

import com.example.course.entities.Order;
import com.example.course.entities.User;
import com.example.course.exceptions.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@DataJpaTest
@DisplayName("Tests for OrderRepository")
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void test_findOrderById_whenSuccessful(){
        Order orderToBeSaved = createOrder();
        Order savedOrder = orderRepository.save(orderToBeSaved);

        Order order = this.orderRepository.findById(savedOrder.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order not found"));

        Assertions.assertNotNull(order);
        Assertions.assertEquals(order.getId(), 1L);
        Assertions.assertEquals(order.getMoment().toString(), "2022-01-14T22:00:00Z");
        Assertions.assertEquals(order.getClient().getName(), "usuario1");

    }

    private Order createOrder(){
        User user =  new User(null, "usuario1", "usuario1@gmail.com", "1133332222", "senhausuario");

        return new Order(null, Instant.parse("2022-01-14T22:00:00Z"), user);
    }


}
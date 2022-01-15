package com.example.course.config;

import com.example.course.entities.Category;
import com.example.course.entities.Order;
import com.example.course.entities.User;
import com.example.course.entities.enums.OrderStatus;
import com.example.course.repositories.CategoryRepository;
import com.example.course.repositories.OrderRepository;
import com.example.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas Gonçalves", "lucas.goncalves@hotmail.com", "19982788922", "senhalucas");
        User u2 = new User(null, "Leonardo Oliveira", "leonardo.oliveira@hotmail.com", "19988578852", "senhaleo");
        User u3 = new User(null, "Danilo Ferri", "danilo.ferri@hotmail.com", "19998573966", "senhadanilo");
        User u4 = new User(null, "Alexander Marques", "alexander.marques@hotmail.com", "19988552020", "senhaalex");
        User u5 = new User(null, "Carlos Campos", "carlos.campos@hotmail.com", "1982909088", "senhacarlos");
        User u6 = new User(null, "Nicolas Chinaglia", "nicolas.chinaglia@hotmail.com", "19971521141", "senhanicolas");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, u2);
        Order o3 = new Order(null, Instant.parse("2019-08-22T15:21:22Z"), OrderStatus.PAID, u3);
        Order o4 = new Order(null, Instant.parse("2019-09-20T19:53:07Z"), OrderStatus.DELIVERED, u4);
        Order o5 = new Order(null, Instant.parse("2019-10-21T03:42:10Z"), OrderStatus.DELIVERED, u5);
        Order o6 = new Order(null, Instant.parse("2019-11-22T15:21:22Z"), OrderStatus.SHIPPED, u6);
        Order o7 = new Order(null, Instant.parse("2019-12-20T19:53:07Z"), OrderStatus.CANCELED, u1);
        Order o8 = new Order(null, Instant.parse("2020-01-21T03:42:10Z"), OrderStatus.SHIPPED, u1);
        Order o9 = new Order(null, Instant.parse("2020-02-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u2);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5, o6, o7, o8, o9));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }

}

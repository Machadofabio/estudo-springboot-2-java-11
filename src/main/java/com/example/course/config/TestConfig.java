package com.example.course.config;

import com.example.course.entities.*;
import com.example.course.entities.enums.OrderStatus;
import com.example.course.repositories.*;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

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

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5, o6, o7, o8, o9));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }

}

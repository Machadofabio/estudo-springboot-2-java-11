package com.example.course.config;

import com.example.course.entities.User;
import com.example.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas Gonçalves", "lucas.goncalves@hotmail.com", "19982788922", "senhalucas");
        User u2 = new User(null, "Leonardo Oliveira", "leonardo.oliveira@hotmail.com", "19988578852", "senhaleo");
        User u3 = new User(null, "Danilo Ferri", "danilo.ferri@hotmail.com", "19998573966", "senhadanilo");
        User u4 = new User(null, "Alexander Marques", "alexander.marques@hotmail.com", "19988552020", "senhaalex");
        User u5 = new User(null, "Carlos Campos", "carlos.campos@hotmail.com", "1982909088", "senhacarlos");
        User u6 = new User(null, "Nicolas Chinaglia", "nicolas.chinaglia@hotmail.com", "19971521141", "senhanicolas");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
    }
}

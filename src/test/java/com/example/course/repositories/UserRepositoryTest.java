package com.example.course.repositories;

import com.example.course.entities.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;


@DataJpaTest
@DisplayName("Tests for UserRepository")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void test_findUserById_whenSuccessful(){
        User userToBeSaved = createUser();
        User savedUser = userRepository.save(userToBeSaved);

        Optional<User> user = this.userRepository.findById(savedUser.getId());

        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.get().getId()).isEqualTo(1L);
        Assertions.assertThat(user.get().getName()).isEqualTo("usuario1");

    }

    private User createUser(){
        return new User(null, "usuario1", "usuario1@gmail.com", "1133332222", "senhausuario");
    }
}
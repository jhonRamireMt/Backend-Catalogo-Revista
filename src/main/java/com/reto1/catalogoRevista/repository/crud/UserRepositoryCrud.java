package com.reto1.catalogoRevista.repository.crud;

import com.reto1.catalogoRevista.model.User;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepositoryCrud extends CrudRepository<User,Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);


}

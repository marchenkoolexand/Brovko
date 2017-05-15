package com.brovko.service;

import com.brovko.domain.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    User getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(User user);
}

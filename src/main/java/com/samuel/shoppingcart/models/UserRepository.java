package com.samuel.shoppingcart.models;

import com.samuel.shoppingcart.models.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
  User findByUsername(String username);
}

package com.samuel.shoppingcart.models;

import com.samuel.shoppingcart.models.data.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
  Category findByName(String name);
}

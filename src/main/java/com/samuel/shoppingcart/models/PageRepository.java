package com.samuel.shoppingcart.models;

import com.samuel.shoppingcart.models.data.Page;
import org.springframework.data.jpa.repository.JpaRepository;

// Page Entity (PK: int Id) 를 위한 repository
public interface PageRepository extends JpaRepository<Page, Integer> {
  Page findBySlug(String slug);
}

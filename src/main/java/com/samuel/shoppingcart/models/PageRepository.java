package com.samuel.shoppingcart.models;

import com.samuel.shoppingcart.models.data.Page;
import org.springframework.data.jpa.repository.JpaRepository;

// Page Entity (PK: int Id) 를 위한 repository
public interface PageRepository extends JpaRepository<Page, Integer> {
  Page findBySlug(String slug);

  // @Query("SELECT p from Page p WHERE p.id != :id and p.slug = :slug")
  // Page findBySlug(int id, String slug);

  // 수정하는 page를 제외한 다른 page들의 slug와 중복 체크
  Page findBySlugAndIdNot(String slug, int id);
}

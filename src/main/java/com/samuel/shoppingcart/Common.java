package com.samuel.shoppingcart;

import com.samuel.shoppingcart.models.CategoryRepository;
import com.samuel.shoppingcart.models.PageRepository;
import com.samuel.shoppingcart.models.data.Category;
import com.samuel.shoppingcart.models.data.Page;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class Common {
  private PageRepository pageRepo;

  private CategoryRepository categoryRepo;

  public Common(PageRepository pageRepo, CategoryRepository categoryRepo) {
    this.pageRepo = pageRepo;
    this.categoryRepo = categoryRepo;
  }

  @ModelAttribute
  public void sharedData(Model model) {
    List<Page> pages = pageRepo.findAllByOrderBySortingAsc();

    List<Category> categories = categoryRepo.findAll();

    model.addAttribute("cpages", pages);
    model.addAttribute("categories", categories);
  }
}

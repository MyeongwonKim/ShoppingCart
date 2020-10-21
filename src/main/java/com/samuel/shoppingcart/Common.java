package com.samuel.shoppingcart;

import com.samuel.shoppingcart.models.Cart;
import com.samuel.shoppingcart.models.CategoryRepository;
import com.samuel.shoppingcart.models.PageRepository;
import com.samuel.shoppingcart.models.data.Category;
import com.samuel.shoppingcart.models.data.Page;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@SuppressWarnings("unchecked")
public class Common {
  private PageRepository pageRepo;

  private CategoryRepository categoryRepo;

  public Common(PageRepository pageRepo, CategoryRepository categoryRepo) {
    this.pageRepo = pageRepo;
    this.categoryRepo = categoryRepo;
  }

  @ModelAttribute
  public void sharedData(Model model, HttpSession session) {
    List<Page> pages = pageRepo.findAllByOrderBySortingAsc();

    List<Category> categories = categoryRepo.findAll();

    boolean cartActive = false;

    if (session.getAttribute("cart") != null) {
      HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute(
        "cart"
      );

      int size = 0;
      double total = 0;

      for (Cart value : cart.values()) {
        size += value.getQuantity();
        total += value.getQuantity() * Double.parseDouble(value.getPrice());
      }

      model.addAttribute("csize", size);
      model.addAttribute("ctotal", total);

      cartActive = true;
    }

    model.addAttribute("cpages", pages);
    model.addAttribute("categories", categories);
    model.addAttribute("cartActive", cartActive);
  }
}

package com.samuel.shoppingcart.controllers;

import com.samuel.shoppingcart.models.PageRepository;
import com.samuel.shoppingcart.models.data.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeController {
  @Autowired
  private PageRepository pageRepo;

  @GetMapping("/admin")
  public String index(Model model) {
    List<Page> pages = pageRepo.findAllByOrderBySortingAsc();

    model.addAttribute("pages", pages);

    return "admin/pages/index";
  }
}

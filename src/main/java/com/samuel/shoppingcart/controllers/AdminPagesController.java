package com.samuel.shoppingcart.controllers;

import com.samuel.shoppingcart.models.PageRepository;
import com.samuel.shoppingcart.models.data.Page;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// 해당 class 내의 method들은 /admin/pages로 시작하는 url로 요청됨
@RequestMapping("/admin/pages")
public class AdminPagesController {
  private PageRepository pageRepo;

  public AdminPagesController(PageRepository pageRepo) {
    this.pageRepo = pageRepo;
  }

  @GetMapping
  public String index(Model model) {
    List<Page> pages = pageRepo.findAll();

    model.addAttribute("pages", pages);

    return "admin/pages/index";
  }
}

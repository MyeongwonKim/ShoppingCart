package com.samuel.shoppingcart.controllers;

import com.samuel.shoppingcart.models.PageRepository;
import com.samuel.shoppingcart.models.data.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PagesController {
  private PageRepository pageRepo;

  public PagesController(PageRepository pageRepo) {
    this.pageRepo = pageRepo;
  }

  @GetMapping
  public String home(Model model) {
    Page page = pageRepo.findBySlug("home");
    model.addAttribute("page", page);
    return "page";
  }

  @GetMapping("/{slug}")
  public String page(@PathVariable String slug, Model model) {
    Page page = pageRepo.findBySlug(slug);

    if (page == null) {
      return "redirect:/";
    }

    model.addAttribute("page", page);

    return "page";
  }
}

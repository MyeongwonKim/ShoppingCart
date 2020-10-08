package com.samuel.shoppingcart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// 해당 class 내의 method들은 /admin/pages로 시작하는 url로 요청됨
@RequestMapping("/admin/pages")
public class AdminPagesController {

  @GetMapping
  public String index() {
    return "admin/pages/index";
  }
}

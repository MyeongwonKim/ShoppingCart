package com.samuel.shoppingcart.security;

import com.samuel.shoppingcart.models.UserRepository;
import com.samuel.shoppingcart.models.data.User;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
  private UserRepository userRepo;

  public RegistrationController(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping
  public String register(User user) {
    return "register";
  }

  @PostMapping
  public String register(
    @Valid User user,
    BindingResult bindingResult,
    Model model
  ) {
    if (bindingResult.hasErrors()) {
      return "register";
    }

    if (validateUsernameDuplication(user.getUsername())) {
      model.addAttribute("usernameDuplication", "Username already exists!");
      return "register";
    }

    if (!user.getPassword().equals(user.getConfirmPassword())) {
      model.addAttribute("passwordMatchProblem", "Passwords do not match!");
      return "register";
    }

    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepo.save(user);

    return "redirect:/login";
  }

  private boolean validateUsernameDuplication(String username) {
    User user = userRepo.findByUsername(username);
    if (user != null) {
      return true;
    }
    return false;
  }
}

package org.launchcode.uTrain.controllers;

import org.launchcode.uTrain.data.UserRepository;
import org.launchcode.uTrain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {

    AuthenticationController authenticationController;

    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return null;
        }
        return  user.get();
    }

    @Autowired
    UserRepository userRepository;

    @GetMapping("index")
    public String userIndexPage(HttpServletRequest request, Model model) {

        User user = (User) getUserFromSession(request.getSession());

        model.addAttribute("title", "Welcome!!");
        model.addAttribute("user", user);

        return "user/index";
    }
}

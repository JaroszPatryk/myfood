package pl.pjaroszcompany.myfood.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.pjaroszcompany.myfood.domain.user.User;
import pl.pjaroszcompany.myfood.domain.user.UserService;

@Controller
@RequestMapping("/mvc/register")
@RequiredArgsConstructor
public class UserControlller {


    private final UserService userService;

    @GetMapping
    public ModelAndView displayRegisterPage() {
        ModelAndView mav = new ModelAndView("register.html");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping
    public String handleUserRegistration(@ModelAttribute User user) {
        userService.register(user);
        return "redirect:/login";
    }

}

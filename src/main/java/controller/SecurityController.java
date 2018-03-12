package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    @RequestMapping("/login")
    public void login() {
        //return "login";
    }












    @RequestMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}

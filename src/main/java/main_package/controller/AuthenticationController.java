package main_package.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @GetMapping("/main")
    public String getMainPage(){
        return "main_page";
    }

    @GetMapping("/admin_page")
    public String getAdminPage(){
        return "admin_page";
    }

    @GetMapping("/user_page")
    public String getUserPage(){
        return "user_page";
    }

}

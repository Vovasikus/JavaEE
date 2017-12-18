package ru.housemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.housemanagement.dao.ColdwatercounterJdbcDAO;
import ru.housemanagement.service.UserService;
import ru.housemanagement.service.ColdwatercounterService;


@Controller
@RequestMapping("/")
public class HMController {

    @Autowired
    private UserService userService;

    @Autowired
    private ColdwatercounterService coldwatercounterService;

    @RequestMapping
    public String mainPage(Model model) {
        model.addAttribute("message", "Hi");
        return "main";
    }

    @RequestMapping(value = "/users")
    public String usersPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    /*@RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }*/

    @RequestMapping(value = "/users/vols")
    public String usersVol(Model model) {
        model.addAttribute("vols", coldwatercounterService.returnVol());
        return "vols";
    }

}

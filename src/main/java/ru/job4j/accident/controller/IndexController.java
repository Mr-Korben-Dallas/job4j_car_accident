package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        List<String> strings = Arrays.asList(
                "lubas cadunt!",
                "guttuss persuadere!",
                "accentors experimentum!",
                "lubas volare!",
                "extums ortum!"
        );
        model.addAttribute("strings", strings);
        return "index";
    }
}

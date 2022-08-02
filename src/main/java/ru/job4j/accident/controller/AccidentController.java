package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;

@Controller
public class AccidentController {
    private final AccidentService service;

    public AccidentController(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public String add() {
        return "accident/add";
    }

    @PostMapping("/createOrUpdate")
    public String createOrUpdate(@ModelAttribute Accident accident) {
        service.createOrUpdate(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {
        if (service.findById(id).isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("accident", service.findById(id).get());
        return "accident/update";
    }
}

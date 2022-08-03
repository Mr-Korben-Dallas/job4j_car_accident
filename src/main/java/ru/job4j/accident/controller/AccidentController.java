package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;
import ru.job4j.accident.service.AccidentTypeService;

@Controller
public class AccidentController {
    private final AccidentService service;
    private final AccidentTypeService accidentTypeService;

    public AccidentController(AccidentService service, AccidentTypeService accidentTypeService) {
        this.service = service;
        this.accidentTypeService = accidentTypeService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("types", accidentTypeService.findAll());
        return "accident/add";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Accident accident) {
        service.create(accident);
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

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident) {
        service.update(accident);
        return "redirect:/";
    }
}

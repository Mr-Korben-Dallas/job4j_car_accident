package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.service.AccidentService;
import ru.job4j.accident.service.AccidentTypeService;
import ru.job4j.accident.service.RuleService;
import java.util.ArrayList;
import java.util.Set;

@Controller
public class AccidentController {
    private final AccidentService service;
    private final AccidentTypeService accidentTypeService;
    private final RuleService ruleService;

    public AccidentController(AccidentService service, AccidentTypeService accidentTypeService, RuleService ruleService) {
        this.service = service;
        this.accidentTypeService = accidentTypeService;
        this.ruleService = ruleService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("rules", ruleService.findAll());
        model.addAttribute("types", accidentTypeService.findAll());
        return "accident/add";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Accident accident, @RequestParam(name = "ruleIds", required = false) ArrayList<Long> ruleIds) {
        if (ruleIds != null) {
            Set<Rule> rules = ruleService.fetchByIds(ruleIds);
            if (!rules.isEmpty()) {
                accident.addRules(rules);
            }
        }
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

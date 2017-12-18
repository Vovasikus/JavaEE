package ru.housemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import ru.housemanagement.model.Metric;

import ru.housemanagement.service.MetricService;
import ru.housemanagement.service.OwnerService;

@Controller
public class HMController {

    @Autowired
    private MetricService metricService;

    @Autowired
    private OwnerService ownerService;

    @RequestMapping({"/home", "/"})
    public String home(Model model) {

        model.addAttribute("name", ownerService.getUsername());

        return "/home";
    }

    @RequestMapping(value="/login")
    public String login() {
       return "login";
    }

    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }

    @RequestMapping(value = "/metrics")
    public String usersPage(Model model) {
        model.addAttribute("metrics", metricService.getAllMetrics());
        return "metrics";
    }

    @RequestMapping(value = "/entermetrics")
    public String enterMetrics (Model model) {
        model.addAttribute("metric", new Metric());
        return "entermetrics";
    }


    @RequestMapping(value = "/entermetrics/submit", method = RequestMethod.GET)
    public String submitMetrics (@ModelAttribute Metric metric) {
        metricService.saveMetric(metric);
        return "entermetrics";
    }

    @RequestMapping(value = "mymetrics", method = RequestMethod.GET)
    public String myMetrics(Model model) {
        model.addAttribute("mymetrics", metricService.getMetricByOwner(ownerService.getUsername()));
        return "mymetrics";
    }
}

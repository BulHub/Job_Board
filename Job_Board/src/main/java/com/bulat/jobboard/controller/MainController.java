package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.Candidate;
import com.bulat.jobboard.model.Company;
import com.bulat.jobboard.model.State;
import com.bulat.jobboard.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Controller for working with the main page of the site
 * @author Bulat Bilalov
 * @version 1.0
 */
@Controller
@RequestMapping({"/", "/index"})
public class MainController {

    private final CompanyService companyService;
    private final CityService cityService;
    private final SkillService skillService;
    private final CandidateService candidateService;


    @Autowired
    public MainController(CompanyService companyService, CityService cityService,
                          SkillService skillService, CandidateService candidateService) {
        this.companyService = companyService;
        this.cityService = cityService;
        this.skillService = skillService;
        this.candidateService = candidateService;
    }

    /**
     * Method for displaying the main page of the site
     * @param model Page model
     */
    @GetMapping
    public String getMain(Map<String, Object> model){
        List<Company> companies = IntStream.range(0, 5)
                .mapToObj(companyService.findAll()::get).collect(Collectors.toList());
        List<Candidate> candidates = IntStream.range(0, 12)
                .mapToObj(candidateService.findAll()::get).collect(Collectors.toList());
        model.put("companies", companies);
        model.put("candidates", candidates);
        model.put("cities", cityService.findAll());
        model.put("skills", skillService.findAll());
        model.put("comments", commentService.findByStatus(State.ACTIVE));
        return "index";
    }

    /**
     * Method for sending to the page where the candidate can find a job
     */
    @PostMapping
    public String findJob(){
        return "redirect:/jobs";
    }
}

package com.bulat.jobboard.controller;

import com.bulat.jobboard.model.*;
import com.bulat.jobboard.service.CompanyService;
import com.bulat.jobboard.utils.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.bulat.jobboard.utils.Filter;

/**
 * Company search controller for various parameters
 * @author Bulat Bilalov
 * @version 1.0
 */
@Controller
@RequestMapping("/jobs")
public class FindJobForStudentsController {

    private final CompanyService companyService;
    private final Attributes attributes;
    private final Filter filter;

    @Autowired
    public FindJobForStudentsController(CompanyService companyService, Attributes attributes, Filter filter) {
        this.companyService = companyService;
        this.attributes = attributes;
        this.filter = filter;
    }

    /**
     * Method of obtaining all companies
     * @param model Page model
     */
    @GetMapping
    public String getCompanies(Map<String, Object> model) {
        model.put("companies", companyService.findAll());
        attributes.addAttributesForCompanies(model);
        return "jobs";
    }

    /**
     * Company search method for various parameters
     * @param model Page model
     * @param company The company whose fields will be searched
     */
    @PostMapping
    public String sortForCompany(Map<String, Object> model, Company company) {
        List<Company> companies = companyService.findAll();
        attributes.addAttributesForCompanies(model);
        List<Company> preResult = (List<Company>) filter.findByCountryAndCityAndSkillAndGender(companies, company);
        List<Company> result = filter.findByExperienceAndJobNatureAndNameAndAgeAndSalary(preResult, company);
        model.put("companies", result);
        return "jobs";
    }
}

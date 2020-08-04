package com.bulat.jobboard.utils;

import com.bulat.jobboard.model.*;
import com.bulat.jobboard.service.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@Component
public class Attributes {

    private final CityService cityService;
    private final CountryService countryService;
    private final SkillService skillService;
    private final EducationService educationService;
    private final LanguageService languageService;

    @Autowired
    public Attributes(CityService cityService, CountryService countryService, SkillService skillService,
                      EducationService educationService, LanguageService languageService) {
        this.cityService = cityService;
        this.countryService = countryService;
        this.skillService = skillService;
        this.educationService = educationService;
        this.languageService = languageService;
    }

    public static void addSuccessAttributes(@NotNull ModelMap map, String message) {
        map.addAttribute("title", "Good job!");
        map.addAttribute("message", message.isEmpty() ? "Success!" : message);
        map.addAttribute("category", "success");
    }

    public static void addErrorAttributes(@NotNull ModelMap map, String message) {
        map.addAttribute("title", "Oops!");
        map.addAttribute("message", message.isEmpty() ? "Error!" : message);
        map.addAttribute("category", "error");
    }

    public static void addSuccessAttributesWithFlash(@NotNull RedirectAttributes redirectAttributes, String message){
        redirectAttributes.addFlashAttribute("title", "Good job!");
        redirectAttributes.addFlashAttribute("message", message.isEmpty() ? "Success!" : message);
        redirectAttributes.addFlashAttribute("category", "success");
    }

    public static void addErrorAttributesWithFlash(@NotNull RedirectAttributes redirectAttributes, String message){
        redirectAttributes.addFlashAttribute("title", "Oops!");
        redirectAttributes.addFlashAttribute("message", message.isEmpty() ? "Error!" : message);
        redirectAttributes.addFlashAttribute("category", "error");
    }

    public static void addAttributesForEntity(BaseEntity baseEntity) {
        baseEntity.setStatus(State.ACTIVE);
        baseEntity.setCreated(new Date());
        baseEntity.setUpdated(new Date());
    }

    public void addAttributes(@NotNull Map<String, Object> model){
        model.put("countries", countryService.findAll());
        model.put("cities", cityService.findAll());
        model.put("skills", skillService.findAll());
        model.put("genders", Arrays.asList(Gender.values()));
    }

    public void addAttributesForCandidates(@NotNull Map<String, Object> model){
        addAttributes(model);
        model.put("educations", educationService.findAll());
        model.put("languages", languageService.findAll());
    }

    public void addAttributesForCompanies(Map<String, Object> model){
        addAttributes(model);
        model.put("jobNature", Arrays.asList(JobNature.values()));
        model.put("experiences",Arrays.asList(Experience.values()));
    }
}

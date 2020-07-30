package com.bulat.jobboard.utils;

import com.bulat.jobboard.model.BaseEntity;
import com.bulat.jobboard.model.State;
import com.bulat.jobboard.service.CityService;
import com.bulat.jobboard.service.CountryService;
import com.bulat.jobboard.service.SkillService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.util.Date;
import java.util.Map;

@Component
public class Attributes {

    private final CityService cityService;
    private final CountryService countryService;
    private final SkillService skillService;

    @Autowired
    public Attributes(CityService cityService, CountryService countryService, SkillService skillService) {
        this.cityService = cityService;
        this.countryService = countryService;
        this.skillService = skillService;
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

    public static void addAttributesForEntity(BaseEntity baseEntity) {
        baseEntity.setStatus(State.ACTIVE);
        baseEntity.setCreated(new Date());
        baseEntity.setUpdated(new Date());
    }

    public void addAttributes(@NotNull Map<String, Object> model){
        model.put("countries", countryService.findAll());
        model.put("cities", cityService.findAll());
        model.put("skills", skillService.findAll());
    }
}

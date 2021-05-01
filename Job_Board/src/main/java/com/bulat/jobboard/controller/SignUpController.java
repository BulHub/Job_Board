package com.bulat.jobboard.controller;

import com.bulat.jobboard.dto.CaptchaResponseDto;
import com.bulat.jobboard.model.User;
import com.bulat.jobboard.service.UserService;
import com.bulat.jobboard.utils.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Objects;

/**
 * Controller for processing registration on the site
 * @author Bulat Bilalov
 * @version 1.0
 */
@Controller
@RequestMapping("/signUp")
public class SignUpController {
    private final static String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";

    private final RestTemplate restTemplate;
    private final UserService userService;

    @Value("${recaptcha.secret}")
    private String secret;

    @Autowired
    public SignUpController(RestTemplate restTemplate, UserService userService) {
        this.restTemplate = restTemplate;
        this.userService = userService;
    }

    /** Method for getting registration page */
    @GetMapping
    public String getRegistration(){
        return "signUp";
    }

    /**
     * Registration method
     * @param user Filled user
     * @param result Form validation object
     * @param model Page model
     * @param captchaResponse Raised value for captcha
     */
    @PostMapping
    public String signUp(User user, BindingResult result, ModelMap model,
                         @RequestParam("g-recaptcha-response") String captchaResponse){
        StringBuilder error = errorChecking(captchaResponse, result);
        if (error.length() == 0){
            Attributes.addSuccessAttributes(model, "A confirmation letter will come to your mail soon!");
            userService.signUp(user);
        }else{
            Attributes.addErrorAttributes(model, String.valueOf(error));
        }
        return "/signUp";
    }

    /**
     * Registration error checking method
     * @param captchaResponse Raised value for captcha
     * @param result Form validation object
     */
    private StringBuilder errorChecking(String captchaResponse, BindingResult result){
        StringBuilder builder = new StringBuilder();
        String url = String.format(CAPTCHA_URL, secret, captchaResponse);
        CaptchaResponseDto response = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDto.class);
        if (!Objects.requireNonNull(response).isSuccess()) {
            builder.append("Fill captcha! ");
        }
        if (result.hasErrors()) {
            builder.append("This mail is already taken! ");
        }
        return builder;
    }
}

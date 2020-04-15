package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute("registration") Registration registration) {
        return "registration"; //this string is resolved to the registration.jsp page via the internal view resolver. This is unlike user class where we return an instance of User as a rest reply.
    }

    @PostMapping("registration")
    public String addRegistration(@Valid @ModelAttribute("registration") Registration registration, BindingResult result) {
        //if we have an error, we can change the navigation for that error
        if(result.hasErrors()) {
            System.out.println("There were errors"); //just to show that there are errors when you execute the page.
            return "registration";
        }
        System.out.println("registration: " + registration.getName());
        return "redirect:registration"; //the redirect does the post-redirect-get redirect system. this ensures that the data is safe and doesn't re-write over data already stored. this line in general refers to registration.jsp page i WEB-INF folder which it gets from the application.properties file in "static" folder. It knows to do this becomes of the @springbootapplication  in ConfereneceApplication.java
    }
}

package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(@RequestParam(value = "firstname", defaultValue = "Justin") String firstName,
                        @RequestParam(value = "lastname", defaultValue = "Kinner") String lastName,
                        @RequestParam(value = "age", defaultValue = "37") int age) {
        //obviously this isn't how you would normally do this. Normally you would have a service connected to your DB, which returns something from the repository.
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);

        return user; //returns the body to the caller.
    }

}

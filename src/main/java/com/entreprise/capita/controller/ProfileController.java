package com.entreprise.capita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfileController {

    @Autowired
    private Environment environment;

    @GetMapping("/profile")
    public String getActiveProfile() {
        String[] activeProfiles = environment.getActiveProfiles();

        if (activeProfiles.length == 0) {
            return "Aucun profil actif.";
        } else {
            return "Profil actif : " + String.join(", ", activeProfiles);
        }
    }
}

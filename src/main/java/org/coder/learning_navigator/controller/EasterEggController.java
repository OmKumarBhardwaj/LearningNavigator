package org.coder.learning_navigator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EasterEggController {

    @GetMapping("/hidden-feature/{number}")
    public String getNumberFact(@PathVariable int number) {
        RestTemplate restTemplate = new RestTemplate();
        String factUrl = "http://numbersapi.com/" + number;
        return restTemplate.getForObject(factUrl, String.class);
    }
}

package com.aakash.logging.learning.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String getMethodName() {
        return "This is Aakash Here";
    }
    
    
}

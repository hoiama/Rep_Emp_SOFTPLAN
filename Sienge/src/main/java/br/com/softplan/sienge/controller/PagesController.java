package br.com.softplan.sienge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PagesController {

    @GetMapping("/home")
    public String getIndex() {
        System.out.println("Index.html");
        return "pages/index.html";
    }
}

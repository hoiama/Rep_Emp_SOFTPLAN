package br.com.softplan.sienge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PagesController {


    /**
     * Get main page of aplication
     * @return double value os the cost
     */
    @GetMapping("")
    public String getIndex() {
        System.out.println("Index.html");
        return "pages/index.html";
    }
}

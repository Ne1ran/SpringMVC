package ru.neiran.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        //System.out.println("Hello! " + name + " " + surname);
        model.addAttribute("message","Hello! " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String gbPage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator (@RequestParam(value = "n1", required = false) String n1,
                              @RequestParam(value = "n2", required = false) String n2,
                              @RequestParam(value = "operation", required = false) String operation,
                              Model model){
        try {
            if (operation.equals("multiplication")) {
                model.addAttribute("numbers", Float.parseFloat(n1) * Float.parseFloat(n2));
            } else if (operation.equals("addition")) {
                model.addAttribute("numbers", Float.parseFloat(n1) + Float.parseFloat(n2));
            } else if (operation.equals("subtraction")) {
                model.addAttribute("numbers", Float.parseFloat(n1) - Float.parseFloat(n2));
            } else if (operation.equals("division")) {
                model.addAttribute("numbers", Float.parseFloat(n1) / Float.parseFloat(n2));
            } else model.addAttribute("numbers", "Operation type mistake(((");
        } catch (Exception e){
            model.addAttribute("numbers", "Mistakes(");
        }
        return "/first/calculator";
    }
}

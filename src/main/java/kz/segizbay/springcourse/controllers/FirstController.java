package kz.segizbay.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {
        double result;
        switch (action) {
            case "add":
                result = a + b;
                model.addAttribute("result", a + " + " + b + " = " + result);
                break;
            case "sub":
                result = a - b;
                model.addAttribute("result", a + " - " + b + " = " + result);
                break;
            case "mul":
                result = a * b;
                model.addAttribute("result", a + " * " + b + " = " + result);
                break;
            case "div":
                result = a / (double)b;
                model.addAttribute("result", a + " / " + b + " = " + result);
                break;

        }
        return "first/calculator";
    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false ) String surname,
                            Model model){
        model.addAttribute("message", "Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
}

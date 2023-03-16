package by.levitsky.springcourse.controllers;

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
                            Model model) {

        model.addAttribute("message", "Hello, " + name + " " + surname);
        // System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "operation", required = false) String operation,
                            Model model) {
        double result;
        switch (operation) {
            case "add": {
                result = a + b;
                break;
            }
            case "sub": {
                result = a - b;
                break;
            }
            case "mult": {
                result = a * b;
                break;
            }
            case "div": {
                result = a / (double) b;
                break;
            }
            default: {
                result = 0;
                break;
            }
        }

        model.addAttribute("result", result);

        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}

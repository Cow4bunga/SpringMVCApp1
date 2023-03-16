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
    public String calculate(@RequestParam(value = "a", required = false) String a,
                            @RequestParam(value = "b", required = false) String b,
                            @RequestParam(value = "operation", required = false) String operation,
                            Model model) {
        String result = null;
        switch (operation) {
            case "add": {
                result = String.valueOf(Integer.valueOf(a) + Integer.valueOf(b));
                break;
            }
            case "sub": {
                result = String.valueOf(Integer.valueOf(a) - Integer.valueOf(b));
                break;
            }
            case "mult": {
                result = String.valueOf(Integer.valueOf(a) * Integer.valueOf(b));
                break;
            }
            case "div": {
                result = String.valueOf(Integer.valueOf(a) / Integer.valueOf(b));
                break;
            }
            default:
                break;
        }

        model.addAttribute("result", result);

        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}

package my.springcourse.mvc.controllers;

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
    public String helloPage(HttpServletRequest request, Model model){
        String name = request.getParameter("name");             //null если не указан в запросе
        String surname = request.getParameter("surname");       //null если не указан в запросе

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname) {
        System.out.println("Bye bye, " + name + " " + surname);

        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(HttpServletRequest request, Model model) {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String op = request.getParameter("action");
        int valA = 0;
        int valB = 0;

        String result = "";
        if (op != null && a != null && b != null) {
            switch (op) {
                case "multiplication":
                    valA = Integer.parseInt(a);
                    valB = Integer.parseInt(b);
                    result = String.format("%d * %d = %d", valA, valB, valA * valB);
                    break;
                case "addition":
                    valA = Integer.parseInt(a);
                    valB = Integer.parseInt(b);
                    result = String.format("%d + %d = %d", valA, valB, valA + valB);
                    break;
                case "substraction":
                    valA = Integer.parseInt(a);
                    valB = Integer.parseInt(b);
                    result = String.format("%d - %d = %d", valA, valB, valA - valB);
                    break;
                case "division":
                    valA = Integer.parseInt(a);
                    valB = Integer.parseInt(b);
                    result = String.format("%d / %d = %f", valA, valB, valA / (double) valB);
                    break;
                default:
                    result = "Wrong operation param";
            }
        } else result = "No input params";

        model.addAttribute("result", result);
        return "first/calculator";
    }
}

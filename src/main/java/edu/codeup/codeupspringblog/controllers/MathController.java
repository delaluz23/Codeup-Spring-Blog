package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/math")
public class MathController {

    @GetMapping("/{method}/{num1}/{methodFix}/{num2}")
    @ResponseBody
    public String distanceFromTelve(@PathVariable String method, @PathVariable int num1, @PathVariable String methodFix, @PathVariable int num2) {
        if (method.equalsIgnoreCase("add") && methodFix.equalsIgnoreCase("and")) {
            return String.format("%s + %s = %s", num1, num2, num1 + num2);
        } else if (method.equalsIgnoreCase("subtract") && methodFix.equalsIgnoreCase("from")) {
            return String.format("%s - %s = %s", num1, num2, num1 - num2);
        } else if (method.equalsIgnoreCase("multiply") && methodFix.equalsIgnoreCase("and")) {
            return String.format("%s * %s = %s", num1, num2, num1 * num2);
        } else if (method.equalsIgnoreCase("divide") && methodFix.equalsIgnoreCase("by")) {
            return String.format("%s / %s = %s", num1, num2, num1 / num2);
        } else {
            return "missing valid inputs";
        }
    }
}

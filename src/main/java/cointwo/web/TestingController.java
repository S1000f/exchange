package cointwo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestingController {

    @RequestMapping("/test")
    public String testing() {
        return "test/test";
    }


}

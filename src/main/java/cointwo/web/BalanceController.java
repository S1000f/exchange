package cointwo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/balance")
public class BalanceController {

    @RequestMapping("/profit")
    public String balance() {

        return "balance/profit";
    }

    @RequestMapping("/transactionHistory")
    public String history() {

        return "balance/transactionHistory";
    }


}

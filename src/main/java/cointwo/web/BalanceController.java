package cointwo.web;

import cointwo.domain.account.AccountDao;
import cointwo.service.account.AccountService;
import cointwo.service.member.AuthService;
import cointwo.web.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    private AuthService authService;
    @Autowired
    AccountService accountService;
    @Autowired
    AccountDao accountDao;

    @GetMapping("/profit")
    public String profit(Model model) {

        AccountDto accountDto = accountDao.selectByUid(authService.getSessionUid());
        model.addAttribute("accountDto", accountDto);

        return "balance/profit";
    }

    @RequestMapping("/transactionHistory")
    public String history() {

        return "balance/transactionHistory";
    }


}

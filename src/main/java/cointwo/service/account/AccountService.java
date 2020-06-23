package cointwo.service.account;

import cointwo.domain.account.AccountDao;
import cointwo.web.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountService {

    private final int MONEY_FOR_TEST = 100_000_000;
    @Autowired
    private AccountDao accountDao;

    public Long createInitAccount(Long uid) {

        AccountDto accountDto = AccountDto.builder()
                .uid(uid)
                .tender(MONEY_FOR_TEST)
                .btc(0.0)
                .eth(0.0)
                .status("valid")
                .build();

        accountDao.createAccount(accountDto);

        return accountDto.getAid();
    }

}

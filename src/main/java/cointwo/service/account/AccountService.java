package cointwo.service.account;

import cointwo.domain.account.AccountDao;
import cointwo.web.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public Long createInitAccount(Long uid) {

        AccountDto accountDto = AccountDto.builder()
                .uid(uid)
                .tender(100_000_000)
                .status("valid")
                .build();

        accountDao.createAccount(accountDto);

        return accountDto.getAid();
    }

}

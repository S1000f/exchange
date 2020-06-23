package cointwo.web;

import cointwo.service.account.AccountService;
import cointwo.service.member.DuplicateMemberException;
import cointwo.service.member.MemberRegisterService;
import cointwo.web.dto.RegisterCommand;
import cointwo.web.validator.RegisterCommandValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private MemberRegisterService memberRegisterService;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/register/step1")
    public String register(RegisterCommand registerCommand) {

        return "register/step1";
    }

    @GetMapping
    public String redirect() {
        return "redirect:/register/step1";
    }

    @PostMapping("/register/step2")
    public String registerProceed(@Valid RegisterCommand registerCommand, Errors errors) {
        new RegisterCommandValidator().validate(registerCommand, errors);
        if(errors.hasErrors()) {
            return "register/step1";
        }

        try {
            Long uid = memberRegisterService.regist(registerCommand);
            accountService.createInitAccount(uid);

            return "register/step2";
        } catch (DuplicateMemberException e) {
            errors.rejectValue("id", "duplicate");

            return "register/step1";
        }
    }

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(new RegisterRequestValidator());
//    }
}


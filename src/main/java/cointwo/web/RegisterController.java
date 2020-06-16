package cointwo.web;

import cointwo.service.DuplicateMemberException;
import cointwo.service.MemberRegisterService;
import cointwo.web.dto.RegisterCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private MemberRegisterService memberRegisterService;

    @RequestMapping("/register/step1")
    public String register(RegisterCommand registerCommand) {

        return "register/step1";
    }

    @PostMapping("/register/step2")
    public String registerProceed(@Valid RegisterCommand registerCommand, Errors errors) {
        if(errors.hasErrors()) {
            return "register/step1";
        }

        try {
            memberRegisterService.regist(registerCommand);

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


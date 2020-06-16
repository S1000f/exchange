package cointwo.web;

import cointwo.service.AuthInfo;
import cointwo.service.AuthService;
import cointwo.service.WrongPasswordException;
import cointwo.web.dto.LoginCommand;
import cointwo.web.validator.LoginCommandValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthService authService;

    @GetMapping
    public String form(LoginCommand loginCommand, @CookieValue(value = "id", required = false)Cookie idCookie) {
        if(idCookie != null) {
            loginCommand.setId(idCookie.getValue());
            loginCommand.setRememberId(true);
        }
        return "login/loginForm";
    }

    @PostMapping
    public String login(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
        new LoginCommandValidator().validate(loginCommand, errors);
        if(errors.hasErrors()) {
            return "login/loginForm";
        }
        try {
            AuthInfo authInfo = authService.authenticate(loginCommand.getId(), loginCommand.getPassword());
            session.setAttribute("authInfo", authInfo);

            Cookie rememberCookie = new Cookie("id", loginCommand.getId());
            rememberCookie.setPath("/");
            if(loginCommand.isRememberId()) {
                rememberCookie.setMaxAge(60 * 60 * 24 * 2);
            } else {
                rememberCookie.setMaxAge(0);
            }
            response.addCookie(rememberCookie);

            return "login/loginSuccess";
        } catch (WrongPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "login/loginForm";
        }
    }
}

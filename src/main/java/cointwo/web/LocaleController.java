package cointwo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class LocaleController {

    @RequestMapping("/changeLocale.do")
    public String changeLocale(@RequestParam(required = false) String locale, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        Locale locales = null;

        if (locale.matches("ko")) {
            locales = Locale.KOREAN;
        } else if (locale.matches("en")) {
            locales = Locale.ENGLISH;
        }

        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locales);

        String redirectURL = "redirect:" + request.getHeader("referer");

        return redirectURL;
    }
}

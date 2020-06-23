package cointwo.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginCheckFalseInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession(false);

        if (session != null) {
            Object authInfo = session.getAttribute("authInfo");
            if (authInfo != null) {
                response.sendRedirect(request.getContextPath() + "/main");
                return false;
            }
        }

        return true;
    }
}

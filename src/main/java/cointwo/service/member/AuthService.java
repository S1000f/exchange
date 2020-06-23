package cointwo.service.member;

import cointwo.domain.member.MemberDao;
import cointwo.web.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class AuthService {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private HttpServletRequest request;

    public AuthInfo authenticate(String id, String password) {
        MemberDto member = memberDao.selectById(id);

        if(member == null) {
            throw new WrongPasswordException();
        }

        if(!member.matchPassword(password)) {
            throw new WrongPasswordException();
        }

        return new AuthInfo(member.getUid(), member.getId(), member.getName());
    }

    public Long getSessionUid() {
        AuthInfo authInfo = getSessionAuthInfo();

        return authInfo.getUid();
    }

    public AuthInfo getSessionAuthInfo() {
        HttpSession session = request.getSession(false);

        if (session != null) {
            Object authInfo = session.getAttribute("authInfo");
            if (authInfo != null) {
                return (AuthInfo) authInfo;
            }
        }

        return null;
    }
}

package cointwo.service;

import cointwo.domain.member.MemberDao;
import cointwo.web.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthService {

    @Autowired
    private MemberDao memberDao;

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
}

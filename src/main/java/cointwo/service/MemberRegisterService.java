package cointwo.service;

import cointwo.domain.member.MemberDao;
import cointwo.web.dto.MemberDto;
import cointwo.web.dto.RegisterCommand;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@NoArgsConstructor
@Component
public class MemberRegisterService {

    @Autowired
    private MemberDao memberDao;

    public Long regist(RegisterCommand req) {
        MemberDto member = memberDao.selectById(req.getId());
        if(member != null) {
            throw new DuplicateMemberException("dup id" + req.getId());
        }

        MemberDto newMember = new MemberDto(req.getId(), req.getPassword(), req.getName(), LocalDateTime.now());
        memberDao.insert(newMember);

        return newMember.getUid();
    }
}

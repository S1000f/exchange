package cointwo.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class MemberDto {

    @Setter
    private Long uid;
    private String id;
    private String password;
    private String name;
    private LocalDateTime registerDateTime;

    public MemberDto(String id, String password, String name, LocalDateTime registerDateTime) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.registerDateTime = registerDateTime;
    }

    public void changePassword(String oldPassword, String newOne) {
        if(!password.equals(oldPassword)) {
        }

        this.password = newOne;
    }

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }
}

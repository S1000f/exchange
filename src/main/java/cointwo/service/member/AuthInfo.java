package cointwo.service.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthInfo {

    private Long uid;
    private String id;
    private String name;

    public AuthInfo(Long uid, String id, String name) {
        this.uid = uid;
        this.id = id;
        this.name = name;
    }


}

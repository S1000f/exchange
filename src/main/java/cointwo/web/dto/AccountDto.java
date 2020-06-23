package cointwo.web.dto;

import lombok.*;

@Getter
@Setter
@Builder
public class AccountDto {

    private Long aid;
    private Long uid;
    private int tender;
    private Double btc;
    private Double eth;
    private String status;

}

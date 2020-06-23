package cointwo.web.dto;

import cointwo.service.util.NumToStringService;
import lombok.*;

@Getter
@Setter
@Builder
public class AccountDto {

    private Long aid;
    private Long uid;
    private int tender;
    private String strTender;
    private double btc;
    private double eth;
    private String status;

    public void setStringNumbers() {
        this.strTender = NumToStringService.getStringNumber(this.tender);
    }

}

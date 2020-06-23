package cointwo.service.util;

import org.springframework.stereotype.Component;

@Component
public class NumToStringService {

    public static String getStringNumber(int amount) {

        int quotient;
        int remainder;
        int length;

        StringBuilder strAmount = new StringBuilder(String.valueOf(amount));
        length = strAmount.length();
        quotient = length / 3;
        remainder = length % 3;

        if (quotient <= 1 && remainder <= 0) {
            return strAmount.toString();
        } else if (quotient > 1 && remainder == 0){
            quotient -= 1;
        }

        strAmount.reverse();
        for (int i = 0; i < quotient; i++) {
            strAmount.insert(((i + 1) * 3) + i,",");
        }
        strAmount.reverse();

        return strAmount.toString();
    }
}

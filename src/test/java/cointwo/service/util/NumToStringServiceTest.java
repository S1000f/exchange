package cointwo.service.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumToStringServiceTest {

    @Test
    public void numToStringWithComma() {
        String result = NumToStringService.getStringNumber(100_000);
        String result2 = NumToStringService.getStringNumber(1_000);
        String result3 = NumToStringService.getStringNumber(10_000_000);
        assertEquals("100,000", result);
        assertEquals("1,000", result2);
        assertEquals("10,000,000", result3);
    }

    @Test
    public void whenEqualOrLessThan3DigitNumber() {
        String result = NumToStringService.getStringNumber(234);
        String result2 = NumToStringService.getStringNumber(2);
        assertEquals("234", result);
        assertEquals("2", result2);
    }
}

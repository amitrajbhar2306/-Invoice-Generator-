package com.example.invoice_generator.util;

import java.math.BigDecimal;

public class AmountInWordsUtil {

    private AmountInWordsUtil() {
    }

    public static String convert(BigDecimal amount) {
        return amount.toPlainString() + " Rupees Only";
    }
}

package com.comin.claudinei.core;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
public class NumberUtils {

    public Double formatNumber(Double value, RoundingMode roundingMode, Integer scaleConfig) {
        Integer scale = 2;
        if (scaleConfig != null) {
            scale = Integer.valueOf(scaleConfig);
        }

        try {
            value = new BigDecimal(value).setScale(scale, roundingMode).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            //TODO add logback
        }

        return value;
    }
}

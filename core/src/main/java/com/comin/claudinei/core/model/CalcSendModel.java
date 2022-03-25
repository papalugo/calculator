package com.comin.claudinei.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CalcSendModel implements Serializable {
    public String uuid;
    public Double valueA;
    public Double valueB;
    public String operator;
    public Integer methodRound;
    public Integer scale;

    public CalcSendModel() {
    }
}

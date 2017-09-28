package com.allinpay.wjt.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class TChanlqyInfoKey implements Serializable {
    private Integer id;

    private String merId;

    private String memberId;

    private String intfcId;

    public Integer getId() {
        return id;
    }


}
package com.allinpay.wjt.model;

import lombok.Data;

import java.util.Date;
@Data
public class TChanlqyInfo extends TChanlqyInfoKey {
    private String qyBatchid;

    private String intfcName;

    private String queryStatus;

    private String rediskey;

    private Date insertime;

    private String erroreason;
}
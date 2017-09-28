package com.allinpay.wjt.mapper;

import com.allinpay.wjt.model.TChanlqyInfo;
import com.allinpay.wjt.model.TChanlqyInfoKey;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface TChanlqyInfoMapper extends Repository {

    int deleteByPrimaryKey(TChanlqyInfoKey key);

    List<TChanlqyInfo> listTChanlqyInfo();
    List<TChanlqyInfo> findChanlqyInfoByParams(Map<String,Object> param);

    int insert(TChanlqyInfo record);

    int insertSelective(TChanlqyInfo record);

    TChanlqyInfo selectByPrimaryKey(TChanlqyInfoKey key);

    int updateByPrimaryKeySelective(TChanlqyInfo record);

    int updateByPrimaryKey(TChanlqyInfo record);
}
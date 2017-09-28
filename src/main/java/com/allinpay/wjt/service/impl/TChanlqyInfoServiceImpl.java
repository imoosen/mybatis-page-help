package com.allinpay.wjt.service.impl;

import com.allinpay.wjt.mapper.TChanlqyInfoMapper;
import com.allinpay.wjt.model.TChanlqyInfo;
import com.allinpay.wjt.model.TChanlqyInfoKey;
import com.allinpay.wjt.service.TChanlqyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by mengsen on 2017/9/28.
 *
 * @Description: [一句话描述该类的功能]
 * @UpdateUser: mengsen on 2017/9/28.
 */
@Service
public class TChanlqyInfoServiceImpl implements TChanlqyInfoService{
    @Autowired
    private TChanlqyInfoMapper tChanlqyInfoMapper;
    @Override
    public int deleteByPrimaryKey(TChanlqyInfoKey key) {
        return 0;
    }

    @Override
    public int insert(TChanlqyInfo record) {
        return 0;
    }

    @Override
    public List<TChanlqyInfo> findChanlqyInfoByParams(Map<String, Object> param) {
        return tChanlqyInfoMapper.findChanlqyInfoByParams(param);
    }

    @Override
    public int insertSelective(TChanlqyInfo record) {
        return 0;
    }

    @Override
    public TChanlqyInfo selectByPrimaryKey(TChanlqyInfoKey key) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TChanlqyInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TChanlqyInfo record) {
        return 0;
    }

    @Override
    public List<TChanlqyInfo> listTChanlqyInfo() {
        return tChanlqyInfoMapper.listTChanlqyInfo();
    }
}

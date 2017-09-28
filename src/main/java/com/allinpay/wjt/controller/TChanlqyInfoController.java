package com.allinpay.wjt.controller;

import com.allinpay.wjt.model.TChanlqyInfo;
import com.allinpay.wjt.service.TChanlqyInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by mengsen on 2017/9/28.
 *
 * @Description: [一句话描述该类的功能]
 * @UpdateUser: mengsen on 2017/9/28.
 */
@RestController
public class TChanlqyInfoController {

    @Autowired
    private TChanlqyInfoService tChanlqyInfoService;

    @RequestMapping("/query/{page}/{pageSize}")
    public PageInfo query(@PathVariable Integer page, @PathVariable Integer pageSize) {
        if(page!= null && pageSize!= null){
            PageHelper.startPage(page, pageSize);
        }
        List<TChanlqyInfo> tChanlqyInfoList = tChanlqyInfoService.listTChanlqyInfo();
        return new PageInfo(tChanlqyInfoList);
    }

    @RequestMapping("/list/{page}/{pageSize}")
    public List<TChanlqyInfo> listTChanlqyInfo(@PathVariable Integer page, @PathVariable Integer pageSize) {
        if(page!= null && pageSize!= null){
            String orderBy = PageHelper.getOrderBy();
            PageHelper.startPage(page, pageSize);
        }
        List<TChanlqyInfo> tChanlqyInfoList = tChanlqyInfoService.listTChanlqyInfo();
        return tChanlqyInfoList;
    }

    @PostMapping("/find")
    public List<TChanlqyInfo> findChanlqyInfoByParams(@RequestBody Map<String,Object> param) {
        /*if(page!= null && pageSize!= null){
            String orderBy = PageHelper.getOrderBy();
            PageHelper.startPage(page, pageSize);
        }*/
        PageHelper.startPage(param);
        List<TChanlqyInfo> tChanlqyInfoList = tChanlqyInfoService.findChanlqyInfoByParams(param);
        return tChanlqyInfoList;
    }

}

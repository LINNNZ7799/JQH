package com.jqh.jqh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jqh.jqh.pojo.Info;

import java.util.List;
import java.util.Map;

public interface InfoService extends IService<Info> {

    List<Map<String,Object>> distinct();


}

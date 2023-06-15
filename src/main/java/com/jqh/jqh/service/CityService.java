package com.jqh.jqh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jqh.jqh.pojo.City;

import java.util.List;
import java.util.Map;


public interface CityService extends IService<City> {

    List<Map<String,Object>> cityDistinct();

}

package com.jqh.jqh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jqh.jqh.mapper.CitynameMapper;
import com.jqh.jqh.mapper.InfoMapper;
import com.jqh.jqh.pojo.City;
import com.jqh.jqh.pojo.Info;
import com.jqh.jqh.service.CityService;
import com.jqh.jqh.service.InfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("CityServiceImpl")
@Transactional
public class CityServiceImpl extends ServiceImpl<CitynameMapper, City> implements CityService {

    @Override
    public List<Map<String, Object>> cityDistinct() {
        List<Map<String, Object>> maps = this.baseMapper.selectCity();
        return maps;
    }
}

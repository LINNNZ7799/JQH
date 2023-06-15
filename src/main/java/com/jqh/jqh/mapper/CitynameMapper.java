package com.jqh.jqh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jqh.jqh.pojo.City;
import com.jqh.jqh.pojo.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CitynameMapper extends BaseMapper<City> {

    List<Map<String,Object>> selectCity();

}

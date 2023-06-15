package com.jqh.jqh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jqh.jqh.pojo.Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface InfoMapper extends BaseMapper<Info> {

    List<Map<String,Object>> distinct();
}

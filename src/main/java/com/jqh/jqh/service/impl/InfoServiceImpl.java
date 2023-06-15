package com.jqh.jqh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jqh.jqh.mapper.InfoMapper;
import com.jqh.jqh.pojo.Info;
import com.jqh.jqh.service.InfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("InfoServiceImpl")
@Transactional
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements InfoService {
    @Override
    public List<Map<String,Object>> distinct() {

        List<Map<String,Object>> distinct = this.baseMapper.distinct();
        return distinct;
    }
}

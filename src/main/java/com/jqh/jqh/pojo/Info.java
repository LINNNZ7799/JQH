package com.jqh.jqh.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("area_inf")
public class Info {

    private Integer serial;
    private String areaname;
    private String areacity;
    private String address;
    private Timestamp newtime;

    @TableField(exist = false)
    private String data1;
    @TableField(exist = false)
    private String data2;
    @TableField(exist = false)
    private String data3;
    @TableField(exist = false)
    private String data4;

}

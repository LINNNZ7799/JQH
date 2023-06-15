package com.jqh.jqh.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jqh.jqh.pojo.Address;
import com.jqh.jqh.pojo.City;
import com.jqh.jqh.pojo.Info;
import com.jqh.jqh.service.CityService;
import com.jqh.jqh.service.InfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.sql.Timestamp;
import java.util.*;

@Controller
public class InfoController {

    @Autowired
    private InfoService infoService;

    @Autowired
    private CityService cityService;

//    @GetMapping(value = {"/","/login"})
    @RequestMapping("/areaman")
    public String areaman(){
        return "areaman";
    }

    @RequestMapping("/cityinfo")
    public String cityinfo(){
        return "cityinfo";
    }

    @RequestMapping("/selectInfo")
    @ResponseBody
    public List selectInfo(){

//        Page<Info> page = new Page<>(currentPage2,pagesize2);
//        infoService.page(page);
//        List<User> records = page.getRecords();
//        List<Info> records = page.getRecords();
//        System.out.println(records);
//        records.forEach(System.out::println);
        List<Info> list = infoService.list();
        return list;

    }

//    @RequestMapping("/countInfo")
//    @ResponseBody
//    public Integer countInfo(){
//        return infoService.count();
//    }

//    @RequestMapping("/addInfo")
//    @ResponseBody
//    public Integer addInfo(@RequestBody Info info){
//        System.out.println(info);
//        return infoService.count();
//    }

    @RequestMapping("/addSubmitForm")
    @ResponseBody
    public Integer addSubmitForm(String areaname, String areacity, @RequestBody ArrayList<Address> domains){
        System.out.println(domains);
        Timestamp ctime2 = new Timestamp(new Date().getTime());
        Info info = new Info();
        info.setAreaname(areaname);
        info.setAreacity(areacity);
        info.setNewtime(ctime2);
        for(int i=0;i< domains.size();i++){
            Address address = domains.get(i);
            info.setAddress(address.getValue());
            infoService.save(info);
        }
        List<Map<String, Object>> cityDistinct = cityService.cityDistinct();
        Integer j = 0;

        City city = new City();
        city.setName(areacity);
//        throw new RuntimeException("城市名称已存在。");
        if (cityDistinct.size()==0){
//            City city = new City();
//            city.setName(areacity);
            cityService.save(city);
        }

        for (; j < cityDistinct.size(); j++) {

            if (!areacity.equals(cityDistinct.get(j).get("name")) && j==cityDistinct.size()-1){
//                City city = new City();
//                city.setName(areacity);
                cityService.save(city);

            }else if (areacity.equals(cityDistinct.get(j).get("name"))){
                break;
            }
            else {
                continue;
            }

        }





        return infoService.count();
    }

    @RequestMapping("/seek")
    @ResponseBody
    public List seek(String areaname,String areacity,String address,String data1,String data2,String data3,String data4){

        System.out.println(data1+areaname+areacity+address);

        String beginTime = data1+" "+data2;
        String endTime = data3+" "+data4;

        HashMap<String, String> map = new HashMap<>();
        map.put("areaname",areaname);
        map.put("areacity",areacity);
        map.put("address",address);
//        map.put("beginTime",beginTime);
//        map.put("endTime",endTime);

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();


        QueryWrapper<Info> infoQueryWrapper = new QueryWrapper<>();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
            if (entry.getValue().toString() != null && !entry.getValue().toString().matches("\\s*")){
                infoQueryWrapper.eq(entry.getKey().toString(),entry.getValue().toString());
            }
        }
        if (beginTime != null && !beginTime.matches("\\s*") && endTime != null && !endTime.matches("\\s*")){
            infoQueryWrapper.between("newtime",beginTime,endTime);
        }
        List<Info> infoList = infoService.list(infoQueryWrapper);
        System.out.println(infoList);

        return infoList;
    }

    @RequestMapping("/countInfo")
    @ResponseBody
    public Integer countInfo(){
        return infoService.count();
    }

//    @RequestMapping("/distinctcity")
//    @ResponseBody
//    public List<Map<String, Object>> distinctcity(){
//
//        List<Map<String, Object>> distinct = infoService.distinct();
//
//        return distinct;
//    }







}

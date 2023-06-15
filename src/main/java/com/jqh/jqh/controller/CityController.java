package com.jqh.jqh.controller;

import com.jqh.jqh.pojo.City;
import com.jqh.jqh.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/distinctcity")
    @ResponseBody
    public List<Map<String, Object>> distinctcity(){

        List<Map<String, Object>> citydistinct = cityService.cityDistinct();

        return citydistinct;
    }


    @RequestMapping("/addCity")
    @ResponseBody
    public void addCity(@RequestParam("areacity") String cityname){

        List<Map<String, Object>> cityDistinct = cityService.cityDistinct();

//        List<Map<String, String>> cityDistinct = cityService.cityDistinct();
        Integer j = 0;

        City city = new City();
        if (cityDistinct.size()==0){
            city.setName(cityname);
            cityService.save(city);
        }else {

            for (;j < cityDistinct.size(); j++) {

//        for (Map map:cityDistinct) {
                if (!cityname.equals(cityDistinct.get(j).get("name")) && j==cityDistinct.size()-1){
//                City city = new City();
                    city.setName(cityname);
                    cityService.save(city);

                }else if (cityname.equals(cityDistinct.get(j).get("name"))){
                    throw new RuntimeException("城市添加重复");
                }
                else {
                    continue;
                }
//        }}

//        City city = new City();
//                city.setName(cityname);
//                boolean save = cityService.save(city);

            }
        }



}}

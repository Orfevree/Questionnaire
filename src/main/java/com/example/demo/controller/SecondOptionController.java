package com.example.demo.controller;

import com.example.demo.beans.HttpResponseEntity;
import com.example.demo.dao.entity.QuestionEntity;
import com.example.demo.dao.entity.SecondOptionEntity;
import com.example.demo.service.SecondOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8085", maxAge = 3600)
public class SecondOptionController {

    @Autowired
    private SecondOptionService secondOptionService;

    //创建关联问题
    @RequestMapping(value = "/creatSecondOption",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity creatSecondOption(@RequestBody SecondOptionEntity secondOptionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        try {
            int result = secondOptionService.creatSecondOption(secondOptionEntity);
            if (result !=0 ){
                httpResponseEntity.setCode("1");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("创建关联问题成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("创建关联问题失败");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
    //预览关联问题
    @RequestMapping(value = "/querySecondOption",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity querySecondOption(@RequestBody SecondOptionEntity secondOptionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        try {
            List<SecondOptionEntity> hasSecondQuestion= secondOptionService.querySecondOption(secondOptionEntity);
            if (CollectionUtils.isEmpty(hasSecondQuestion)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("预览关联问题失败");
            }else {

                httpResponseEntity.setCode("1");
                httpResponseEntity.setData(hasSecondQuestion);
                httpResponseEntity.setMessage("预览关联问题成功");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

}

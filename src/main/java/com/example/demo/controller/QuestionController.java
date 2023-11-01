package com.example.demo.controller;

import com.example.demo.beans.HttpResponseEntity;
import com.example.demo.dao.entity.QuestionEntity;
import com.example.demo.dao.entity.QuestionnaireEntity;
import com.example.demo.dao.entity.previewQuestionEntity;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8085", maxAge = 3600)
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    //新建问题
    @RequestMapping(value = "/creatQuestion",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity creatQuestion(@RequestBody QuestionEntity questionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        try {
            int result = questionService.creatQuestion(questionEntity);
            if (result !=0 ){
                httpResponseEntity.setCode("1");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("创建问题成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("创建问题失败");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    //预览问题
    @RequestMapping(value = "/previewQuestionById",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity previewQuestionById(@RequestBody QuestionEntity questionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        try {
            List<previewQuestionEntity> hasQuestion = questionService.previewQuestionById(questionEntity);
            if (CollectionUtils.isEmpty(hasQuestion)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("预览问题失败");
            }else {
                httpResponseEntity.setCode("1");
                httpResponseEntity.setData(hasQuestion);
                httpResponseEntity.setMessage("预览问题成功");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
}

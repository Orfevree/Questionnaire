package com.example.demo.controller;

import com.example.demo.beans.HttpResponseEntity;
import com.example.demo.dao.entity.QuestionnaireEntity;
import com.example.demo.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8085", maxAge = 3600)
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    //新建问卷
    @RequestMapping(value = "/creatQuestionnaire",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity creatQuestionnaire(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        try {
            int result = questionnaireService.creatQuestionnaire(questionnaireEntity);
            if (result !=0 ){
                httpResponseEntity.setCode("1");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("创建成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("创建失败");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    //删除问卷
    @RequestMapping(value = "/deleteQuestionnaireById",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity deleteQuestionnaireById(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = questionnaireService.deleteQuestionnaireById(questionnaireEntity);
            if (result !=0 ){
                httpResponseEntity.setCode("1");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("删除成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除失败");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    //展示问卷列表
    @RequestMapping(value = "/queryQuestionnaireList",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryQuestionnaireList(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            List<QuestionnaireEntity> hasQuestionnaire = questionnaireService.queryQuestionnaireList(questionnaireEntity);
            if (CollectionUtils.isEmpty(hasQuestionnaire)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData("null");
                httpResponseEntity.setMessage("展示列表失败");
            }else {
                httpResponseEntity.setCode("1");
                httpResponseEntity.setData(hasQuestionnaire);
                httpResponseEntity.setMessage("展示列表成功");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    //发布问卷
    @RequestMapping(value = "/publishQuestionnaire",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity publishQuestionnaire(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = questionnaireService.publishQuestionnaire(questionnaireEntity);
            if (result !=0 ){
                httpResponseEntity.setCode("1");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("发布成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("发布失败");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    //预览问卷标题和描述
    @RequestMapping(value = "/previewQuestionnaireById",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity previewQuestionnaireById(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            List<QuestionnaireEntity> hasQuestionnaire = questionnaireService.previewQuestionnaireById(questionnaireEntity);
            if (CollectionUtils.isEmpty(hasQuestionnaire)){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("发布失败");
            }else {

                httpResponseEntity.setCode("1");
                httpResponseEntity.setData(hasQuestionnaire);
                httpResponseEntity.setMessage("发布成功");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

}

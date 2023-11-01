package com.example.demo.service;

import com.example.demo.dao.QuestionEntityMapper;
import com.example.demo.dao.entity.QuestionEntity;
import com.example.demo.dao.entity.previewQuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionEntityMapper questionEntityMapper;

    //创建问题

    public  int creatQuestion(QuestionEntity questionEntity){
        int result = questionEntityMapper.creatQuestion(questionEntity);
        if (result!=0){
            int questionId = questionEntityMapper.returnQuestionId(questionEntity);
            return questionId;
        }else {
            return 0;
        }
    }

    //删除问题

    //修改模板、问题

    //预览问题
    public List<previewQuestionEntity> previewQuestionById(QuestionEntity questionEntity){
        List<previewQuestionEntity> result = questionEntityMapper.previewQuestionById(questionEntity);
        return result;
    }

}

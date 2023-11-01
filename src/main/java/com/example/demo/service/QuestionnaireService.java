package com.example.demo.service;

import com.example.demo.dao.QuestionnaireEntityMapper;
import com.example.demo.dao.entity.QuestionnaireEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {

    @Autowired
    private QuestionnaireEntityMapper questionnaireEntityMapper;

    //新建问卷

    public int creatQuestionnaire(QuestionnaireEntity questionnaireEntity){
        int Result = questionnaireEntityMapper.creatQuestionnaire(questionnaireEntity);
        if (Result!=0){
            int questionnaireId = questionnaireEntityMapper.returnQuestionnaireId(questionnaireEntity);
            return questionnaireId;
        }else {
            return 0;
        }
    }

    //删除问卷

    public int deleteQuestionnaireById(QuestionnaireEntity questionnaireEntity){
        int Result = questionnaireEntityMapper.deleteQuestionnaireById(questionnaireEntity);
        return Result;
    }
    //展示问卷列表

    public List<QuestionnaireEntity> queryQuestionnaireList(QuestionnaireEntity questionnaireEntity){
        List<QuestionnaireEntity> Result = questionnaireEntityMapper.queryQuestionnaireList(questionnaireEntity);
        return Result;
    }

    //预览问卷

    //发布问卷
    public int publishQuestionnaire(QuestionnaireEntity questionnaireEntity){
        int Result = questionnaireEntityMapper.publishQuestionnaire(questionnaireEntity);
        return Result;
    }

    //返回问卷id
    /*public int returnQuestionnaireId(QuestionnaireEntity questionnaireEntity){
        int result = questionnaireEntityMapper.returnQuestionnaireId(questionnaireEntity);
        return result;
    }*/

    public List<QuestionnaireEntity> previewQuestionnaireById(QuestionnaireEntity questionnaireEntity){
        List<QuestionnaireEntity> Result = questionnaireEntityMapper.previewQuestionnaireById(questionnaireEntity);
        return Result;
    }

}

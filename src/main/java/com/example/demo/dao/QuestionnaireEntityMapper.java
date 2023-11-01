package com.example.demo.dao;

import com.example.demo.dao.entity.QuestionnaireEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface QuestionnaireEntityMapper {

    //新建问卷
    int creatQuestionnaire(QuestionnaireEntity questionnaireEntity);

    //删除问卷

    int deleteQuestionnaireById(QuestionnaireEntity questionnaireEntity);
    //展示问卷列表

    List<QuestionnaireEntity> queryQuestionnaireList(QuestionnaireEntity questionnaireEntity);



    //发布问卷
    int publishQuestionnaire(QuestionnaireEntity questionnaireEntity);

    //返回问卷id
    int returnQuestionnaireId(QuestionnaireEntity questionnaireEntity);

    //预览
    List<QuestionnaireEntity> previewQuestionnaireById(QuestionnaireEntity questionnaireEntity);
}

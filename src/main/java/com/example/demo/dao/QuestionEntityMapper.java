package com.example.demo.dao;

import com.example.demo.dao.entity.QuestionEntity;
import com.example.demo.dao.entity.previewQuestionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface QuestionEntityMapper {
    //创建问题
    int creatQuestion(QuestionEntity questionEntity);

    //预览问题
    List<previewQuestionEntity> previewQuestionById(QuestionEntity questionEntity);

    //返回问卷id
    int returnQuestionId(QuestionEntity questionEntity);
}

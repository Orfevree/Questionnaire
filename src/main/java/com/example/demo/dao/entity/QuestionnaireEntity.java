package com.example.demo.dao.entity;

import java.util.Date;

public class QuestionnaireEntity {

    private int questionnaireId;
    private String projectId;
    private int type;
    private String questionnaireName;
    private String  questionnaireDesc;
    private Date publishTime;

    public int getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(int questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName;
    }

    public String getQuestionnaireDesc() {
        return questionnaireDesc;
    }

    public void setQuestionnaireDesc(String questionnaireDesc) {
        this.questionnaireDesc = questionnaireDesc;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}

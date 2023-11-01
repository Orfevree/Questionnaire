package com.example.demo.dao.entity;

public class SecondOptionEntity {
    private int secondOptionId;
    private int questionId;
    private String relativeFirstOption;
    private String relativeSecondOption;
    private String relativeThirdOption;
    private int optionIndex;

    public int getSecondOptionId() {
        return secondOptionId;
    }

    public void setSecondOptionId(int secondOptionId) {
        this.secondOptionId = secondOptionId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getRelativeFirstOption() {
        return relativeFirstOption;
    }

    public void setRelativeFirstOption(String relativeFirstOption) {
        this.relativeFirstOption = relativeFirstOption;
    }

    public String getRelativeSecondOption() {
        return relativeSecondOption;
    }

    public void setRelativeSecondOption(String relativeSecondOption) {
        this.relativeSecondOption = relativeSecondOption;
    }

    public String getRelativeThirdOption() {
        return relativeThirdOption;
    }

    public void setRelativeThirdOption(String relativeThirdOption) {
        this.relativeThirdOption = relativeThirdOption;
    }

    public int getOptionIndex() {
        return optionIndex;
    }

    public void setOptionIndex(int optionIndex) {
        this.optionIndex = optionIndex;
    }
}

package com.example.demo.dao.entity;

public class previewQuestionEntity {

        private int questionId;
        private int questionnaireId;
        private String questionName;
        //判断是否必答
        private boolean questionDesc;
        private int questionType;
        private String firstOption;
        private String secondOption;
        private String thirdOption;
        private int isTwo;

        public int getQuestionId() {
            return questionId;
        }

        public void setQuestionId(int questionId) {
            this.questionId = questionId;
        }

        public int getQuestionnaireId() {
            return questionnaireId;
        }

        public void setQuestionnaireId(int questionnaireId) {
            this.questionnaireId = questionnaireId;
        }

        public String getQuestionName() {
            return questionName;
        }

        public void setQuestionName(String questionName) {
            this.questionName = questionName;
        }

        public boolean isQuestionDesc() {
            return questionDesc;
        }

        public void setQuestionDesc(boolean questionDesc) {
            this.questionDesc = questionDesc;
        }

        public String getFirstOption() {
            return firstOption;
        }

        public void setFirstOption(String firstOption) {
            this.firstOption = firstOption;
        }

        public String getSecondOption() {
            return secondOption;
        }

        public void setSecondOption(String secondOption) {
            this.secondOption = secondOption;
        }

        public String getThirdOption() {
            return thirdOption;
        }

        public void setThirdOption(String thirdOption) {
            this.thirdOption = thirdOption;
        }

        public int getIsTwo() {
            return isTwo;
        }

        public void setIsTwo(int isTwo) {
            this.isTwo = isTwo;
        }

        public int getQuestionType() {
            return questionType;
        }

        public void setQuestionType(int questionType) {
            this.questionType = questionType;
        }

    private int secondOptionId;

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

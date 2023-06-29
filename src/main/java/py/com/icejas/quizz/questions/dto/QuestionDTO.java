package py.com.icejas.quizz.questions.dto;

import java.util.Collection;

public class QuestionDTO {
    private Collection<String> questionOptions;

    private String questionAnswer;

    private Boolean isPlayed;

    private String question;

    private Integer value;

    public QuestionDTO() {
    }



    public Collection<String> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(Collection<String> questionOptions) {
        this.questionOptions = questionOptions;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public Boolean getPlayed() {
        return isPlayed;
    }

    public void setPlayed(Boolean played) {
        isPlayed = played;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

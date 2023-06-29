package py.com.icejas.quizz.questions.service;

import py.com.icejas.quizz.questions.dto.QuestionDTO;

public interface QuestionService {
    QuestionDTO getQuestions(String accessToken);

}

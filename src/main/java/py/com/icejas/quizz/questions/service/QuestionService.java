package py.com.icejas.quizz.questions.service;

import py.com.icejas.quizz.questions.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {
    List<QuestionDTO> getQuestions(String accessToken);

}

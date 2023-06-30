package py.com.icejas.quizz.questions.dao;

import py.com.icejas.quizz.questions.dto.QuestionDTO;

import java.util.List;

public interface QuestionDAO {
    List<QuestionDTO> getQuestions();
}

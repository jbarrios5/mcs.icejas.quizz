package py.com.icejas.quizz.questions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.icejas.quizz.auth.service.SessionService;
import py.com.icejas.quizz.commons.bean.Session;
import py.com.icejas.quizz.questions.dao.QuestionDAO;
import py.com.icejas.quizz.questions.dto.QuestionDTO;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionDAO questionDAO;
    @Autowired
    private SessionService sessionService;
    @Override
    public List<QuestionDTO> getQuestions(String accessToken) {
        Session session = sessionService.getSessionFromAccessToken(accessToken);
        return questionDAO.getQuestions();
    }
}

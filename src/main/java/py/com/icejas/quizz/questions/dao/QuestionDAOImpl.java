package py.com.icejas.quizz.questions.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import py.com.icejas.quizz.questions.dto.QuestionDTO;
import py.com.icejas.quizz.questions.mapper.QuestionMapper;
import py.com.icejas.quizz.user.dao.UserDAOImpl;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionDAOImpl implements QuestionDAO{
    private static final String GET_QUESTION = "select  * from public.quiz  where PLAYED is false ";
    private static final Logger log = LoggerFactory.getLogger(QuestionDAOImpl.class);
    private final JdbcTemplate jdbcTemplate;

    public QuestionDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<QuestionDTO> getQuestions() {
        log.info("Getting question");

        List<QuestionDTO> questionDTO = new ArrayList<>();
        try {
            questionDTO = jdbcTemplate.query(GET_QUESTION,new Object []{},new QuestionMapper());
        }catch (EmptyResultDataAccessException e){
            log.error(e.getMessage());
        }

        return questionDTO;
    }
}

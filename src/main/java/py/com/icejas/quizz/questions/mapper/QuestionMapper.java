package py.com.icejas.quizz.questions.mapper;

import org.springframework.jdbc.core.RowMapper;
import py.com.icejas.quizz.questions.dto.QuestionDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuestionMapper implements RowMapper<QuestionDTO> {
    @Override
    public QuestionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Collection<String> questionOptions = new ArrayList<>();
        questionOptions.add(rs.getString("option_1"));
        questionOptions.add(rs.getString("option_2"));
        questionOptions.add(rs.getString("option_3"));
        questionOptions.add(rs.getString("option_4"));

        String question = rs.getString("question");
        Integer value = rs.getInt("value");
        String answer = rs.getString("answer");
        Boolean played = rs.getBoolean("played");

        QuestionDTO questionDTO = new QuestionDTO();

        questionDTO.setQuestionAnswer(answer);
        questionDTO.setPlayed(played);
        questionDTO.setQuestionOptions(questionOptions);
        questionDTO.setQuestion(question);
        questionDTO.setValue(value);

        return questionDTO;

    }
}

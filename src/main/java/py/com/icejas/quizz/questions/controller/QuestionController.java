package py.com.icejas.quizz.questions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import py.com.icejas.quizz.commons.constant.ApiConstant;
import py.com.icejas.quizz.questions.dto.QuestionDTO;
import py.com.icejas.quizz.questions.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("api/v1/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public List<QuestionDTO> getQuestion(
            @RequestHeader(value = ApiConstant.ACCESS_TOKEN,required = true) String accessToken
    ){
        return questionService.getQuestions(accessToken);
    }

}

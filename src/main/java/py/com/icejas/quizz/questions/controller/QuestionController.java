package py.com.icejas.quizz.questions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import py.com.icejas.quizz.commons.constant.ApiConstant;
import py.com.icejas.quizz.questions.dto.QuestionDTO;
import py.com.icejas.quizz.questions.service.QuestionService;

import java.util.List;
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
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

package com.danzig.tenToOne.controller;

import com.danzig.tenToOne.api.QuestionApiTest;
import com.danzig.tenToOne.api.QuestionGetApi;
import com.danzig.tenToOne.api.QuestionRequest;
import com.danzig.tenToOne.mapping.QuestionMapping;
import com.danzig.tenToOne.model.Person;
import com.danzig.tenToOne.model.Question;
import com.danzig.tenToOne.service.PersonService;
import com.danzig.tenToOne.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "game/question")
public class QuestionController {

    private final QuestionService questionService;

    private final PersonService personService;

    @Autowired
    public QuestionController(QuestionService questionService, PersonService personService) {
        this.questionService = questionService;
        this.personService = personService;
    }

    @GetMapping("/all")
    public List<QuestionGetApi> getAllQuestions() {
        List<QuestionGetApi> questionResponse = QuestionMapping.toQuestionGetApi(questionService.getAllQuestions());
        return questionResponse;
    }

    @GetMapping("/{id}")
    public Optional<Question> getQuestionById(@PathVariable("id") Long id){
        return questionService.questionById(id);
    }

    /*@PostMapping("/testAdd")
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionResponse registerQuestionTest(@RequestBody QuestionRequest questionRequest) {
        Person person = personService.personByName(questionRequest.getPersonApi().getFirstName(), questionRequest.getPersonApi().getLastName());
        Question question = QuestionMapping.fromQuestionApi(questionRequest.getQuestionApi());
        question.setPerson(person);

        Question newQuestion = questionService.addQuestion(question);

        QuestionResponse questionResponse = new QuestionResponse(
                PersonMapping.toPersonApi(person),
                QuestionMapping.toQuestionApiTest(person.getQuestions())
        );

        return questionResponse;
    }*/

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerQuestion(@RequestBody QuestionRequest questionRequest) {
        Person person = personService.personByName(questionRequest.getPersonApi().getFirstName(), questionRequest.getPersonApi().getLastName());
        Question question = QuestionMapping.fromQuestionApi(questionRequest.getQuestionApi());
        question.setPerson(person);

        Question newQuestion = questionService.addQuestion(question);


    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateQuestion(@RequestBody Question question) {
        Optional<Question> questionDB = questionService.questionById(question.getId());
        questionDB.get().setQuestionContent(question.getQuestionContent());
        questionService.updateQuestion(questionDB.get());
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteQuestion(@PathVariable("id") Long id) {
        questionService.deleteQuestionById(id);
    }

    @GetMapping("/ask/{id}")
    public QuestionApiTest ask(@PathVariable("id") Long id) {
        Person person = personService.personById(id).get();
        List<Question> allQuestions = questionService.getAllQuestions();
        List<Question> selectedQuestions = new ArrayList<>();
        for(Question question : allQuestions) {
            Long k = question.getPerson().getId();
            if (!question.isAsked()){
                if(id != k){
                    selectedQuestions.add(question);
                }
            }
        }
        int size = selectedQuestions.size();
        int idSelected = (int)(Math.random() * (size));
        Question selectedQuestion = selectedQuestions.get(idSelected);
        selectedQuestion.setAsked(true);
        questionService.updateQuestion(selectedQuestion);
        return QuestionMapping.toQuestionApiTest(selectedQuestions.get(idSelected));
    }
}

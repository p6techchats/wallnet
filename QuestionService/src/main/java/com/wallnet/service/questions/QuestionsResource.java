package com.wallnet.service.questions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallnet.service.questions.model.Question;

@RestController
@RequestMapping("/questions")
public class QuestionsResource {

	@Autowired
	private QuestionService service;

	@GetMapping("/load")
	public List<Question> loadAllQuestions() {
		return service.loadAllQuestions();
	}

	@GetMapping("/load/{quesId}")
	public Question loadQuestion(@PathVariable("quesId") String quesId) {
		return service.loadQuestion(quesId);
	}

	@PostMapping(value = "add", consumes = "application/json")
	public String addQuestion(@RequestBody Question question) {
		return service.addQuestion(question);
	}

	@PutMapping(value = "/{quesId}/edit", consumes = {"application/json"})
	public String editQuestion(@PathVariable("quesId") String questionId, @RequestBody Question question) {
		System.out.println("Question id is "+ questionId);
		System.out.println("question  is " + question);
		return service.updateQuestion(questionId, question);
	}
	
	@PutMapping(value = "/delete/{quesId}")
	public String deleteQuestion(@PathVariable("quesId") String questionId)  {
		return service.deleteQuestion(questionId);
	}
}

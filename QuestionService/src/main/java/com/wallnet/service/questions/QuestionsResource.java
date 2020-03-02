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

import com.wallnet.service.appcommon.Question;

@RestController
@RequestMapping("/questions")
public class QuestionsResource {

	@Autowired
	private QuestionService service;
	
	@GetMapping("/load")
	public List<Question> loadAllQuestions() {
		return service.loadAllQuestions();
	}

	@GetMapping("/{quesId}")
	public Question loadQuestion(@PathVariable("quesId") int quesId) {
		return service.loadQuestion(quesId);
	}

	@PostMapping(value = "add", consumes = "application/json")
	public int addQuestion(@RequestBody Question question) {
		return service.addQuestion(question);
	}

	@PutMapping(value = "/{quesId}/edit", consumes = {"application/json"})
	public String editQuestion(@PathVariable("quesId") int questionId, @RequestBody Question question) {
		System.out.println("Question id is "+ questionId);
		System.out.println("question  is " + question);
		return service.updateQuestion(questionId, question);
	}
	
	@PutMapping(value = "/{quesId}/delete")
	public String deleteQuestion(@PathVariable("quesId") int questionId)  {
		return service.deleteQuestion(questionId);
	}
	
}

package com.wallnet.service.qa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qa")
public class QA_Resource {

	@Autowired
	private QAService qaService;
	
	@GetMapping("/loadAll")
	public QAResponse loadAllQuestionAndAnswers() {
		return qaService.loadAllQuestionsAndAnswers();
	}
	
	@PutMapping(value = "/loadQA", consumes = "application/json")
	public QAResponse loadQuestionAnswer(@RequestBody QARequest qaRequest) {
		return qaService.loadQuestionAnswer(qaRequest);
	}
	
	@PutMapping(value = "/loadAnswer", consumes = "application/json")
	public QAResponse loadAnswerForQuestion(@RequestBody QARequest qaRequest) {
		return qaService.loadAnswerForQuestion(qaRequest);
	}
}

package com.wallnet.service.qa;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wallnet.service.appcommon.Question;

@FeignClient(name = "question-service-client", url="http://localhost:8082")
public interface QuestionClient {

	@GetMapping("/questions")
	public List<Question> loadAllQuestions();

	@GetMapping("/questions/{quesId}")
	public Question loadQuestion(@PathVariable("quesId") int quesId);

	@PostMapping(value = "/questions/add", consumes = "application/json")
	public int addQuestion(@RequestBody Question question);

	@PutMapping(value = "/questions/{quesId}/edit", consumes = {"application/json"})
	public String editQuestion(@PathVariable("quesId") int questionId, @RequestBody Question question);
	
	@PutMapping(value = "/questions/{quesId}/delete")
	public String deleteQuestion(@PathVariable("quesId") int questionId);
}

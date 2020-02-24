package com.wallnet.service.qa;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wallnet.service.appcommon.Answer;

@FeignClient(name = "answer-service-client",url = "http://localhost:8083/answers")
public interface AnswerClient {

	@GetMapping
	public List<Answer> loadAllAnswers();

	@GetMapping(value = "/{ansId}")
	public Answer loadAnswer(@PathVariable("ansId") int answerId);

	@PostMapping(value = "/add", consumes = "application/json")
	public int addAnswer(@RequestBody Answer answer);

	@PutMapping(value = "/{ansId}/edit", consumes = "application/json")
	public String editAnswer(@PathVariable("ansId") int answerId, @RequestBody Answer answer);

	@PutMapping(value = "/{ansId}/delete")
	public String deleteAnswer(@PathVariable("ansId") int answerId);
}

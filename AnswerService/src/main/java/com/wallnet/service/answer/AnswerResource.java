package com.wallnet.service.answer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallnet.service.appcommon.Answer;

@RestController
@RequestMapping("/answers")
public class AnswerResource {

	@Autowired
	private AnswerService answerService;

	@GetMapping("/load")
	public List<Answer> loadAllAnswers() {
		return answerService.loadAllAnswers();
	}

	@GetMapping(value = "/{ansId}")
	public Answer loadAnswer(@PathVariable("ansId") int answerId) {
		return answerService.loadAnswer(answerId);
	}

	@PostMapping(value = "/add", consumes = "application/json")
	public int addAnswer(@RequestBody Answer answer) {
		return answerService.addAnswer(answer);
	}

	@PutMapping(value = "/{ansId}/edit", consumes = "application/json")
	public String editAnswer(@PathVariable("ansId") int answerId, @RequestBody Answer answer) {
		return answerService.updateAnswer(answerId, answer);
	}

	@PutMapping(value = "/{ansId}/delete")
	public String deleteAnswer(@PathVariable("ansId") int answerId) {
		return answerService.deleteAnswer(answerId);
	}
}
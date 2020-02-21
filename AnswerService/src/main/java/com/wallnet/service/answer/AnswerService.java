package com.wallnet.service.answer;

import java.util.List;

import com.wallnet.service.answer.model.Answer;

public interface AnswerService {

	public List<Answer> loadAllAnswers();

	public Answer loadAnswer(String answerId);

	public String addAnswer(Answer answer);

	public String updateAnswer(String answerId, Answer answer);

	public String deleteAnswer(String answerId);
}

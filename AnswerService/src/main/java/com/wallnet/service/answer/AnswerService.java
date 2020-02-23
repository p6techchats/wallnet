package com.wallnet.service.answer;

import java.util.List;

import com.wallnet.service.appcommon.Answer;

public interface AnswerService {

	public List<Answer> loadAllAnswers();

	public Answer loadAnswer(int answerId);

	public int addAnswer(Answer answer);

	public String updateAnswer(int answerId, Answer answer);

	public String deleteAnswer(int answerId);
}

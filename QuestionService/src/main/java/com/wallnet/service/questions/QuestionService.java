package com.wallnet.service.questions;

import java.util.List;

import com.wallnet.service.appcommon.Question;

public interface QuestionService {

	public List<Question> loadAllQuestions();

	public String updateQuestion(int questionId, Question question);

	public String deleteQuestion(int questionId);

	public int addQuestion(Question question);

	public Question loadQuestion(int quesId);

}

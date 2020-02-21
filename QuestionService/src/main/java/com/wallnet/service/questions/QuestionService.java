package com.wallnet.service.questions;

import java.util.List;

import com.wallnet.service.questions.model.Question;

public interface QuestionService {

	public List<Question> loadAllQuestions();

	public Question loadQuestion(String quesId);

	public String updateQuestion(String questionId, Question question);

	public String deleteQuestion(String questionId);

	public String addQuestion(Question question);

}

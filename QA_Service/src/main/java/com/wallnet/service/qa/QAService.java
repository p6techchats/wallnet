package com.wallnet.service.qa;

public interface QAService {

	public QAResponse loadAllQuestionsAndAnswers();
	public QAResponse loadQuestionAnswer(QARequest qaRequest);
	public QAResponse loadAnswerForQuestion(QARequest qaRequest);
}

package com.wallnet.service.answer.model;

public class Answer {

	private String answerId;
	private String questionId;
	private String answerLine1;
	private String answerLine2;
	private String option;

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getAnswerLine1() {
		return answerLine1;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public void setAnswerLine1(String answerLine1) {
		this.answerLine1 = answerLine1;
	}

	public String getAnswerLine2() {
		return answerLine2;
	}

	public void setAnswerLine2(String answerLine2) {
		this.answerLine2 = answerLine2;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
}

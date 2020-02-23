package com.wallnet.service.appcommon;

import java.util.List;

public class Question {

	private int questionId;
	private String questionLine1;
	private String questionLine2;
	private List<String> options;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionLine1() {
		return questionLine1;
	}

	public void setQuestionLine1(String questionLine1) {
		this.questionLine1 = questionLine1;
	}

	public String getQuestionLine2() {
		return questionLine2;
	}

	public void setQuestionLine2(String questionLine2) {
		this.questionLine2 = questionLine2;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Question:[questionId" + this.questionId + ", questionLine1" + this.questionLine1 + ", questionLine2"
				+ this.questionLine2 + ", options" + this.options + "]";
	}
}

package com.wallnet.service.appcommon;

public class Answer {

	private int answerId;
	private String answerLine1;
	private String answerLine2;
	private String option;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswerLine1() {
		return answerLine1;
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

	@Override
	public String toString() {
		return "Answer:[answerId=" + this.answerId + ", answerLine1=" + this.answerLine1 + ", answerLine2="
				+ this.answerLine2 + ", option=" + this.option + "]";
	}
}

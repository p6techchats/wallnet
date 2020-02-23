package com.wallnet.service.qa;

import com.wallnet.service.appcommon.Answer;
import com.wallnet.service.appcommon.Question;

public class QARequest {

	private Question question;
	private Answer answer;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		return this.question +", "+ this.answer;
	}
}

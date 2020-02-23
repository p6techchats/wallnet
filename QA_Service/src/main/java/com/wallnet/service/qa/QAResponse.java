package com.wallnet.service.qa;

import java.util.List;

import com.wallnet.service.appcommon.Answer;
import com.wallnet.service.appcommon.Question;

public class QAResponse {

	private List<Question> questions;
	private List<Answer> answers;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}

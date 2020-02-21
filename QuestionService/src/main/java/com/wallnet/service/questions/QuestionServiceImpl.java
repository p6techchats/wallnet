package com.wallnet.service.questions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wallnet.service.questions.model.Question;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

	private static final List<Question> QUESTIONS = loadStaticQuestions();

	@Override
	public List<Question> loadAllQuestions() {
		return QUESTIONS;
	}

	@Override
	public Question loadQuestion(String quesId) {
		for (Question question : QUESTIONS) {
			if (question.getQuestionId().equals(quesId)) {
				return deepCopy(question);
			}
		}
		return null;
	}

	@Override
	public String addQuestion(Question question) {
		if (StringUtils.isEmpty(question.getQuestionLine1()) || StringUtils.isEmpty(question.getQuestionLine2())) {
			return null;
		}
		Question lastQuestion = QUESTIONS.get(QUESTIONS.size() - 1);
		question.setQuestionId(String.valueOf(Integer.parseInt(lastQuestion.getQuestionId())+1));
		QUESTIONS.add(question);
		return question.getQuestionId();
	}

	@Override
	public String updateQuestion(String questionId, Question questionReq) {
		for (Question question : QUESTIONS) {
			if (question.getQuestionId().equals(questionId)) {
				question.setQuestionLine1(questionReq.getQuestionLine1());
				question.setQuestionLine2(questionReq.getQuestionLine2());
				question.setOptions(questionReq.getOptions());
				return "Updated Successfully";
			}
		}
		return "Update operation failed";
	}

	@Override
	public String deleteQuestion(String questionId) {
		Iterator<Question> queIte = QUESTIONS.iterator();
		while (queIte.hasNext()) {
			Question question = (Question) queIte.next();
			if (question.getQuestionId().equals(questionId)) {
				queIte.remove();
				return "Deleted successfully";
			}
		}
		return "Delete operation failed";
	}

	private static List<Question> loadStaticQuestions() {
		List<Question> list = new ArrayList<>();
		Question question1 = new Question();
		question1.setQuestionId(String.valueOf(list.size() + 1));
		question1.setQuestionLine1("questionLine1 - 1");
		question1.setQuestionLine2("questionLine2 - 1");
		List<String> options1 = new ArrayList<>();
		options1.add("A 1");
		options1.add("B 1");
		options1.add("C 1");
		options1.add("D 1");
		question1.setOptions(options1);
		list.add(question1);

		Question question2 = new Question();
		question2.setQuestionId(String.valueOf(list.size() + 1));
		question2.setQuestionLine1("questionLine1 - 2");
		question2.setQuestionLine2("questionLine2 - 2");
		List<String> options2 = new ArrayList<>();
		options2.add("A 2");
		options2.add("B 2");
		options2.add("C 2");
		options2.add("D 2");
		question2.setOptions(options2);
		list.add(question2);
		return list;
	}

	private Question deepCopy(Question question) {
		Question ques = new Question();
		ques.setQuestionId(question.getQuestionId());
		ques.setQuestionLine1(question.getQuestionLine1());
		ques.setQuestionLine2(question.getQuestionLine2());
		List<String> options = new ArrayList<>();
		for (String string : question.getOptions()) {
			options.add(string);
		}
		ques.setOptions(options);
		return ques;
	}
}

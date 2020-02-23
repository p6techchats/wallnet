package com.wallnet.service.questions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wallnet.service.appcommon.Question;
import com.wallnet.service.mock.MockQAData;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

	@Override
	public List<Question> loadAllQuestions() {
		return MockQAData.QUESTIONS;
	}

	@Override
	public Question loadQuestion(int quesId) {
		for (Question question : MockQAData.QUESTIONS) {
			if (question.getQuestionId() == quesId) {
				return deepCopy(question);
			}
		}
		return null;
	}

	@Override
	public int addQuestion(Question question) {
		if (StringUtils.isEmpty(question.getQuestionLine1()) || StringUtils.isEmpty(question.getQuestionLine2())) {
			return -1;
		}
		Question lastQuestion = MockQAData.QUESTIONS.get(MockQAData.QUESTIONS.size() - 1);
		question.setQuestionId(lastQuestion.getQuestionId() + 1);
		MockQAData.QUESTIONS.add(question);
		return question.getQuestionId();
	}

	@Override
	public String updateQuestion(int questionId, Question questionReq) {
		for (Question question : MockQAData.QUESTIONS) {
			if (question.getQuestionId() == questionId) {
				question.setQuestionLine1(questionReq.getQuestionLine1());
				question.setQuestionLine2(questionReq.getQuestionLine2());
				question.setOptions(questionReq.getOptions());
				return "Updated Successfully";
			}
		}
		return "Update operation failed";
	}

	@Override
	public String deleteQuestion(int questionId) {
		Iterator<Question> queIte = MockQAData.QUESTIONS.iterator();
		while (queIte.hasNext()) {
			Question question = (Question) queIte.next();
			if (question.getQuestionId() == questionId) {
				//delete answer via answer service
				queIte.remove();
				return "Deleted successfully";
			}
		}
		return "Delete operation failed";
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

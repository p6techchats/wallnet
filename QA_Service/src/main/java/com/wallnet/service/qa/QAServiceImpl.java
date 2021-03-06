package com.wallnet.service.qa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wallnet.service.appcommon.Answer;
import com.wallnet.service.appcommon.Question;
import com.wallnet.service.mock.MockQAData;

@Service("qaService")
public class QAServiceImpl implements QAService {

	@Autowired
	private AnswerClient answerClient;
	
	@Autowired
	private QuestionClient questionClient;
	
	@Override
	public QAResponse loadAllQuestionsAndAnswers() {
		QAResponse qaResponse = new QAResponse();
		qaResponse.setAnswers(answerClient.loadAllAnswers());
		qaResponse.setQuestions(questionClient.loadAllQuestions());
		return qaResponse;
	}

	@Override
	public QAResponse loadQuestionAnswer(QARequest qaRequest) {
		QAResponse qaResponse = new QAResponse();
		List<Question> questions = new ArrayList<Question>();
		Question question = questionClient.loadQuestion(qaRequest.getQuestion().getQuestionId());
		questions.add(question);
		qaResponse.setQuestions(questions);
		
		List<Answer> answers = new ArrayList<Answer>();
		Answer answer = answerClient.loadAnswer(MockQAData.QA_MOCTDATA_MAP.get(question.getQuestionId()));
		answers.add(answer);
		qaResponse.setAnswers(answers);
		return qaResponse;
	}

	@Override
	public QAResponse loadAnswerForQuestion(QARequest qaRequest) {
		QAResponse qaResponse = new QAResponse();
		List<Answer> answers = new ArrayList<Answer>();
		Answer answer = answerClient.loadAnswer(MockQAData.QA_MOCTDATA_MAP.get(qaRequest.getQuestion().getQuestionId()));
		answers.add(answer);
		qaResponse.setAnswers(answers);
		return qaResponse;
	}
}

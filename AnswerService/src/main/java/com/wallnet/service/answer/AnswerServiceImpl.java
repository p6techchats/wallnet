package com.wallnet.service.answer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wallnet.service.answer.model.Answer;

@Service("answerService")
public class AnswerServiceImpl implements AnswerService {

	private static final List<Answer> ANSWERS = loadStaticAnswers();
	@Override
	public List<Answer> loadAllAnswers() {
		return ANSWERS;
	}

	@Override
	public Answer loadAnswer(String answerId) {
		for (Answer answer : ANSWERS) {
			if (answer.getAnswerId().equals(answerId)) {
				return deepCopy(answer);
			}
		}
		return null;
	}

	@Override
	public String addAnswer(Answer answer) {
		if (StringUtils.isEmpty(answer.getAnswerLine1()) || StringUtils.isEmpty(answer.getAnswerLine2())) {
			return null;
		}
		Answer lastAnswer = ANSWERS.get(ANSWERS.size() - 1);
		answer.setAnswerId(String.valueOf(Integer.parseInt(lastAnswer.getAnswerId())+1));
		ANSWERS.add(answer);
		return answer.getAnswerId();
	}

	@Override
	public String updateAnswer(String answerId, Answer answerReq) {
		for (Answer answer : ANSWERS) {
			if (answer.getAnswerId().equals(answerId)) {
				answer.setQuestionId(answer.getQuestionId());
				answer.setAnswerLine1(answerReq.getAnswerLine1());
				answer.setAnswerLine2(answerReq.getAnswerLine2());
				answer.setOption(answerReq.getOption());
				return "Updated answer Successfully";
			}
		}
		return "Update operation failed for answer";
	}

	@Override
	public String deleteAnswer(String answerId) {
		Iterator<Answer> ansIte = ANSWERS.iterator();
		while (ansIte.hasNext()) {
			Answer answer = (Answer) ansIte.next();
			if (answer.getAnswerId().equals(answerId)) {
				ansIte.remove();
				return "Deleted answer successfully";
			}
		}
		return "Delete operation failed for answer";
	}

	private static List<Answer> loadStaticAnswers() {
		List<Answer> answers = new ArrayList<>();
		Answer answer1 = new Answer();
		answer1.setAnswerId(String.valueOf(answers.size() + 1));
		answer1.setQuestionId(String.valueOf(answers.size() + 1));
		answer1.setAnswerLine1("answerLine1 - 1");
		answer1.setAnswerLine2("answerLine2 - 1");
		answer1.setOption("option 1");
		answers.add(answer1);

		Answer answer2 = new Answer();
		answer2.setAnswerId(String.valueOf(answers.size() + 1));
		answer2.setQuestionId(String.valueOf(answers.size() + 1));
		answer2.setAnswerLine1("answerLine1 - 2");
		answer2.setAnswerLine2("answerLine2 - 2");
		answer2.setOption("option 2");
		answers.add(answer2);

		return answers;
	}

	private Answer deepCopy(Answer answer) {
		Answer ans = new Answer();
		ans.setAnswerId(answer.getAnswerId());
		ans.setQuestionId(answer.getQuestionId());
		ans.setAnswerLine1(answer.getAnswerLine1());
		ans.setAnswerLine2(answer.getAnswerLine2());
		ans.setOption(answer.getOption());
		return ans;
	}
}

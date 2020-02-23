package com.wallnet.service.answer;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wallnet.service.appcommon.Answer;
import com.wallnet.service.mock.MockQAData;

@Service("answerService")
public class AnswerServiceImpl implements AnswerService {

	@Override
	public List<Answer> loadAllAnswers() {
		return MockQAData.ANSWERS;
	}

	@Override
	public Answer loadAnswer(int answerId) {
		for (Answer answer : MockQAData.ANSWERS) {
			if (answer.getAnswerId() == answerId) {
				return deepCopy(answer);
			}
		}
		return null;
	}

	@Override
	public int addAnswer(Answer answer) {
		if (StringUtils.isEmpty(answer.getAnswerLine1()) || StringUtils.isEmpty(answer.getAnswerLine2())) {
			return -1;
		}
		Answer lastAnswer = MockQAData.ANSWERS.get(MockQAData.ANSWERS.size() - 1);
		answer.setAnswerId(lastAnswer.getAnswerId()+1);
		MockQAData.ANSWERS.add(answer);
		return answer.getAnswerId();
	}

	@Override
	public String updateAnswer(int answerId, Answer answerReq) {
		for (Answer answer : MockQAData.ANSWERS) {
			if (answer.getAnswerId() == answerId) {
				answer.setAnswerLine1(answerReq.getAnswerLine1());
				answer.setAnswerLine2(answerReq.getAnswerLine2());
				answer.setOption(answerReq.getOption());
				return "Updated answer Successfully";
			}
		}
		return "Update operation failed for answer";
	}

	@Override
	public String deleteAnswer(int answerId) {
		Iterator<Answer> ansIte = MockQAData.ANSWERS.iterator();
		while (ansIte.hasNext()) {
			Answer answer = (Answer) ansIte.next();
			if (answer.getAnswerId() == answerId) {
				ansIte.remove();
				return "Deleted answer successfully";
			}
		}
		return "Delete operation failed for answer";
	}

	private Answer deepCopy(Answer answer) {
		Answer ans = new Answer();
		ans.setAnswerId(answer.getAnswerId());
		ans.setAnswerLine1(answer.getAnswerLine1());
		ans.setAnswerLine2(answer.getAnswerLine2());
		ans.setOption(answer.getOption());
		return ans;
	}
}

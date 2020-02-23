package com.wallnet.service.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wallnet.service.appcommon.Answer;
import com.wallnet.service.appcommon.Question;

public class MockQAData {

	public static final List<Question> QUESTIONS = loadStaticQuestions();
	public static final List<Answer> ANSWERS = loadStaticAnswers();
	public static final Map<Integer, Integer> QA_MOCTDATA_MAP = loadQADataMap();

	private static List<Question> loadStaticQuestions() {
		List<Question> list = new ArrayList<Question>();
		Question question1 = new Question();
		question1.setQuestionId(list.size()+1);
		question1.setQuestionLine1("First question line 1");
		question1.setQuestionLine2("First Question line 2");
		List<String> options1 = new ArrayList<String>();
		options1.add("Option 1");
		options1.add("Option 2");
		options1.add("Option 3");
		options1.add("Option 4");
		question1.setOptions(options1);
		list.add(question1);

		Question question2 = new Question();
		question2.setQuestionId(list.size()+1);
		question2.setQuestionLine1("Second question line 1");
		question2.setQuestionLine2("Second Question line 2");
		List<String> options2 = new ArrayList<String>();
		options2.add("Option 1");
		options2.add("Option 2");
		options2.add("Option 3");
		options2.add("Option 4");
		question2.setOptions(options2);
		list.add(question2);

		Question question3 = new Question();
		question3.setQuestionId(list.size()+1);
		question3.setQuestionLine1("Third question line 1");
		question3.setQuestionLine2("Third Question line 2");
		List<String> options3 = new ArrayList<String>();
		options3.add("Option 1");
		options3.add("Option 2");
		options3.add("Option 3");
		options3.add("Option 4");
		question3.setOptions(options3);
		list.add(question3);

		Question question4 = new Question();
		question4.setQuestionId(list.size()+1);
		question4.setQuestionLine1("Fourth question line 1");
		question4.setQuestionLine2("Fourth Question line 2");
		List<String> options4 = new ArrayList<String>();
		options4.add("Option 1");
		options4.add("Option 2");
		options4.add("Option 3");
		options4.add("Option 4");
		question4.setOptions(options4);
		list.add(question4);

		Question question5 = new Question();
		question5.setQuestionId(list.size()+1);
		question5.setQuestionLine1("Fifth question line 1");
		question5.setQuestionLine2("Fifth Question line 2");
		List<String> options5 = new ArrayList<String>();
		options5.add("Option 1");
		options5.add("Option 2");
		options5.add("Option 3");
		options5.add("Option 4");
		question5.setOptions(options5);
		list.add(question5);

		return list;
	}

	private static Map<Integer, Integer> loadQADataMap() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 5; i++) {
			map.put(i+1, i+1);
		}
		return map;
	}

	private static List<Answer> loadStaticAnswers() {
		List<Answer> list = new ArrayList<Answer>();
		Answer answer1 = new Answer();
		answer1.setAnswerId(list.size()+1);
		answer1.setAnswerLine1("First answer line 1");
		answer1.setAnswerLine2("First answer line 2");
		answer1.setOption("Option 1");
		list.add(answer1);

		Answer answer2 = new Answer();
		answer2.setAnswerId(list.size()+1);
		answer2.setAnswerLine1("Second answer line 1");
		answer2.setAnswerLine2("Second answer line 2");
		answer2.setOption("Option 1");
		list.add(answer2);

		Answer answer3 = new Answer();
		answer3.setAnswerId(list.size()+1);
		answer3.setAnswerLine1("Third answer line 1");
		answer3.setAnswerLine2("Third answer line 2");
		answer3.setOption("Option 1");
		list.add(answer3);

		Answer answer4 = new Answer();
		answer4.setAnswerId(list.size()+1);
		answer4.setAnswerLine1("Fourth answer line 1");
		answer4.setAnswerLine2("Fourth answer line 2");
		answer4.setOption("Option 1");
		list.add(answer4);
		
		Answer answer5 = new Answer();
		answer5.setAnswerId(list.size()+1);
		answer5.setAnswerLine1("Fifth answer line 1");
		answer5.setAnswerLine2("Fifth answer line 2");
		answer5.setOption("Option 1");
		list.add(answer5);
		return list;
	}
}

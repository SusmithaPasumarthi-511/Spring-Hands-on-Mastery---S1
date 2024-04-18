package com.example.question.dao;

import com.example.question.model.Question;
import com.example.question.model.TotalQuestions;

public interface QuestionDAO {

	int deleteById(int id);
	TotalQuestions getAll(int pageNo, int pageSize);
	Question getById(int id);
	int save(Question questions);
	int update(Question questions, int id);
}

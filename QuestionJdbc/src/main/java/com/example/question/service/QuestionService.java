package com.example.question.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.question.dao.QuestionDAOImpl;
import com.example.question.model.Question;
import com.example.question.model.TotalQuestions;




@Service
public class QuestionService {
    @Autowired
    private QuestionDAOImpl questiondaoimpl;
    
    
     
     
    public TotalQuestions getAll(int pageNo, int pageSize)
    {
        return questiondaoimpl.getAll(pageNo, pageSize);
    }
    
    public Question getById(int id)
    {
        return questiondaoimpl.getById(id);
    }
    
    
    public int save(Question question) 
    {

        return questiondaoimpl.save(question);
    }
    

    
    public int update(Question questions, int id)
    {
        return questiondaoimpl.update(questions,id);
    }
    
    public int deleteById(int id)
    {
        return questiondaoimpl.deleteById(id);
    }
    
   
}
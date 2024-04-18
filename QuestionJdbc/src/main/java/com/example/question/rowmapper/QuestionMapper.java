package com.example.question.rowmapper;



import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import org.springframework.jdbc.core.RowMapper;

import com.example.question.model.QuestionDetailsList;
import com.example.question.model.UsersDetails;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;



public class QuestionMapper implements RowMapper<QuestionDetailsList> {


     
   @Override
    public QuestionDetailsList mapRow(ResultSet rs, int rowNum) throws SQLException {
	   ObjectMapper mapper = new ObjectMapper();
	   mapper.setSerializationInclusion(Include.NON_NULL);

        QuestionDetailsList questionlist = new QuestionDetailsList();
        List<QuestionDetailsList> questiondetaillist = new ArrayList<>();
        UsersDetails userdetails = new UsersDetails();
        



        questionlist.setQuestionid(rs.getInt("questionid"));
        questionlist.setQuestionname(rs.getString("questionname"));
        questionlist.setDescription(rs.getString("description"));
        questionlist.setNumberofvotes(rs.getInt("numberofvotes"));
        questionlist.setNumberofviews(rs.getInt("numberofviews"));
        questionlist.setCreatedon(rs.getString("createdon"));
        questionlist.setModifiedon(rs.getString("modifiedon"));
    
        userdetails.setUsername(rs.getString("username"));
        userdetails.setReputationscore(rs.getInt("reputationscore"));
        userdetails.setNumberofgoldbadges(rs.getInt("numberofgoldbadges"));
        userdetails.setNumberofbronzebadges(rs.getInt("numberofbronzebadges"));
        userdetails.setNumberofsilverbadges(rs.getInt("numberofsilverbadges"));
        questionlist.setUsersDetails(userdetails);
        questiondetaillist.add(questionlist);

        
    return questionlist;
    }
}
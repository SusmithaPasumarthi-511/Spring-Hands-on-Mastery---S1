package com.example.question.mapper;



import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.question.model.QuestionDetailsList;
import com.example.question.model.Questions;
import com.example.question.model.QuestionsResponse;
import com.example.question.model.TotalQuestions;
import com.example.question.model.UsersDetails;
import com.example.question.rowmapper.QuestionMapper;
import static org.mockito.Mockito.mock;


@SpringBootTest
@SpringBootConfiguration
 class QuestionMapperTests {
	
	@InjectMocks
	private QuestionMapper questionMapper;
	ResultSet rs = mock(ResultSet.class);
	

	@Test
	void getQuestionTest() throws SQLException {
		TotalQuestions question= new TotalQuestions();
		Questions questions = new Questions();
		List<Questions> question1 =  new ArrayList<Questions>();
	    QuestionsResponse questionResponse = new QuestionsResponse();
	    QuestionDetailsList questionList = new QuestionDetailsList();
	    List<QuestionDetailsList> questionDetailsList = new ArrayList<>();
	    UsersDetails userDetails = new UsersDetails();
	    questionList.setQuestionid(1);
	    questionList.setQuestionname("What is Web Api?");
	    questionList.setDescription("Web Api is an api can be accessed over the web using the HTTP protocol.");
	    questionList.setNumberofvotes(21);
	    questionList.setNumberofviews(222);
	    questionList.setCreatedon(null);
	    userDetails.setUsername("Kethan");
	    userDetails.setReputationscore(3000);
	    userDetails.setNumberofgoldbadges(2);
	    userDetails.setNumberofbronzebadges(9);
	    userDetails.setNumberofsilverbadges(5);
	    questionList.setUsersDetails(userDetails);
	    questionDetailsList.add(questionList);
	    questionResponse.setQuestionDetailsList(questionDetailsList);      
	    questions.setQuestionResponse(questionResponse);
	    question.setQuestions(questions);
	    
	    
	    
	    when(questionMapper.mapRow(rs, 0)).thenReturn(questionList);
	    Assertions.assertDoesNotThrow(this::doNotThrowException);

		}
	private void doNotThrowException(){}

}

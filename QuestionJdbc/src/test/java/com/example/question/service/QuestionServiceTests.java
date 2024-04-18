package com.example.question.service;


import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.question.dao.QuestionDAOImpl;
import com.example.question.model.Question;
import com.example.question.model.QuestionDetails;
import com.example.question.model.QuestionDetailsList;
import com.example.question.model.QuestionResponse;
import com.example.question.model.Questions;
import com.example.question.model.QuestionsResponse;
import com.example.question.model.TotalQuestions;
import com.example.question.model.UsersDetails;


@SpringBootTest
@SpringBootConfiguration
 class QuestionServiceTests {
	
	@InjectMocks
	private QuestionService service;

	@Mock
	private QuestionDAOImpl questiondaoimpl;

	@Test
	void getQuestionTest() {
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
	    
	    
	    
	    when(questiondaoimpl.getAll(1, 2)).thenReturn(question);
	    assertEquals(question, service.getAll(1, 2));   
		}

	
	
	@Test
	void getByIdTest() {
		
		
		Question question = new Question();
	    QuestionResponse questionResponse = new QuestionResponse();
	    QuestionDetails questionDetails = new QuestionDetails();
	    QuestionDetailsList questionList = new QuestionDetailsList();
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
	    questionDetails.setQuestionsList(questionList);
	    questionResponse.setQuestionDetails(questionDetails);      
	    question.setQuestionResponse(questionResponse);
	    
	    
    when(questiondaoimpl.getById(question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid())).thenReturn(question);
    assertEquals(question, service.getById(questionList.getQuestionid()));   
	}

	@Test
	void saveTest() {

		Question question = new Question();
	    QuestionResponse questionResponse = new QuestionResponse();
	    QuestionDetails questionDetails = new QuestionDetails();
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
	    questionDetails.setQuestionsList(questionList);
	    questionResponse.setQuestionDetails(questionDetails);      
	    question.setQuestionResponse(questionResponse);

		when(questiondaoimpl.save(question)).thenReturn(11);

		
		assertEquals(11, service.save(question));
		
		

	}

	@Test
	void updateTest() {

//		Questions question = new Questions();
//	    QuestionsResponse questionResponse = new QuestionsResponse();
//	    QuestionDetailsList questionList = new QuestionDetailsList();
//	    List<QuestionDetailsList> questionDetailsList = new ArrayList<>();
//	    UsersDetails userDetails = new UsersDetails();
//	    questionList.setQuestionid(1);
//	    questionList.setQuestionname("What is Web Api?");
//	    questionList.setDescription("Web Api is an api can be accessed over the web using the HTTP protocol.");
//	    questionList.setNumberofvotes(21);
//	    questionList.setNumberofviews(222);
//	    questionList.setCreatedon(null);
//	    userDetails.setUsername("Kethan");
//	    userDetails.setReputationscore(3000);
//	    userDetails.setNumberofgoldbadges(2);
//	    userDetails.setNumberofbronzebadges(9);
//	    userDetails.setNumberofsilverbadges(5);
//	    questionList.setUsersDetails(userDetails);
//	    questionDetailsList.add(questionList);
//	    questionResponse.setQuestionDetailsList(questionDetailsList);      
//	    question.setQuestionResponse(questionResponse);
		
		Question question = new Question();
        QuestionResponse questionResponse = new QuestionResponse();
        QuestionDetails questionDetails = new QuestionDetails();
        QuestionDetailsList questionList = new QuestionDetailsList();
        List<QuestionDetailsList> questionDetailsList = new ArrayList<>();
        UsersDetails userDetails = new UsersDetails();
        questionList.setQuestionid(1);
        questionList.setQuestionname("What is Web Api?");
        questionList.setDescription("Web Api is an api can be accessed over the web using the HTTP protocol.");
        questionList.setNumberofvotes(34);
        questionList.setNumberofviews(345);
        questionList.setCreatedon(null);
        userDetails.setUsername("Kethan");
        userDetails.setReputationscore(1000);
        userDetails.setNumberofgoldbadges(5);
        userDetails.setNumberofbronzebadges(7);
        userDetails.setNumberofsilverbadges(2);
        questionList.setUsersDetails(userDetails);
        questionDetails.setQuestionsList(questionList);
        questionResponse.setQuestionDetails(questionDetails);      
        question.setQuestionResponse(questionResponse);
	    
	    
    
    
    when(questiondaoimpl.update(question,question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid())).thenReturn(11);

	
	assertEquals(11, service.update(question,question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid()));
	

	}

	@Test
	void deleteTest() {
		
		
		Questions question = new Questions();
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
	    question.setQuestionResponse(questionResponse);
    

		service.deleteById( question.getQuestionResponse().getQuestionDetailsList().get(0).getQuestionid());
		verify(questiondaoimpl, times(1)).deleteById(question.getQuestionResponse().getQuestionDetailsList().get(0).getQuestionid());
	}

}

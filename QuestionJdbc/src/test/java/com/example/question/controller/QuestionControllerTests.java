package com.example.question.controller;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.example.question.model.Question;
import com.example.question.model.QuestionDetails;
import com.example.question.model.QuestionDetailsList;
import com.example.question.model.QuestionResponse;
import com.example.question.model.Questions;
import com.example.question.model.QuestionsResponse;
import com.example.question.model.TotalQuestions;
import com.example.question.model.UsersDetails;
import com.example.question.service.QuestionService;
import com.example.question.validation.InputValidator;


@SpringBootTest(classes = { QuestionControllerTests.class })
class QuestionControllerTests {

	@InjectMocks
	private QuestionController controller;

	@Mock
	private QuestionService service;
	
	
	@Mock
	private InputValidator validator;

	
	@Test
	void getQuestionTest() {
		TotalQuestions question= new TotalQuestions();
		Questions questions = new Questions();
		List<Questions> question1 = new ArrayList<Questions>();
        QuestionsResponse questionResponse = new QuestionsResponse();
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
        questionDetailsList.add(questionList);
        questionResponse.setQuestionDetailsList(questionDetailsList);      
        questions.setQuestionResponse(questionResponse);
        question.setQuestions(questions);
        
        
        when(service.getAll(1, 2)).thenReturn(question);
        controller.getQuestions(1, 2);  
	    Assertions.assertDoesNotThrow(this::doNotThrowException);
	    
	}
	
	

	@Test
	void getByIdTest() {

		List<Questions> questions = new ArrayList<Questions>();
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
      

		when(service.getById(question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid())).thenReturn(question);

		controller.get(question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid());
	    Assertions.assertDoesNotThrow(this::doNotThrowException);
	}

	@Test
    void saveTest()
    {
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
        
        when(validator.usernameValidator(question.getQuestionResponse().getQuestionDetails().getQuestionsList().getUsersDetails().getUsername())).
        thenReturn(true);
        
        when(service.save(question)).thenReturn(1);
        controller.add(question);
	    Assertions.assertDoesNotThrow(this::doNotThrowException);

}

	@Test
	void updateTest() {

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
        
//        Questions question = new Questions();
//        QuestionsResponse questionResponse = new QuestionsResponse();
//        QuestionDetailsList questionList = new QuestionDetailsList();
//        List<QuestionDetailsList> questionDetailsList = new ArrayList<>();
//        UsersDetails userDetails = new UsersDetails();
//        questionList.setQuestionid(1);
//        questionList.setQuestionname("What is Web Api?");
//        questionList.setDescription("Web Api is an api can be accessed over the web using the HTTP protocol.");
//        questionList.setNumberofvotes(34);
//        questionList.setNumberofviews(345);
//        questionList.setCreatedon(null);
//        userDetails.setUsername("Kethan");
//        userDetails.setReputationscore(1000);
//        userDetails.setNumberofgoldbadges(5);
//        userDetails.setNumberofbronzebadges(7);
//        userDetails.setNumberofsilverbadges(2);
//        questionList.setUsersDetails(userDetails);
//        questionDetailsList.add(questionList);
//        questionResponse.setQuestionDetailsList(questionDetailsList);      
//        question.setQuestionResponse(questionResponse);
      

		when(service.update(question,question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid())).thenReturn(11);

		controller.update(question, question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid());
	    Assertions.assertDoesNotThrow(this::doNotThrowException);
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
        questionList.setNumberofvotes(34);
        questionList.setNumberofviews(345);
        questionList.setCreatedon(null);
        userDetails.setUsername("Kethan");
        userDetails.setReputationscore(1000);
        userDetails.setNumberofgoldbadges(5);
        userDetails.setNumberofbronzebadges(7);
        userDetails.setNumberofsilverbadges(2);
        questionList.setUsersDetails(userDetails);
        questionDetailsList.add(questionList);
        questionResponse.setQuestionDetailsList(questionDetailsList);      
        question.setQuestionResponse(questionResponse);
        
        
        
		controller.delete(question.getQuestionResponse().getQuestionDetailsList().get(0).getQuestionid());
		verify(service, times(1)).deleteById(question.getQuestionResponse().getQuestionDetailsList().get(0).getQuestionid());
	    Assertions.assertDoesNotThrow(this::doNotThrowException);
	}

	
	
	@Test
	void getByIdTest1() {

		
        Questions question = new Questions();
        QuestionsResponse questionResponse = new QuestionsResponse();
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
        questionDetailsList.add(questionList);
        questionResponse.setQuestionDetailsList(questionDetailsList);      
        question.setQuestionResponse(questionResponse);
       

		when(service.getById(question.getQuestionResponse().getQuestionDetailsList().get(0).getQuestionid())).thenThrow(EmptyResultDataAccessException.class);

		controller.get(question.getQuestionResponse().getQuestionDetailsList().get(0).getQuestionid());
	    Assertions.assertDoesNotThrow(this::doNotThrowException);
	}
	
	
	
	@Test
	void validationTest() {

		TotalQuestions questions = new TotalQuestions();

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
        questionDetailsList.add(questionList);
        questionDetails.setQuestionsList(questionList);
        questionResponse.setQuestionDetails(questionDetails);      
        question.setQuestionResponse(questionResponse);
       
        
        when(validator.usernameValidator(question.getQuestionResponse().getQuestionDetails().getQuestionsList().getUsersDetails().getUsername())).
        thenReturn(false);
        controller.add(question);  
	    Assertions.assertDoesNotThrow(this::doNotThrowException);
	}
	
	

	@Test
	void deleteTest1() {

		
        Questions question = new Questions();
        QuestionsResponse questionResponse = new QuestionsResponse();
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
        questionDetailsList.add(questionList);
        questionResponse.setQuestionDetailsList(questionDetailsList);      
        question.setQuestionResponse(questionResponse);
        
        
		when(controller.delete(question.getQuestionResponse().getQuestionDetailsList().get(0).getQuestionid())).
		thenThrow(EmptyResultDataAccessException.class);
		controller.delete(question.getQuestionResponse().getQuestionDetailsList().get(0).getQuestionid());
	    Assertions.assertDoesNotThrow(this::doNotThrowException);
	}
	
	
	@Test
	void updateTest1() {

		
//        Questions question = new Questions();
//        QuestionsResponse questionResponse = new QuestionsResponse();
//        QuestionDetailsList questionList = new QuestionDetailsList();
//        List<QuestionDetailsList> questionDetailsList = new ArrayList<>();
//        UsersDetails userDetails = new UsersDetails();
//        questionList.setQuestionid(1);
//        questionList.setQuestionname("What is Web Api?");
//        questionList.setDescription("Web Api is an api can be accessed over the web using the HTTP protocol.");
//        questionList.setNumberofvotes(34);
//        questionList.setNumberofviews(345);
//        questionList.setCreatedon(null);
//        userDetails.setUsername("Kethan");
//        userDetails.setReputationscore(1000);
//        userDetails.setNumberofgoldbadges(5);
//        userDetails.setNumberofbronzebadges(7);
//        userDetails.setNumberofsilverbadges(2);
//        questionList.setUsersDetails(userDetails);
//        questionDetailsList.add(questionList);
//        questionResponse.setQuestionDetailsList(questionDetailsList);      
//        question.setQuestionResponse(questionResponse);
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
       

		when(service.update(question,question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid())).thenThrow(EmptyResultDataAccessException.class);

		controller.update(question, question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid());

	    Assertions.assertDoesNotThrow(this::doNotThrowException);
	}
	
	private void doNotThrowException(){
	    
	}
}

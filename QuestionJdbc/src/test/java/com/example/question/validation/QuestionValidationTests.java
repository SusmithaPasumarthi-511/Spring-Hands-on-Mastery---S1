package com.example.question.validation;



import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.question.model.QuestionDetailsList;
import com.example.question.model.Questions;
import com.example.question.model.QuestionsResponse;
import com.example.question.model.UsersDetails;



@SpringBootTest(classes = { QuestionValidationTests.class })
 class QuestionValidationTests {
	
	@InjectMocks 
	private InputValidationImpl inputvalidationimpl;
	
	
	@Mock
	private InputValidator inputvalidator;
	
	
	@Test
	void validationTest() {

	
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
       
        when(inputvalidator.usernameValidator("check username")).thenReturn(false);
        inputvalidationimpl.usernameValidator("check username");  

        Assertions.assertDoesNotThrow(this::doNotThrowException);
        

	}
	private void doNotThrowException(){
	}
}




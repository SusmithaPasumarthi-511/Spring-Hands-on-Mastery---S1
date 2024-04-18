package com.example.question.dao;




import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.question.model.TotalQuestions;

import com.example.question.dao.QuestionDAOImpl;
import com.example.question.model.PagingDetailsList;
import com.example.question.model.PagingList;
import com.example.question.model.Question;
import com.example.question.model.QuestionDetails;
import com.example.question.model.QuestionDetailsList;
import com.example.question.model.QuestionResponse;
import com.example.question.model.Questions;
import com.example.question.model.QuestionsResponse;
import com.example.question.model.Response;
import com.example.question.model.UsersDetails;

@SpringBootTest(classes = { QuestionDaoTests.class })
 class QuestionDaoTests {
	
	 @InjectMocks
	   private QuestionDAOImpl questiondaoimpl;
	 
	 @Mock
	   private QuestionDAO questiondao;
	 
	 @Mock
	 private JdbcTemplate jdbctemplate;
	 
	 

	    @Test
	    void getQuestionTest() {
			TotalQuestions questions = new TotalQuestions();
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

	        questions.setQuestions(question);
	        questions.getQuestions();
	        questions.getPagingDetailsList();
	        
             PagingDetailsList pagingDetailsList = new PagingDetailsList();
             pagingDetailsList.getLimits();
             pagingDetailsList.getTotalnumberofpages();
             pagingDetailsList.getPagingList();
             
             PagingList pagingList=new PagingList();
             pagingList.getId();
             pagingList.getPagenumber();
             pagingList.getClass();
             
            questionResponse.getQuestionDetailsList();
            questionResponse.getTotalNoOfQuestions();
	      
	        
	        when(questiondao.getAll(1, 2)).thenReturn(questions);
	        questiondaoimpl.getAll(1, 2);  
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

			when(questiondao.getById(question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid())).thenReturn(question);

			questiondaoimpl.getById(question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid());
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
	        
	        
	        when(questiondao.save(question)).thenReturn(1);
	        questiondaoimpl.save(question);
	        Assertions.assertDoesNotThrow(this::doNotThrowException);
	}
	    @Test
		void updateTest() {
	    	
//			List<Questions> questions = new ArrayList<Questions>();
//	        Questions question = new Questions();
//	        QuestionsResponse questionResponse = new QuestionsResponse();
//	        QuestionDetailsList questionList = new QuestionDetailsList();
//	        List<QuestionDetailsList> questionDetailsList = new ArrayList<>();
//	        UsersDetails userDetails = new UsersDetails();
//	        questionList.setQuestionid(1);
//	        questionList.setQuestionname("What is Web Api?");
//	        questionList.setDescription("Web Api is an api can be accessed over the web using the HTTP protocol.");
//	        questionList.setNumberofvotes(34);
//	        questionList.setNumberofviews(345);
//	        questionList.setCreatedon(null);
//	        userDetails.setUsername("Kethan");
//	        userDetails.setReputationscore(1000);
//	        userDetails.setNumberofgoldbadges(5);
//	        userDetails.setNumberofbronzebadges(7);
//	        userDetails.setNumberofsilverbadges(2);
//	        questionList.setUsersDetails(userDetails);
//	        questionDetailsList.add(questionList);
//	        questionResponse.setQuestionDetailsList(questionDetailsList);      
//	        question.setQuestionResponse(questionResponse);
//	        questions.add(question);
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
	        Response response= new Response();
	       response.getMessage();
	       response.getQuestion();
	       response.getQuestions();

			when(questiondao.update(question,question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid())).thenReturn(11);

			questiondaoimpl.update(question, question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid());
			  Assertions.assertDoesNotThrow(this::doNotThrowException);
		}

		@Test
		void deleteTest() {

			List<Questions> questions = new ArrayList<Questions>();
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
	        questions.add(question);
	        
	        
			questiondao.deleteById(question.getQuestionResponse().getQuestionDetailsList().get(0).getQuestionid());
			questiondaoimpl.deleteById(question.getQuestionResponse().getQuestionDetailsList().get(0).getQuestionid());
			  Assertions.assertDoesNotThrow(this::doNotThrowException);
		}
		
		private void doNotThrowException(){
		}
}



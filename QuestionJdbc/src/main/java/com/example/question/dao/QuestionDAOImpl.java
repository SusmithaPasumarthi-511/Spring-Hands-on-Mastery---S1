package com.example.question.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.question.model.PagingDetailsList;
import com.example.question.model.PagingList;
import com.example.question.model.Question;
import com.example.question.model.QuestionDetails;
import com.example.question.model.QuestionDetailsList;
import com.example.question.model.QuestionResponse;
import com.example.question.model.Questions;
import com.example.question.model.QuestionsResponse;
import com.example.question.model.TotalQuestions;
import com.example.question.rowmapper.QuestionMapper;

@Repository
public class QuestionDAOImpl implements QuestionDAO {


	@Autowired
	JdbcTemplate jdbcTemplate;

	


	
	@Override
	public int save(Question questions) {
		
		Date date=new Date();
        SimpleDateFormat dateForm=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        questions.getQuestionResponse().getQuestionDetails().getQuestionsList().setCreatedon(dateForm.format(date));
        
		  return jdbcTemplate.update("INSERT INTO jdbc (questionid, questionname, description, numberofvotes, numberofviews,  username, reputationscore, numberofgoldbadges, numberofbronzebadges, numberofsilverbadges) VALUES (?,?,?,?,?,?,?,?,?,?)",
                questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid(),				
                questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionname(),

                        questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getDescription(),
                        questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getNumberofvotes(),
                        questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getNumberofviews(),
     questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getUsersDetails().getUsername(),
     questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getUsersDetails().getReputationscore(),
     questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getUsersDetails().getNumberofgoldbadges(),
     questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getUsersDetails().getNumberofbronzebadges(),
     questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getUsersDetails().getNumberofsilverbadges() );

	
	}

	

	@Override
    public int update(Question questions, int id) {
    	
    	
    	Date date=new Date();
        SimpleDateFormat dateForm=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        questions.getQuestionResponse().getQuestionDetails().getQuestionsList().setModifiedon(dateForm.format(date));
        
    	
        return jdbcTemplate.update("UPDATE jdbc SET questionname=?, description=?, numberofvotes=?, numberofviews=?,modifiedon=?, reputationscore=?,numberofgoldbadges=?, numberofbronzebadges=?, numberofsilverbadges=? WHERE questionid = ?",
                questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionname(),
                        questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getDescription(),
                        questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getNumberofvotes(),
                        questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getNumberofviews(),
                      questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getModifiedon(),
     questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getUsersDetails().getReputationscore(),
     questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getUsersDetails().getNumberofgoldbadges(),
     questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getUsersDetails().getNumberofbronzebadges(),
     questions.getQuestionResponse().getQuestionDetails().getQuestionsList().getUsersDetails().getNumberofsilverbadges(), id);
   
	}

    
	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE From jdbc WHERE questionid=?", id);
	}


	
	@Override
	public TotalQuestions getAll(int pageNo, int pageSize) {
		TotalQuestions questions = new TotalQuestions();
		QuestionsResponse questionsResponse= new QuestionsResponse();
		PagingDetailsList pagingdetails = new PagingDetailsList();
		Questions question1= new Questions();
		List<PagingList> paginglist = pagination(pageNo, pageSize);
		List <QuestionDetailsList> question =jdbcTemplate.query("select * from jdbc", new QuestionMapper());
		
		long total = question.stream().count();
		
		int flag;
		if (total % pageSize == 0) {
            flag = 0;
        } else {
            flag = 1;
        }
      long totalPage = (total / pageSize) + (((total % pageSize) / pageSize) + flag);
      
		Pageable paging = PageRequest.of(pageNo-1, pageSize);
		int start = Math.min((int)paging.getOffset(), question.size());
		int end = Math.min((start + paging.getPageSize()), question.size());
		Page<QuestionDetailsList> page = new PageImpl<>(question.subList(start, end), paging, question.size());
		
		questionsResponse.setTotalNoOfQuestions(total);
		questionsResponse.setQuestionDetailsList(page.getContent());
		question1.setQuestionResponse(questionsResponse);
		questions.setQuestions(question1);

		
		pagingdetails.setLimits(pageSize);
		pagingdetails.setTotalnumberofpages( (int) totalPage);
		pagingdetails.setPagingList(paginglist); 
		
		questions.setPagingDetailsList(pagingdetails);
		
		return questions;
		
	}
	
	
	
	public List<PagingList> pagination(int pageNumber,int pageSize){
		List <QuestionDetailsList> question =jdbcTemplate.query("select * from jdbc", new QuestionMapper());

        List<PagingList> pagelist = new ArrayList<>();

        long total = question.stream().count();
		int flag;
		if (total % pageSize == 0) {
            flag = 0;
        } else {
            flag = 1;
        }
		
      long totalPage = (total / pageSize) + (((total % pageSize) / pageSize) + flag);
      
      if(pageNumber>totalPage) {

   	   PagingList page = new PagingList();
          page.setId("Page Not Available");
          page.setPagenumber(pageNumber);

          pagelist.add(page);
    	  
      }
      
      
      else if(pageSize== total) {
    	  
    	   PagingList page = new PagingList();
           page.setId("CURRENT");
           page.setPagenumber(pageNumber);

           pagelist.add(page);

      }
      
      
      else if(pageNumber==1) {
            PagingList page = new PagingList();
            page.setId("Current");
            page.setPagenumber(pageNumber);
            
            PagingList page1 = new PagingList();
            page1.setId("next");
            page1.setPagenumber((pageNumber+1));
            
            pagelist.add(page);
            pagelist.add(page1);
            
            
        }
        
        
        
            else if(pageNumber == totalPage) {
                PagingList page = new PagingList();
                page.setId("current");
                
                page.setPagenumber(pageNumber);
                
                PagingList page1 = new PagingList();
                page1.setId("previous");
                page1.setPagenumber((pageNumber-1));
                
                pagelist.add(page);
                pagelist.add(page1);
        }
      
            		
      
            else {
            PagingList page = new PagingList();
            page.setId("current");
            page.setPagenumber(pageNumber);
            
            PagingList page1 = new PagingList();
            page1.setId("next");
            page1.setPagenumber((pageNumber+1));
            
            PagingList page2 = new PagingList();
            page2.setId("previous");
            page2.setPagenumber((pageNumber-1));


            
  
            pagelist.add(page2);
            pagelist.add(page);
            pagelist.add(page1);
    }
      
          
        
        return pagelist;
    }
	
	
	
	
	@Override
	public Question getById(int id) {
		Question question = new Question();
		QuestionDetails questionsDetails= new QuestionDetails();
		QuestionResponse questionsResponse= new QuestionResponse();
		QuestionDetailsList questionDetailsList= jdbcTemplate.queryForObject("SELECT * FROM jdbc WHERE questionid=?",new QuestionMapper(),id);	
		questionsDetails.setQuestionsList(questionDetailsList);
		questionsResponse.setQuestionDetails(questionsDetails);
		question.setQuestionResponse(questionsResponse);
		return question;
		}
	}
	


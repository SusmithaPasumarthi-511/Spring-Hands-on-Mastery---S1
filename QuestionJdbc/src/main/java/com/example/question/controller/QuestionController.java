package com.example.question.controller;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.question.model.Message;
import com.example.question.model.Question;
import com.example.question.model.Response;
import com.example.question.service.QuestionService;
import com.example.question.validation.InputValidator;

@RequestMapping("/api/v1")
@RestController




public class QuestionController { 

	RestTemplate resttemplate = new RestTemplate();

	@Autowired
	private QuestionService questionsservice;
	
	@Autowired
   private  InputValidator validate; 
	
	
	@GetMapping("/Questions")
	public ResponseEntity<Object> getQuestions(@RequestParam(value = "pageNo" , defaultValue = "1", required = false)int pageNo,@RequestParam(value = "pageSize" , defaultValue = "2", required = false) int pageSize) 
	{
	
		return new ResponseEntity<>(questionsservice.getAll(pageNo,pageSize), HttpStatus.OK);
		
	}


	
	@GetMapping("/questions/{id}")
	public ResponseEntity<Object> get(@PathVariable int id)
	{
		try {
			Question question = questionsservice.getById(id);
			
			return new ResponseEntity<>(question, HttpStatus.OK);
		} catch (Exception e) {
			Message message = new Message();
			message.setCode(404);
			message.setDesc("Id not present in database...");
			message.setType(" NOT FOUND");
			return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		}

	
	}
	
	

	
	@PostMapping("/questions")
	public ResponseEntity<Object> add(@RequestBody Question question )  {
		if(question.getQuestionResponse().getQuestionDetails().getQuestionsList().getUsersDetails().getUsername()!=null && question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid()>0) {
		if (!validate.usernameValidator(question.getQuestionResponse().getQuestionDetails().getQuestionsList().getUsersDetails().getUsername())) {
            Response response = new Response();
            Message message = new Message();
            message.setType("Bad Request");
            message.setCode(400);
            message.setDesc("Check User Name....");
            
            response.setMessage(message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }	
		try {
            questionsservice.getById(question.getQuestionResponse().getQuestionDetails().getQuestionsList().getQuestionid());
            Message message = new Message();
            message.setCode(409);
            message.setDesc("Id already present in database");
            message.setType("409 conflict");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        } catch (Exception e) {
			
			questionsservice.save(question);
             Message message = new Message();
             Response response=new Response();
              message.setCode(201);
              message.setDesc("Id created successsfully");
              message.setType("201 CREATED");
              response.setMessage(message);
              response.setQuestion(question);
             return new ResponseEntity<>(response, HttpStatus.CREATED);
		}	
	}else {
            Response response = new Response();
            Message message = new Message();
            message.setType("Bad Request");
            message.setCode(400);
            message.setDesc("check userName/Questionid should not be null");
            response.setMessage(message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
     }
		}
		
	



	@PutMapping("/questions/{id}")
	public ResponseEntity<Object> update(@RequestBody Question question, @PathVariable int id) {

		try {
			
			questionsservice.getById(id);
	
				questionsservice.update(question, id);
				Message message = new Message();
				Response response = new Response();
				message.setCode(200);
				message.setDesc("Question updated successsfully..");
				message.setType("200 OK");
				response.setMessage(message);
				response.setQuestion(questionsservice.getById(id));
				return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			Message message = new Message();
			message.setCode(409);
			message.setDesc("Id is not present in database, can't update.");
			message.setType("409 CONFLICT");
			return new ResponseEntity<>(message, HttpStatus.CONFLICT);
		}
	}
	

	@DeleteMapping("/questions/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id) {
		try {
			questionsservice.getById(id);
			questionsservice.deleteById(id);
			Message message = new Message();
			message.setCode(200);
			message.setDesc("Question deleted successsfully..");
			message.setType("200 OK");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			Message message = new Message();
			message.setCode(404);
			message.setDesc("Id not Found ");
			message.setType("NOT FOUND");
			return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		}
	}

}
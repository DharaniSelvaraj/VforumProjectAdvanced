package com.vforum.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.vforum.model.Answers;
import com.vforum.model.Questions;
import com.vforum.service.AnswerService;
import com.vforum.service.EmployeeService;
import com.vforum.service.QuestionService;

@Controller
public class AnswerController {

	 @Autowired
	    private EmployeeService employeeService;
	    @Autowired
	    private AnswerService answerService;
	    @Autowired
	    private QuestionService questionService;
	    
	    @RequestMapping(value ="/postAnswer", method = RequestMethod.GET)    
	    public ModelAndView postAnswer(ModelAndView model,HttpSession session,HttpServletRequest request){    
	    	Answers answer=new Answers();
	    	long milli=System.currentTimeMillis();
			Date currentDate=new Date(milli);
	    	answer.setDate(currentDate);
	    	int employeeId=(Integer) session.getAttribute("employeeId");
	    	int questionId = Integer.parseInt(request.getParameter("id"));
	    	answer.setQuestion(questionService.getQuestion(questionId));
	        answer.setEmployee(employeeService.getEmployee(employeeId));
	    	model.addObject("answer", answer);
	        model.setViewName("Answer");
	        
	        return model;
	       
  
	       
	    }
	 
	    @RequestMapping(value = "/addAnswer", method = RequestMethod.POST)
	    public ModelAndView addAnswer(@ModelAttribute Answers answer) {
	    	
	    	answerService.addAnswer(answer);
	        ModelAndView m=new ModelAndView();
	        List<Questions> allQuestions=questionService.getAllQuestions();
	        m.addObject("allQuestions",allQuestions);
	        List<Answers> allAnswers=answerService.getAllAnswers();
	        m.addObject("allAnswers",allAnswers);
	        m.setViewName("display");
	        return m;
	       
	    }
	    @RequestMapping(value = "/editAnswer", method = RequestMethod.GET)
	    public ModelAndView editAnswer(HttpServletRequest request) {
	        int answerId = Integer.parseInt(request.getParameter("aid"));
	        Answers answer = answerService.getAnswer(answerId);
	        ModelAndView model = new ModelAndView();
	        model.addObject("answer", answer);
	        model.setViewName("editAnswer");
	        return model;
	    }
	   
	    @RequestMapping(value = "/editAnswerProcess", method = RequestMethod.GET)
	    public ModelAndView editAnswerProcess(@ModelAttribute Answers answer) {
	    	answerService.editAnswer(answer);
	        ModelAndView model = new ModelAndView();
	        List<Questions> allQuestions=questionService.getAllQuestions();
	        model.addObject("allQuestions",allQuestions);
	        List<Answers> allAnswers=answerService.getAllAnswers();
	        model.addObject("allAnswers",allAnswers);
	        model.setViewName("display");
	        return model;
	    }
	    @RequestMapping(value = "/deleteAnswer", method = RequestMethod.GET)
	    public ModelAndView deleteQuestion(HttpServletRequest request) {
	        int answerId = Integer.parseInt(request.getParameter("aid"));
	        Answers answer = answerService.getAnswer(answerId);
	        answerService.deleteAnswer(answer);
	        ModelAndView model = new ModelAndView();
	        List<Questions> allQuestions=questionService.getAllQuestions();
	        model.addObject("allQuestions",allQuestions);
	        List<Answers> allAnswers=answerService.getAllAnswers();
	        model.addObject("allAnswers",allAnswers);
	        model.setViewName("display");
	        return model;
	    }
	    

}

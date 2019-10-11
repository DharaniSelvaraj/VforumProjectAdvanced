package com.vforum.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.vforum.model.Answers;
import com.vforum.model.Category;
import com.vforum.model.Employee;
import com.vforum.model.Questions;
import com.vforum.service.AnswerService;
import com.vforum.service.CategoryService;
import com.vforum.service.EmployeeService;
import com.vforum.service.QuestionService;

@Controller
@SessionAttributes("employeeId")
public class CategoryController {
		@Autowired
		private EmployeeService employeeService;
		@Autowired
		private AnswerService answerService;
		@Autowired
		private QuestionService questionService;
	    @Autowired
		private CategoryService categoryService;
	   
	    @RequestMapping(value = "/selectedCategory", method = RequestMethod.GET)
	    public ModelAndView selectCategory(ModelAndView model,HttpServletRequest request) {
	         
	         int categoryId = Integer.parseInt(request.getParameter("categoryId"));
	         Category category=categoryService.getCategoryById(categoryId);
	         List<Questions> allQuestions=questionService.getAllQuestionByCategory(categoryId);
		     model.addObject("allQuestions",allQuestions);
		     List<Answers> allAnswers=answerService.getAllAnswers();
		     model.addObject("allAnswers",allAnswers);
	        // ModelAndView model = new ModelAndView();
	        //model.addObject();
	          model.setViewName("display");
	        return model;
	    }
}

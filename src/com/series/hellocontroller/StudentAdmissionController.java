package com.series.hellocontroller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {
	
	@InitBinder
  public void InitBuilder(WebDataBinder binder)	{
		//binder.setDisallowedFields(new String[] {"studentMobile"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		binder.registerCustomEditor(Date.class, "studentDoB", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}
	

	@RequestMapping(value="/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() throws Exception{
		
		String exceptionOccured = "ARITHMETIC_EXCEPTION";
		//ARITHMETIC_EXCEPTION
		
		if(exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
			
			throw new NullPointerException("Null pointer Exception");
			
		} else if(exceptionOccured.equalsIgnoreCase("IO_EXCEPTION")) {
			throw new IOException("IO Exception");
		} else if(exceptionOccured.equalsIgnoreCase("ARITHMETIC_EXCEPTION")) {
			
			throw new ArithmeticException("Arithmetic Exception");
		}
		
		
		ModelAndView model = new ModelAndView("AdmissionForm");
		//model.addObject("headerMsg", "Zhou college of Engineering, America.");

		return model;
	}
	
			//model attribute annotation as a method level.
			//creates a universial spel variable to all pages.
	
	@ModelAttribute
	public void addCommonObjects(Model model) {
		
		model.addAttribute("headerMsg", "Zhou college of Engineering, America.");
	}
	
	
	
			//model attribute annotation as a parameter level/ method arg.
	@RequestMapping(value ="/submitAdmissionForm.html", method =RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student student1, BindingResult result) {
		
		if(result.hasErrors()) {
			
			ModelAndView model1 = new ModelAndView("AdmissionForm");
			return model1;
		}
		
	
		
	
					//using request param.
//	public ModelAndView submitAdmissionForm(@RequestParam(value = "studentName", defaultValue="Mr.Zhou") String name,
//											@RequestParam("studentHobby") String hobby) {
//		Student student1 = new Student();
//		student1.setStudentName(name);
//		student1.setStudentHobby(hobby);
		
		
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		
		//model.addObject("headerMsg", "Zhou college of Engineering, America.");
					//using request param
		//model.addObject("student1", student1);
	
	
//	public ModelAndView submitAdmissionForm(@RequestParam Map<String,String> pathVars) {
//		
//		String name = pathVars.get("studentName");
//		String hobby = pathVars.get("studentHobby");
		

		
		return model;
	}
	
	
	
	
}

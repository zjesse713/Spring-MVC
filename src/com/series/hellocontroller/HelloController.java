package com.series.hellocontroller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



						//SPRING MVC WITH ANNOTATION STYLE
@Controller //considered as spring controller
public class HelloController { //don't need to extend from any other class. or implement any interface. 
	//also no need to put it's entry in servlet.xml
	
			//matches the url pattern with requestmapping and calls this method
	//@RequestMapping("/welcome/{countryName}/{userName}")
	//public ModelAndView helloWorld(@PathVariable("userName") String name, @PathVariable("countryName") String country) {
	
	
	@RequestMapping("/welcome/{countryName}/{userName}")
	public ModelAndView helloWorld(@PathVariable Map<String,String> pathVars) {
		
		String name = pathVars.get("userName");
		String country = pathVars.get("countryName");
		
		
		//prepare model and view object having data to display in response page.
		//view page will display the returned data.
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "hello "+name+" you are from " + country);
		
		return model;
	}
	
	@RequestMapping("/hi")
	public ModelAndView hiWorld() {
		ModelAndView model= new ModelAndView("HelloPage");
		model.addObject("msg", "Hi world");
		
		return model;
				
	}
	
}



                         //SPRING MVC WITHOUT ANNOTATION STYLE.
//public class HelloController extends AbstractController {
//
//	@Override
//	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		ModelAndView mv = new ModelAndView("HelloPage");
//		mv.addObject("welcomeMessage", "Hi user, welcome to this spring mvc page.");
//
//		return mv;
//	}
//
//}

package com.company.test.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	 Logger log = Logger.getLogger(this.getClass());
	@RequestMapping(value = "/testController.do")
	public ModelAndView testController(){
		log.debug("log");
		ModelAndView mv = new ModelAndView("test");
		
		return mv;
	}
}

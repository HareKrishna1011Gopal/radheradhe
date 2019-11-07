package com.rto.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class ExceptionHandler1 {

	@ExceptionHandler(value = {NullPointerException.class,NumberFormatException.class})
	public String handleNullPointerException(Model model) {
		model.addAttribute("errMsg","Some Problem Occured.Please try again After Sometimes..!");
		return "error";
	}
}

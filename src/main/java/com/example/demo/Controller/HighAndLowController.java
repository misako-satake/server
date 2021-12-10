package com.example.demo.Controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hnl")
public class HighAndLowController {

	
	@Autowired
	private HttpSession session; 
	
	@RequestMapping("")
	public String showGameScreen(Model model) {
		
		return showFirstNum(model);
	}
	
	@RequestMapping("showFirstNum")
	public String showFirstNum(Model model) {
		
		Random rand = new Random();
	    int firstNum = rand.nextInt(13) + 1;
	    System.out.println(firstNum);
	    session.setAttribute("firstNum", firstNum);
		
		return "showResult";
	}
	
	
	
	
	@RequestMapping("showResult")
	public String dohnl(String firstNum, Integer answer, Model model){
		
		System.out.println(answer);
		if(answer != null) {
			
			Random rand = new Random();
			int secondNum = rand.nextInt(13) + 1;
			model.addAttribute("secondNum", secondNum);
			
			
			int firstNumInt = Integer.parseInt(firstNum);
			
			if(secondNum > firstNumInt && answer.equals(1)) {
				model.addAttribute("resultMessage", "YOU WIN!!!!");
			}else if(secondNum < firstNumInt && answer.equals(2)){
				model.addAttribute("resultMessage", "YOU WIN!!!!");
			}else if(secondNum == firstNumInt) {
				model.addAttribute("resultMessage", "DRAW, TRY AGAIN.");
			}
			else {
				model.addAttribute("resultMessage", "YOU LOSE.....");
			}
			
			return "showResult2";
		}
		else {
			return "/hnl";
		}
	}
	
}

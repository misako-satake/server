package com.example.demo.Controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Cards;
import com.example.demo.repository.HnLRepository;


@Controller
@RequestMapping("/hnl")
public class HighAndLowController {

	
	@Autowired
	private HttpSession session; 
	
	@Autowired
	private HnLRepository repository;
	
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
	    
	    Cards card = new Cards();
	    card = repository.findCard(firstNum);
	    String imagepath = card.getImagepath();
	    session.setAttribute("imagepathOfFirstNum", imagepath);
	    
		return "showResult";
	}
	
	
	
	
	@RequestMapping("showResult")
	public String dohnl(String firstNum, Integer answer, Model model){
		
		System.out.println(answer);
		if(answer != null) {
			
			Random rand = new Random();
			int secondNum = rand.nextInt(13) + 1;
			model.addAttribute("secondNum", secondNum);
			
			Cards card = new Cards();
		    card = repository.findCard(secondNum);
		    String imagepath = card.getImagepath();
		    session.setAttribute("imagepathOfSecondNum", imagepath);
			
			
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

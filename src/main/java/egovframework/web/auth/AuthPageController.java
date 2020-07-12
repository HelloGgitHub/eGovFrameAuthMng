package egovframework.web.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class AuthPageController {
	

	/***********************
	 * 기본
	 ***********************/
	@RequestMapping("/") 
	public String Main(Model model) {
		return "MainPage"; 
	}
	
	@RequestMapping("/FrameDown") 
	public String Main3(Model model) {
		return "FrameDown"; 
	}

	@RequestMapping("/FrameLeft") 
	public String FrameLeft(Model model) {
		return "FrameLeft"; 
	}
	@RequestMapping("/FrameTop") 
	public String FrameTop(Model model) {
		return "FrameTop"; 
	}
	
	
	/***********************
	 * 사용자
	 ***********************/
	@RequestMapping("/Login") //ok
	public String Login(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++Login++++++++++++");
		return "Login"; 
	}

	@RequestMapping("/AuthList") 
	public String AuthList(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++AuthList++++++++++++");
		return "/ath/AuthList"; 
	} 
	
	@RequestMapping("/AuthInfo") 
	public String AuthInfo(Model model
			, @RequestParam(value = "callType") String callType
			, @RequestParam(value = "authId") String authId) {
		model.addAttribute("msg", "jstl");
		model.addAttribute("callType", 	callType);
		model.addAttribute("authId", 		authId);
		
		System.out.println("++++++++++++++++AuthInfo++++++++++++authId::"+ authId + "===callType :: "+callType);
		return "/ath/AuthInfo"; 
	}

	@RequestMapping("/AuthGrpList") 
	public String AuthGroupList(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++AuthGrpList++++++++++++");
		return "/athgp/AuthGroupList"; 
	} 
	
	@RequestMapping("/AuthGrpDetailSet") 
	public String AuthGroupInfo(Model model
			, @RequestParam(value = "callType") String callType
			, @RequestParam(value = "authGrpId") String authGrpId) {
		model.addAttribute("msg", 			"jstl");
		model.addAttribute("callType", 	callType);
		model.addAttribute("authGrpId", 	authGrpId);
		
		System.out.println("++++++++++++++++AuthGrpInfo++++++++++++authGrpId::"+ authGrpId + "===callType :: "+callType);
		return "/athgp/AuthGrpDetailSet"; 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
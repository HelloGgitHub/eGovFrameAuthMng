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
		return "Login"; 
	}

	@RequestMapping("/AuthList") 
	public String AuthList(Model model) {
		model.addAttribute("msg", "jstl");
		return "/ath/AuthList"; 
	} 
	
	@RequestMapping("/AuthInfo") 
	public String AuthInfo(Model model
			, @RequestParam(value = "callType") String callType
			, @RequestParam(value = "authId") String authId) {
		model.addAttribute("msg", "jstl");
		model.addAttribute("callType", 	callType);
		model.addAttribute("authId", 		authId);
		return "/ath/AuthInfo"; 
	}

	@RequestMapping("/AuthInfoSetUsr") 
	public String AuthInfoUsr(Model model
			, @RequestParam(value = "callType") String callType
			, @RequestParam(value = "authId") String authId) {
		model.addAttribute("msg", "jstl");
		model.addAttribute("callType", 	callType);
		model.addAttribute("authId", 		authId);
		return "/ath/AuthInfoSetUsr"; 
	}
	
	@RequestMapping("/AuthGrpList") 
	public String AuthGroupList(Model model) {
		model.addAttribute("msg", "jstl");
		return "/athgp/AuthGroupList"; 
	} 
	
	@RequestMapping("/AuthGrpDetailSetAth") 
	public String AuthGroupInfoAth(Model model
			, @RequestParam(value = "callType") String callType
			, @RequestParam(value = "authGrpId") String authGrpId) {
		model.addAttribute("msg", 			"jstl");
		model.addAttribute("callType", 	callType);
		model.addAttribute("authGrpId", 	authGrpId);
		return "/athgp/AuthGrpDetailSetAth"; 
	}

	@RequestMapping("/AuthGrpDetailSetUsr") 
	public String AuthGroupInfoUsr(Model model
			, @RequestParam(value = "callType") String callType
			, @RequestParam(value = "authGrpId") String authGrpId) {
		model.addAttribute("msg", 			"jstl");
		model.addAttribute("callType", 	callType);
		model.addAttribute("authGrpId", 	authGrpId);
		return "/athgp/AuthGrpDetailSetUsr"; 
	}

	@RequestMapping("/AuthGroupInfo") 
	public String AuthGroupInfo(Model model
			, @RequestParam(value = "callType") String callType
			, @RequestParam(value = "authGrpId") String authGrpId) {
		model.addAttribute("msg", 			"jstl");
		model.addAttribute("callType", 	callType);
		model.addAttribute("authGrpId", 	authGrpId);
		return "/athgp/AuthGroupInfo"; 
	}
	
	@RequestMapping("/MenuInfo") 
	public String MenuInfo(Model model
			) {
		model.addAttribute("msg", 			"jstl");
		return "/mnu/MenuInfo"; 
	}

}
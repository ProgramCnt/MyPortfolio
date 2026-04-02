package com.psj.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.psj.project.ApiKey;
import com.psj.project.model.CompanyModel;
import com.psj.project.model.UserDataModel;
import com.psj.project.service.ExposeMainDataService;
import com.psj.project.service.UserDataService;
import com.psj.project.util.AESUtil;
import com.psj.project.util.DateValidityUtil;

import ch.qos.logback.core.model.Model;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ApiController {
	
	ExposeMainDataService mainService;
	
	public ApiController(ExposeMainDataService mainService) {
        this.mainService = mainService;
    }
		
	@RequestMapping("/test.do")
	public ModelAndView Main(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("skillList", mainService.getSkills());
		mv.addObject("educationList", mainService.getEducationData());
		mv.addObject("activityList", mainService.getActivities());
		mv.addObject("personalInfo", mainService.getPersonalInfo());
		mv.addObject("qualifications", mainService.getQualifications());
		mv.addObject("companyList", mainService.getCompanies());
		mv.addObject("companyManagedList", mainService.getCompanyManageds());
		mv.addObject("projectList", mainService.getProjects());
		mv.addObject("projectDescriptionList", mainService.getProjectDescriptoins());
		mv.addObject("mapAppKey", ApiKey.MapApiKey);
		
		mv.setViewName("test");
		return mv;
	}
	
	@RequestMapping("/notice.do")
	public String Notice(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return "NewFile";
	}
	
//	@RequestMapping("/regData.do")
//	public Map regUser(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		Map resultMap = new HashMap<>();
//		Map paramMap = new HashMap<>();
//		
//		String loginId = ServletRequestUtils.getStringParameter(req, "loginId", "");
//		String password = ServletRequestUtils.getStringParameter(req, "password", "");
//		int birthYear = ServletRequestUtils.getIntParameter(req, "birthYear", 0);
//		int birthMonth = ServletRequestUtils.getIntParameter(req, "birthMonth", 0);
//		int birthDay = ServletRequestUtils.getIntParameter(req, "birthDay", 0);
//		
//		if(loginId.equals("") || password.equals("") || birthYear == 0 || birthMonth == 0 || birthDay == 0) {
//			resultMap.put("result", "500");		//파라미터 하나라도 없음
//			return resultMap;
//		}
//
//		paramMap.put("loginId", loginId);
//		paramMap.put("password", AESUtil.encryptString(password));			//AES 암호화
//		paramMap.put("birthYear", birthYear);
//		paramMap.put("birthMonth", birthMonth);
//		paramMap.put("birthDay", birthDay);
//		
//		if(!DateValidityUtil.isValid(birthYear, birthMonth, birthDay)){
//			resultMap.put("status", "501");
//			resultMap.put("message", "유효한 날짜를 입력해주세요.");
//		}else if(userDataService.regUserData(paramMap) > 0) {
//			resultMap.put("status", "200");
//		}else {
//			resultMap.put("status", "502");			//sql 등록 실패
//		}
//		
//		return resultMap;
//	}
//	
//	@RequestMapping("/Login.do")
//	public Map userLogin(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		Map resultMap = new HashMap<>();
//		Map paramMap = new HashMap<>();
//		
//		String loginId = ServletRequestUtils.getStringParameter(req, "loginId", "");
//		String password = ServletRequestUtils.getStringParameter(req, "password", "");
//		
//		if(loginId.equals("") || password.equals("")) {
//			resultMap.put("result", "500");		//파라미터 하나라도 없음
//			return resultMap;
//		}
//
//		paramMap.put("loginId", loginId);
//		paramMap.put("password", AESUtil.encryptString(password));			//AES 암호화
//		
//		UserDataModel result = userDataService.userLogin(paramMap);
//		
//		if(result != null) {
//			resultMap.put("result", result.loginId);
//			resultMap.put("status", "200");
//		}else {
//			resultMap.put("status", "404");
//		}
//		
//		return resultMap;
//	}
}

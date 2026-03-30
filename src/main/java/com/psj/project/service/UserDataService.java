package com.psj.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.psj.project.dao.UserDataDAO;
import com.psj.project.model.NetworkTestModel;
import com.psj.project.model.UserDataModel;
import com.psj.project.util.AESUtil;

@Service
public class UserDataService {
    private final UserDataDAO dao;
    public UserDataService(UserDataDAO dao) {
    	this.dao = dao; 
    }

    public List<UserDataModel> getUserData() {
        return dao.getUserData();
    }
    
    public int regUserData(Map param) {
    	return dao.regUserData(param);
    }
    
    public UserDataModel userLogin(Map param) {
    	return dao.userLogin(param);
    }
}

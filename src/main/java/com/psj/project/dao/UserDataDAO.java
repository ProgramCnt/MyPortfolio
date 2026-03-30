package com.psj.project.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.psj.project.model.UserDataModel;

@Repository
public class UserDataDAO extends CommonDAO {

    public UserDataDAO(SqlSessionTemplate template) {
        super(template, "UserData");
    }

    public List<UserDataModel> getUserData() {
        return template.selectList(NS + "getUserData");
    }
    
    public int regUserData(Map param) {
    	return template.insert(NS + "regUserData", param);
    }
    
    public UserDataModel userLogin(Map param) {
    	return template.selectOne(NS + "userLogin", param);
    }
}

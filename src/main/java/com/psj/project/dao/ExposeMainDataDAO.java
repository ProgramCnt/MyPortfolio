package com.psj.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.psj.project.model.ActivitiesModel;
import com.psj.project.model.CompanyManagedModel;
import com.psj.project.model.CompanyModel;
import com.psj.project.model.EducationModel;
import com.psj.project.model.PersonalInfoModel;
import com.psj.project.model.ProjectDescriptionModel;
import com.psj.project.model.ProjectModel;
import com.psj.project.model.QualificationsModel;

@Repository
public class ExposeMainDataDAO extends CommonDAO {

    public ExposeMainDataDAO(SqlSessionTemplate template) {
        super(template, "exposeMainData");
    }
    
    public List<EducationModel> getEducationData() {
    	return template.selectList(NS + "getEducationData");
    }

    public List<ActivitiesModel> getActivities(){
    	return template.selectList(NS + "getActivities");
    }
    
    public List<QualificationsModel> getQualifications(){
    	return template.selectList(NS + "getQualifications");
    }
    
    public PersonalInfoModel getPersonalInfo(){
    	return template.selectOne(NS + "getPersonalInfo");
    }
    
    public List<CompanyModel> getCompanies(){
    	return template.selectList(NS + "getCompanies");
    }
    
    public List<CompanyManagedModel> getCompanyManageds(){
    	return template.selectList(NS + "getCompanyManageds");
    }
    
    public List<ProjectModel> getProjects(){
    	return template.selectList(NS + "getProjects");
    }
    
    public List<ProjectDescriptionModel> getProjectDescriptoins(){
    	return template.selectList(NS + "getProjectDescriptions");
    }
    
    public List<String> getSkills(){
    	return template.selectList(NS + "getSkills");
    }
}

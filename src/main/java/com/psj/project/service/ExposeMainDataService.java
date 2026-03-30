package com.psj.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.psj.project.dao.ExposeMainDataDAO;
import com.psj.project.model.ActivitiesModel;
import com.psj.project.model.CompanyManagedModel;
import com.psj.project.model.CompanyModel;
import com.psj.project.model.EducationModel;
import com.psj.project.model.PersonalInfoModel;
import com.psj.project.model.ProjectDescriptionModel;
import com.psj.project.model.ProjectModel;
import com.psj.project.model.QualificationsModel;

@Service
public class ExposeMainDataService {
    private final ExposeMainDataDAO dao;
    public ExposeMainDataService(ExposeMainDataDAO dao) {
    	this.dao = dao; 
    }

    public List<EducationModel> getEducationData() {
        return dao.getEducationData();
    }
    
    public List<ActivitiesModel> getActivities(){
    	return dao.getActivities();
    }
    
    public List<QualificationsModel> getQualifications(){
    	return dao.getQualifications();
    }
    
    public PersonalInfoModel getPersonalInfo(){
    	return dao.getPersonalInfo();
    }
    
    public List<CompanyModel> getCompanies(){
    	return dao.getCompanies();
    }
    
    public List<CompanyManagedModel> getCompanyManageds(){
    	return dao.getCompanyManageds();
    }
    
    public List<ProjectModel> getProjects(){
    	return dao.getProjects();
    }
    
    public List<ProjectDescriptionModel> getProjectDescriptoins(){
    	return dao.getProjectDescriptoins();
    }
    
    public List<String> getSkills(){
    	return dao.getSkills();
    }
}

package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Tutorial;
import com.masai.exceptions.TutorialNotfoundException;
import com.masai.repositary.TutorialDAO;
@Service
public class TutorialServiceImpl implements TutorialService{

	@Autowired
	private TutorialDAO tutorialDAO;
	
	@Override
	public Tutorial createNewTutorial(Tutorial tutorial) throws TutorialNotfoundException {
		Optional<Tutorial> opt = tutorialDAO.findById(tutorial.getId());
		if(opt.isEmpty()) {
			return tutorialDAO.save(tutorial);
		}else {
			throw  new TutorialNotfoundException("Details entered are incorrect");
		}
		
		
	}

	@Override
	public List<Tutorial> getListTutorial() throws TutorialNotfoundException{
		List<Tutorial> tList = tutorialDAO.findAll();
		if(tList.isEmpty()) {
			throw  new TutorialNotfoundException ("List is empty");
		}else {
			return tList;
		}
		
	}

	@Override
	public Tutorial getTutorialById(Integer id) throws TutorialNotfoundException{
		Optional<Tutorial> opt = tutorialDAO.findById(id);
		if(opt.isEmpty()) {
			throw new TutorialNotfoundException ("tutorial not found by this id: "+id);
			
		}else {
			return opt.get();
		}
		
	}

	@Override
	public Tutorial updateTutorialById(Tutorial tutorial) throws TutorialNotfoundException{
		Optional<Tutorial> opt = tutorialDAO.findById(tutorial.getId());
		if(opt.isEmpty()) {
			throw new TutorialNotfoundException ("tutorial not found by this id: "+tutorial.getId());
			
		}else {
			return tutorialDAO.save(tutorial);
		}
		
	}

	@Override
	public String deleteTutorialById(Integer id)throws TutorialNotfoundException {
		Optional<Tutorial> opt = tutorialDAO.findById(id);
		if(opt.isEmpty()) {
			throw new TutorialNotfoundException ("tutorial not found by this id: "+id);
			
		}else {
			Tutorial t1 = opt.get();
			 tutorialDAO.delete(t1);
			 return "Tutorial deleted Successfully by this id: "+id;
		}
		
	}

	@Override
	public String deleteAll() throws TutorialNotfoundException{
		 tutorialDAO.deleteAll();
		 return "Tutorials deleted Successfully";
	}

	@Override
	public List<Tutorial> findAllPublished(boolean status) throws TutorialNotfoundException{
		List<Tutorial> tList = tutorialDAO.findByPublishedStatus(status);
		if(tList.isEmpty()) {
			throw new TutorialNotfoundException ("List is empty");
		}else {
			return tList;
		}
		
	}

	@Override
	public List<Tutorial> findAllTutorialWithName(String title) throws TutorialNotfoundException{
		List<Tutorial> tList = tutorialDAO.findAll();
		List<Tutorial> ans= new ArrayList<>();
		if(tList.isEmpty()) {
			throw new TutorialNotfoundException ("List is empty");
		}else {
			for(Tutorial t: tList) {
				String name=t.getTitle();
				if(name.contains(title)) {
					ans.add(t);
				}
			}
			return ans;
		}

		
		
	}

}

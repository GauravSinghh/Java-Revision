package com.masai.service;

import java.util.List;

import com.masai.entity.Tutorial;
import com.masai.exceptions.TutorialNotfoundException;

public interface TutorialService {

	public Tutorial createNewTutorial(Tutorial tutorial) throws TutorialNotfoundException;
	
	public List<Tutorial> getListTutorial()throws TutorialNotfoundException;
	
	public Tutorial getTutorialById(Integer id)throws TutorialNotfoundException;
	
	public Tutorial updateTutorialById(Tutorial tutorial)throws TutorialNotfoundException;
	
	public String deleteTutorialById(Integer id)throws TutorialNotfoundException;
	
	public String deleteAll()throws TutorialNotfoundException;
	
	public List<Tutorial> findAllPublished(boolean publishedStatus)throws TutorialNotfoundException;
	
	public List<Tutorial> findAllTutorialWithName(String title)throws TutorialNotfoundException;
}

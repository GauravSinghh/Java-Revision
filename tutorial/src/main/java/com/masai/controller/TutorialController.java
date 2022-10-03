package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Tutorial;
import com.masai.exceptions.TutorialNotfoundException;
import com.masai.service.TutorialServiceImpl;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

	@Autowired
	private TutorialServiceImpl tutorialServiceImpl;
	
	@PostMapping("/")
	public ResponseEntity<Tutorial> createNewTutorialHandler(@RequestBody Tutorial t) throws TutorialNotfoundException{
		return new ResponseEntity<Tutorial>(tutorialServiceImpl.createNewTutorial(t),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Tutorial>> getListTutorialHandler() throws TutorialNotfoundException{
		return new ResponseEntity<List<Tutorial>>(tutorialServiceImpl.getListTutorial(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Tutorial getTutorialsByIdHandler(@PathVariable("id") Integer id) throws TutorialNotfoundException{
		
		return tutorialServiceImpl.getTutorialById(id);
	}
	
	@PutMapping("/{id}")
    public Tutorial updateTutorialsByIdHandler(@PathVariable("id") Integer id,@RequestBody Tutorial tutorial)throws TutorialNotfoundException{
		
		
		return tutorialServiceImpl.updateTutorialById(tutorial);
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteTutorialByIdhandler(@PathVariable("id") Integer id) throws TutorialNotfoundException {
		return tutorialServiceImpl.deleteTutorialById(id);
	}
	
	@DeleteMapping("/")
	public String deleteAllHandler() throws TutorialNotfoundException{
		return tutorialServiceImpl.deleteAll();
	}
	
	@GetMapping("/published")
	public List<Tutorial> findAllPublishedHandler()throws TutorialNotfoundException{
		return tutorialServiceImpl.findAllPublished(true);
	}
	
	@GetMapping("/")
	public List<Tutorial> findAllTutorialWithNameHandler(@RequestParam(name="title") String title) throws TutorialNotfoundException{
		
		return tutorialServiceImpl.findAllTutorialWithName(title);
	}
	
}

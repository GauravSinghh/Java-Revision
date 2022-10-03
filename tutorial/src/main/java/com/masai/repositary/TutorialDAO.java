package com.masai.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Tutorial;

public interface TutorialDAO extends JpaRepository<Tutorial, Integer>{

	public List<Tutorial> findByPublishedStatus(boolean status);
}

package com.web.application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.application.controller.Topic;
import com.web.application.controller.TopicDTO;

@Repository
public interface TopicRepository extends JpaRepository<Topic, String>{
//	public List<Topic> 
//	@Query(value = "delete from topic where id IN (:ids) ",nativeQuery = true)
//			
//		public void deleteAllById(@Param("ids") List<String> ids);
//			
	
	@Query("SELECT new com.web.application.controller.TopicDTO(a.id,a.name,a.description,b.teacher) FROM Topic a, Inst b WHERE a.id=b.id")
	public  List<TopicDTO> findAllInst();

	public List<Topic> findByIdAndNameAndDescriptionAndDurationAndFee(String id, String name, String description,
		String duration, int fee);
 }

 

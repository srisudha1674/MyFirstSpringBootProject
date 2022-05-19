package com.web.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.web.application.repository.TopicRepository;

@Service	
public class TopicService {
	
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//			new Topic("spring","spring Framework","spring Framework description"),
//			new Topic("java","core java","core java description"),
//			new Topic("javascript","JavaScript","JavaScript description")
//			));
//	
	@Autowired
	public TopicRepository topicrepos;
	
	public List<Topic> getAllTopics()
	{
		return topicrepos.findAll();		
	}
	
	public Optional<Topic> getTopic(String id) {
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicrepos.findById(id);
	}
	
//	public List<Topic> getTopic(String id,String name,String description,String duration,int fee) {
//		return topicrepos.findByIdAndNameAndDescriptionAndDurationAndFee(id,name,description,duration,fee);
//	}
	public Page<Topic> getTopic(List<SearchCriteria> sc,Integer page, Integer limit,String sortBy,String order) {
//		return topicrepos.findAll(TopicSpecification.findByCriteria(sc));
		Sort sort = Sort.by(Sort.Direction.valueOf(order),sortBy);
		Pageable pageable = PageRequest.of(page, limit,sort);
	return topicrepos.findAll(TopicSpecification.findByCriteria(sc), pageable);


	}
	

	public String addTopic(List<Topic> topics) {
//		topics.add(topic);
		
		topicrepos.saveAll(topics);
		 return "Success";
	}

	public void updateTopic(String id, Topic topic) {
//		for(int i=0;i<topics.size();i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		topicrepos.save(topic);
	}
//
	public void deleteTopic(List<String> ids) {
//		topics.removeIf(t-> t.getId().equals(id));
		topicrepos.deleteAllById(ids);
	}

	public List<TopicDTO> getAllHavingTeacher() {
		return  topicrepos.findAllInst();
	}


}

package com.web.application.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// git project
// added another comment
@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicservice;
	
	@RequestMapping("/topicHavingTeacher")
	public List<TopicDTO> getAllHavingTeacher()
	{
		return topicservice.getAllHavingTeacher();
	}
	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return topicservice.getAllTopics();
	}
	
	
	
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id)
	{
			return topicservice.getTopic(id);
	}
	
	@RequestMapping("/topic")
	//search criteria JPA
	public List<Topic> getTopics(@RequestParam(name = "id",required = false) String id,
			@RequestParam(name= "name",required = false) String name,
			@RequestParam(name = "description",required = false) String description,
			@RequestParam(name = "duration", required = false) String duration,
			@RequestParam(name = "fee", required = false) Integer fee)
	{
		SearchCriteria sc = new SearchCriteria();
		System.out.println(id);
		if(id != null)
		{
			sc.setId(id);
		}
		if(name != null)
		{
			sc.setName(name);
		}
		if(description != null)
		{
			sc.setDescription(description);
		}
		if(duration != null)
		{
			sc.setDuration(duration);
		}
		if(fee !=null && fee>= 0)
		{
			sc.setFee(fee);
		}
			return topicservice.getTopic(Arrays.asList(sc));
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addTopic")
	public String addTopic(@RequestBody List<Topic> topics)
	{
		 return topicservice.addTopic(topics);
	}
//	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id)
	{
		topicservice.updateTopic(id,topic);
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/deleteTopic")
	public void deleteTopic(@RequestBody List<String> ids) {
		topicservice.deleteTopic(ids);
	}
	
}
	

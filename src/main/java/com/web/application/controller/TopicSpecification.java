package com.web.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

//import org.springframework.cglib.core.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class TopicSpecification {
	public static Specification<Topic> findByCriteria(final List<SearchCriteria> searchCriteria){
		return new Specification<Topic>() {
			@Override
			public Predicate toPredicate(Root<Topic> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> p2 = new ArrayList<>();
				for(int i=0;i<searchCriteria.size();i++) {
					List<Predicate> predicates = new ArrayList<>();
					if(searchCriteria.get(i).getId() != null)	
						predicates.add(cb.equal(root.get("id"), searchCriteria.get(i).getId()));
					if(searchCriteria.get(i).getName() != null)	
						predicates.add(cb.equal(root.get("name"), searchCriteria.get(i).getName()));
					if(searchCriteria.get(i).getDescription() != null)	
						predicates.add(cb.equal(root.get("description"), searchCriteria.get(i).getDescription()));
					if(searchCriteria.get(i).getDuration() != null)	
						predicates.add(cb.equal(root.get("duration"), searchCriteria.get(i).getDuration()));
					if(searchCriteria.get(i).getFee() !=null && searchCriteria.get(i).getFee()>= 0)	
						predicates.add(cb.equal(root.get("fee"), searchCriteria.get(i).getFee()));
					p2.add(cb.and(predicates.toArray(new Predicate[predicates.size()])));
				}
				return cb.or(p2.toArray(new Predicate[p2.size()]));
			}
		};
	}
}

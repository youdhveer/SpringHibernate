package com.example.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.model.Application;

@Repository("applicationDAO")
public class ApplicationDAOImpl implements ApplicationDAO {
	private SessionFactory sessionFactory;

	@Autowired
	public ApplicationDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Application> list() {
		@SuppressWarnings("unchecked")
		List<Application> resultList = (List<Application>) sessionFactory.getCurrentSession()
				.createCriteria(Application.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return resultList;
	}

}

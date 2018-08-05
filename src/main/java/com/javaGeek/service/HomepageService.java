package com.javaGeek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaGeek.Bean.RecentArticle;
import com.javaGeek.DAO.HomepageDAOImpl;

@Service
public class HomepageService {
	HomepageDAOImpl daoImpl;

	@Autowired
	public HomepageService(HomepageDAOImpl daoImpl) {
		this.daoImpl = daoImpl;
	}

	public List<RecentArticle> getRecentArticle(Integer pageNumber) {
		List<RecentArticle> articles = null;
		try {
			articles = daoImpl.fetchRecentArticle(pageNumber);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return articles;
	}

}

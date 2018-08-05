package com.javaGeek.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javaGeek.Bean.RecentArticle;

@Repository
public class HomepageDAOImpl {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public HomepageDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<RecentArticle> fetchRecentArticle(Integer PageNumber) {
		String query = "select articleID as articleID,title as title,description as description from LATESTARTICLE where articleID between (Select max(articleID)-(10*:a) from latestarticle) and (select max(articleID)-(10*:b)  from latestarticle) order by articledate desc";
		Map<String, Object> namedParameter = new HashMap<>();
		namedParameter.put("a", 1);
		namedParameter.put("b", 0);
		return jdbcTemplate.query(query, namedParameter,new BeanPropertyRowMapper(RecentArticle.class));
	}

}

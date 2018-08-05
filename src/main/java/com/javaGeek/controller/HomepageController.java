package com.javaGeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaGeek.Bean.RecentArticle;
import com.javaGeek.service.HomepageService;

@Controller
public class HomepageController {
	HomepageService service;

	@Autowired
	public HomepageController(HomepageService service) {
		this.service = service;
	}

	@RequestMapping(value = "/latestArticle/{pageNo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<RecentArticle>> getLatestArticle(
			@RequestParam(value = "pageNo", required = false) Integer pageNo) {
		System.out.println(pageNo);
		List<RecentArticle> list = service.getRecentArticle(0);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}

package com.uttara.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uttara.spring.beans.RegBean;
import com.uttara.spring.dao.DAO;
@Service
public class SprServiceImpl implements SprService{
	@Autowired
	private DAO dao;
	public String register(RegBean rb) {
		System.out.println("In register() of service");
		return dao.register(rb);
	}

}

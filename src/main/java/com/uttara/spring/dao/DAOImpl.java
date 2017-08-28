package com.uttara.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uttara.spring.beans.RegBean;
import com.uttara.spring.constants.Constants;
@Repository
public class DAOImpl implements DAO {
	@Autowired
	private SessionFactory sf;
	public String register(RegBean rb) {
		System.out.println("In DAOimpl register()");
		Session s = null;
		Transaction tx = null;
		try {
			s = sf.openSession();
			tx = s.beginTransaction();
			s.save(rb);
			tx.commit();
			s.close();
			System.out.println("Registration success");
			return Constants.SUCCESS;
		}
		catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println("coudnt connect to db");
			return "Couldn't connect to DB";
		}
		finally {
		}
	}
	
}

package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.entity.Engine;
import com.util.DBConnection;

public class EngineDaO {
	public static void addEngine(String type, int cc) {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Engine e = new Engine();
		e.setType(type);
		e.setCc(cc);
		em.persist(e);
		et.commit();
	}
	
	public static void deleteEngine(int engine_id) {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Engine e = em.find(Engine.class, engine_id);
		em.remove(e);
		et.commit();
	}
	
	public static void findAllEngine() {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		String jpql = "select e from Engine e";
		Query query = em.createQuery(jpql);
		List<Engine> li = query.getResultList();
		
		li.forEach(al->System.out.println(al.getType()+" "+al.getCc()));
	}
	
}

package com.dao;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.entity.Car;
import com.entity.Engine;
import com.util.DBConnection;

public class CarDaO {
	
	public static void addCar() {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Car c = new Car();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Car Brand");
		c.setBrand(sc.next());
		System.out.println("Enter Car Model");
		c.setModel(sc.next());
		em.persist(c);
		et.commit();
	}
	public static void deleteCar(int car_id) {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Car c = em.find(Car.class, car_id);
		em.remove(c);
		et.commit();
	}
	
	public static void allocateEngineToCar(int car_id,int engine_id) {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Engine e = em.find(Engine.class, engine_id);
		Car c = em.find(Car.class,car_id);
		
		c.setEngine(e);
		em.persist(c);
		et.commit();
	}
	
	public static void deallocateEngineToCar(int car_id) {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		Car c = em.find(Car.class, car_id);
		c.setEngine(null);
		em.persist(c);
		et.commit();
	}
	
	public static void findAllCars() {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();	
		
		et.begin();
		String jpql = "select c from Car c";
		Query query = em.createQuery(jpql);
		List<Car> li = query.getResultList();
		li.forEach(al->System.out.println(al.getBrand()+" "+al.getModel()+" "+al.getEngine()+" "+al.getRegisterDate()));
		et.commit();
	}
	
	public static void findCarById(int car_id) {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Car c = em.find(Car.class, car_id);
		System.out.println(c.getBrand()+" "+c.getModel()+" "+c.getEngine()+" "+c.getRegisterDate());
		et.commit();
	}
	
	public static void findCarbyRegisterDate(LocalDate registerDate) {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		String sql = "SELECT * FROM car WHERE registerdate LIKE :r_date";
		Query query = em.createNativeQuery(sql, Car.class);
		query.setParameter("r_date", registerDate);
		List<Car> li = query.getResultList();
		li.forEach(al->System.out.println(al.getBrand()));
		et.commit();
		
	}
}

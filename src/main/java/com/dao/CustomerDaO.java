package com.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.entity.Car;
import com.entity.Customer;
import com.util.DBConnection;

public class CustomerDaO {
	public static void addCustomer(String name) {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer c = new Customer();
		c.setName(name);
		
		et.begin();
		em.persist(c);
		et.commit();
		System.out.println("Add Success");
	}
	public static void allocateCarToCustomer(int cust_id, int car_id) {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		String sql = "Update Customer set c_id=:car_id where id=:cust_id";
		Query query = em.createNativeQuery(sql);
		query.setParameter("car_id", car_id);
		query.setParameter("cust_id", cust_id);
		query.executeUpdate();
		
		Car c = em.find(Car.class, car_id);
		c.setRegisterDate(LocalDate.now());
		em.persist(c);
		et.commit();
	}
	public static void deallocateCarFromCustomer(int cust_id) {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Customer c = em.find(Customer.class, cust_id);
		c.setC(null);
		em.persist(c);
		et.commit();
	}
	public static void deleteCustomer(int cust_id) {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Customer c = em.find(Customer.class, cust_id);
		em.remove(c);
		et.commit();
		
	}
	public static void findAllCustomers() {
		EntityManager em = DBConnection.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
//		String sql = "select * from customer";
//		Query query = em.createNativeQuery(sql);
		
		String jpql = "Select c from Customer c";
		Query query = em.createQuery(jpql);
		List<Customer> cl = query.getResultList();
		
		cl.forEach(al->System.out.println(al.getName()));
		et.commit();
	}
}

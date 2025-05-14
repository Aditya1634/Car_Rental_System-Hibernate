package com.app;

import java.time.LocalDate;
import java.util.Scanner;

import com.dao.CarDaO;
import com.dao.CustomerDaO;
import com.dao.EngineDaO;

public class CRS_Driver {
	public static void main(String[] args) {
		System.out.println("Welcome to Car Rental System");
		System.out.println("Enter your choice");
		
		System.out.println("Enter 1 to add Customer");
		System.out.println("Enter 2 to Allocate Car to Customer");
		System.out.println("Enter 3 to Dellocate Car from Customer");
		System.out.println("Enter 4 to Delete Customer");
		System.out.println("Enter 5 to Find All Customers");
		
		System.out.println("Enter 6 to Add Car");
		System.out.println("Enter 7 to Delete Car");
		System.out.println("Enter 8 to Allocate Engine to Car");
		System.out.println("Enter 9 to Deallocate Engine from Car");
		System.out.println("Enter 10 to find All Cars");
		System.out.println("Enter 11 to find Car by Id");
		System.out.println("Enter 12 to find Cars by Register Date");
		
		System.out.println("Enter 13 to Add Engine");
		System.out.println("Enter 14 to Delete Engine");
		System.out.println("Enter 15 to Find All Engine");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:{
			System.out.println("Enter your name");
			String name = sc.next();
			CustomerDaO.addCustomer(name);
			break;
		}
			
		case 2:{
			System.out.println("Enter Car Id you want to Allocate to customer");
			int car_id = sc.nextInt();
			System.out.println("Enter Customer Id you want to Allocate Car to");
			int cust_id = sc.nextInt();
			CustomerDaO.allocateCarToCustomer(cust_id, car_id);
			break;
		}
			
		case 3:{
			System.out.println("Enter Customer id from who =m you want to remove the car");
			int cust_id = sc.nextInt();
			CustomerDaO.deallocateCarFromCustomer(cust_id);
			break;
		}
			
		case 4:{
			System.out.println("Enter Id of customer you want to delete");
			int cust_id = sc.nextInt();
			CustomerDaO.deleteCustomer(cust_id);
			break;
		}
			
		case 5:{
			CustomerDaO.findAllCustomers();
			break;
		}
			
		case 6:{
			CarDaO.addCar();
			break;
		}
			
		case 7:{
			System.out.println("Enter car id you want to delete");
			int  car_id = sc.nextInt();
			CarDaO.deleteCar(car_id);
			break;
		}
			
		case 8:{
			System.out.println("Enter car_id to Allocate Engine to Car");
			int car_id = sc.nextInt();
			System.out.println("Enter engine_id");
			int engine_id = sc.nextInt();
			CarDaO.allocateEngineToCar(car_id,engine_id);
			break;
		}
		
		case 9:{
			System.out.println("Enter car_id to DeAllocate Engine");
			int car_id = sc.nextInt();
			CarDaO.deallocateEngineToCar(car_id);
			break;
		}
		
		case 10:{
			CarDaO.findAllCars();
			break;
		}
			
		case 11:{
			System.out.println("Enter id");
			int car_id = sc.nextInt();
			CarDaO.findCarById(car_id);
			break;
		}
			
		case 12:{
//			System.out.println("Enter RegistrationDate");
//			LocalDate date = sc.ne
			CarDaO.findCarbyRegisterDate(LocalDate.now());
			break;
		}
			
		case 13:{
			System.out.println("Enter Engine Type");
			String type = sc.next();
			System.out.println("Enter Engine CC");
			int cc = sc.nextInt();
			EngineDaO.addEngine(type,cc);
			break;
		}
			
		case 14:{
			System.out.println("Enter Engine Id you want to delete");
			int id = sc.nextInt();
			EngineDaO.deleteEngine(id);
			break;
		}
		case 15:{
			EngineDaO.findAllEngine();
			break;
		}
			
		default:
			System.out.println("Invalid Choice");
			break;
			
		}
	}
}

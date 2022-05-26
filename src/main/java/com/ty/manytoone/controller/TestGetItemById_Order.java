package com.ty.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytoone.dto.AmazonOrder;
import com.ty.manytoone.dto.Item;

public class TestGetItemById_Order {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Item item = entityManager.find(Item.class, 4);
		if(item!=null) {
		System.out.println("Item Name: " + item.getName());
		System.out.println("Price: " + item.getPrice());
		System.out.println("Quantity" + item.getQuantity());
		System.out.println("----------------------------------");
		AmazonOrder amazonOrder = item.getAmazonOrder();
		if(amazonOrder!=null) {
		System.out.println("Order ID: " + amazonOrder.getId());
		System.out.println("Name: " + amazonOrder.getName());
		System.out.println("Address: " + amazonOrder.getAddress());
		System.out.println("Status: " + amazonOrder.getStatus());
		System.out.println("---------------------------------");
		}
		else
		{
			System.out.println("Not ordered yet");
		}
		}
		else {
			System.out.println("No such id found");
		}
		
	}
}

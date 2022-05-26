package com.ty.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytoone.dto.AmazonOrder;
import com.ty.manytoone.dto.Item;

public class TestSaveItemOrder {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Item item1 = new Item();
		item1.setName("Working table");
		item1.setPrice(12000);
		item1.setQuantity(1);
		
		Item item2 = new Item();
		item2.setName("Working chair");
		item2.setPrice(18000);
		item2.setQuantity(2);
		
		Item item3 = new Item();
		item3.setName("Dell laptop");
		item3.setPrice(50000);
		item3.setQuantity(1);
		
		
		AmazonOrder amazonOrder = new AmazonOrder();
		amazonOrder.setAddress("BTM layout");
		amazonOrder.setName("Office Items");
		amazonOrder.setStatus("dispatched");
		item1.setAmazonOrder(amazonOrder);
		item2.setAmazonOrder(amazonOrder);
		item3.setAmazonOrder(amazonOrder);
		
		entityTransaction.begin();
		entityManager.persist(item1);
		entityManager.persist(item2);
		entityManager.persist(item3);
		entityManager.persist(amazonOrder);
		entityTransaction.commit();
	}
}

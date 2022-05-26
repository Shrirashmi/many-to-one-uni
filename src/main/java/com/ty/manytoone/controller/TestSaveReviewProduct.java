package com.ty.manytoone.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytoone.dto.Product;
import com.ty.manytoone.dto.Review;

public class TestSaveReviewProduct {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Review review1 = new Review();
		review1.setDescription("Leather, Black");
		review1.setRating(6);
		
		Review review2 = new Review();
		review2.setDescription("Leather, Brown");
		review2.setRating(7);
		
		Review review3 = new Review();
		review3.setDescription("Leather, Brown");
		review3.setRating(7);
		
		Product product = new Product();
		product.setName("shoe");
		product.setBrand("Bata");
		product.setPrice(12000);
		
		review1.setProduct(product);
		review2.setProduct(product);
		review3.setProduct(product);
		
		entityTransaction.begin();
		entityManager.persist(product);
		entityManager.persist(review1);
		entityManager.persist(review2);
		entityManager.persist(review3);
		entityTransaction.commit();
	}
}

package com.ty.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytoone.dto.Branch;
import com.ty.manytoone.dto.Hospital;

public class TestSaveBranchHospital {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Branch branch1 = new Branch();
		branch1.setName("BTM");
		branch1.setPhone(8451656);
		branch1.setState("Karnataka");
		branch1.setCountry("IND");
		
		Branch branch2 = new Branch();
		branch2.setName("Hebbal");
		branch2.setPhone(78945465l);
		branch2.setState("Karnataka");
		branch2.setCountry("IND");
		
		Hospital hospital = new Hospital();
		hospital.setName("Apollo");
		hospital.setWeb("www.apollo.com");
		
		branch1.setHospital(hospital);
		branch2.setHospital(hospital);
		
		entityTransaction.begin();
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(hospital);
		entityTransaction.commit();
	}
}

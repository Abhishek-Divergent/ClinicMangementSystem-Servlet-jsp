package com.divergentsl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.divergentsl.entity.Doctor;
import com.divergentsl.utility.Utitlity;

/*
 * This is Doctor DOA class here We will perform all crud operation
 */
public class DoctorDoaImpl implements ApplicationDoa<Doctor> {

	@Override
	public void create(Doctor obj) {
		EntityManager entityManager = Utitlity.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public List<Doctor> read() {
		EntityManager entityManager = Utitlity.getEntityManager();
		TypedQuery<Doctor> query = entityManager.createQuery("Select e from Doctor e", Doctor.class);
		List<Doctor> list = query.getResultList();
		entityManager.close();
		return list;
	}

	@Override
	public void delete(Long id) {
		EntityManager entityManager = Utitlity.getEntityManager();
		entityManager.getTransaction().begin();
		Doctor doctor = entityManager.find(Doctor.class, id);
		entityManager.remove(doctor);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void update(Doctor obj) {
		EntityManager entityManager = Utitlity.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public Doctor findById(Long id) {
		EntityManager entityManager = Utitlity.getEntityManager();
		Doctor doctor = entityManager.find(Doctor.class, id);
		return doctor;
	}
}

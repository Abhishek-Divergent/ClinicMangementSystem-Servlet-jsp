package com.divergentsl.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utitlity {
	private Utitlity() {
		throw new AssertionError();
		// Enforce noninstantiability with a private constructor
		// Joshua Bloch , Effective Java Item 04
	}

	private static EntityManagerFactory manager = Persistence.createEntityManagerFactory("persistencejpa");

	public static EntityManager getEntityManager() {

		return manager.createEntityManager();

	}
}

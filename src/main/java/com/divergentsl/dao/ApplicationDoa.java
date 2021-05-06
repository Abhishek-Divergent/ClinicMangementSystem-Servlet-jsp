package com.divergentsl.dao;

import java.util.List;

public interface ApplicationDoa<T> {

	public void create(T obj);

	List<T> read();

	void delete(Long id);

	void update(T obj);

	public T findById(Long id);

}

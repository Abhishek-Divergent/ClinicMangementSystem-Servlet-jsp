package com.divergentsl.service;

import java.util.List;

import com.divergentsl.entity.Doctor;

public interface DoctorCrudService {
	void create(Doctor doctor);

	List<Doctor> read();

	void delete(Long id);

	boolean update(int updateid, String name, String username, String password, String speciality, String contact,
			int fees);

	Doctor findById(Long id);
}

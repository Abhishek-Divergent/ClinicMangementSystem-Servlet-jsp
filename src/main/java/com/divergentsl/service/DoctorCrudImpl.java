package com.divergentsl.service;

import java.util.List;

import javax.transaction.Transactional;

import com.divergentsl.dao.ApplicationDoa;
import com.divergentsl.dao.DoctorDoaImpl;
import com.divergentsl.entity.Doctor;

public class DoctorCrudImpl implements DoctorCrudService {

	private ApplicationDoa<Doctor> applicationDoa;

	public DoctorCrudImpl() {
		applicationDoa = new DoctorDoaImpl();
	}

	public void create(Doctor doctor) {
		applicationDoa.create(doctor);
	}

	@Override
	public List<Doctor> read() {
		return applicationDoa.read();
	}

	@Override
	public void delete(Long id) {
		applicationDoa.delete(id);
	}

	@Transactional
	@Override
	public boolean update(int updateid, String name, String username, String password, String speciality,
			String contact, int fees) {
		Doctor doctor = findById((long) updateid);

		if (doctor != null) {
			doctor.setId(updateid);
			doctor.setFees(fees);
			doctor.setName(name);
			doctor.setUsername(username);
			doctor.setPassword(password);
			doctor.setSpeciality(speciality);
			doctor.setContact(contact);
			applicationDoa.update(doctor);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Doctor findById(Long id) {
		return (Doctor) applicationDoa.findById(id);
	}

}

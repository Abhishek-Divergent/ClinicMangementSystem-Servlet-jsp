package com.divergentsl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import com.divergentsl.entity.Doctor;
import com.divergentsl.service.DoctorCrudImpl;
import com.divergentsl.service.DoctorCrudService;

@WebServlet("/AddDoctor")
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DoctorCrudService doctorCrudService = new DoctorCrudImpl();
	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	@Override
	public void init() throws ServletException {

		super.init();
		logger.debug("init() called !!!!");
	}

	@Override
	public void destroy() {

		super.destroy();
		logger.debug("destroy() called !!!!");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String doctorName = req.getParameter("doctorName");
		String doctorUserName = req.getParameter("doctorUserName");
		String doctorPassword = req.getParameter("doctorPassword");
		String doctorContact = req.getParameter("doctorContact");
		String doctorSpeciality = req.getParameter("doctorSpeciality");
		long doctorFees = Integer.parseInt(req.getParameter("doctorFees"));
		Doctor doctor = new Doctor();
		doctor.setName(doctorName);
		doctor.setUsername(doctorUserName);
		doctor.setContact(doctorContact);
		doctor.setFees(doctorFees);
		doctor.setPassword(doctorPassword);
		doctor.setSpeciality(doctorSpeciality);
		doctorCrudService.create(doctor);
		List<Doctor> doctorList = doctorCrudService.read();
		req.setAttribute("doctorList", doctorList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Doctor.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long doctorId = Long.parseLong(req.getParameter("doctorId"));
		doctorCrudService.delete(doctorId);
		List<Doctor> doctorList = doctorCrudService.read();
		req.setAttribute("doctorList", doctorList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Doctor.jsp");
		dispatcher.forward(req, resp);
	}

}

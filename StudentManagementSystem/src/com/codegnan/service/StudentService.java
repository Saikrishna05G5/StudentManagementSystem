package com.codegnan.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.codegnan.bean.Student;
import com.codegnan.dao.StudentDao;
import com.codegnan.exception.DatabaseInternalException;
import com.codegnan.exception.InvalidStudentIdException;

public class StudentService {
	Logger logger = Logger.getLogger(StudentService.class);
	public Student findStudentByID(int id) throws ClassNotFoundException,SQLException,InvalidStudentIdException,DatabaseInternalException {
		logger.debug("Finding Student By id:"+id);
		StudentDao studentDao = new StudentDao();
		Student student =studentDao.findById(id);
		logger.debug("Student Found With Given Id:"+id);
		return student;
	}
	public List<Student> findAllStudents() throws ClassNotFoundException, SQLException, DatabaseInternalException{
		logger.debug("Finding all Students Existing");
		StudentDao studentDao = new StudentDao();
		List<Student> students=studentDao.findAll();
		logger.debug("Found"+students.size()+" and Returning");
		return students;
	}
	public boolean saveStudent(Student student) throws ClassNotFoundException, SQLException, DatabaseInternalException {
		logger.debug("Saving a Student "+student);
		StudentDao studentDao = new StudentDao();
		boolean result = studentDao.save(student);
		if(result) {
			studentDao.commit();
			logger.debug("Saved Student Successfully With ID : "+student.getId());
			return true;
		}
		else {
			studentDao.rollback();
			logger.debug("Failed to add student id : "+student.getId());
			return false;
		}
		
	}
	public boolean editStudent(Student student) throws ClassNotFoundException, SQLException, DatabaseInternalException {
		logger.debug("Editing a Student "+student);
		StudentDao studentDao = new StudentDao();
		boolean result = studentDao.edit(student);
		if(result) {
			studentDao.commit();
			logger.debug("Saved Student Successfully With ID : "+student.getId());
			return true;
		}
		else {
			studentDao.rollback();
			logger.debug("Failed to add student id : "+student.getId());
			return false;
		}
		
	}
	public boolean deleteStudentById(int id) throws ClassNotFoundException, SQLException, DatabaseInternalException {
		logger.debug("Deleting Student With ID :"+id);
		StudentDao studentDao = new StudentDao();
		boolean res =studentDao.delete(id);
		logger.debug("Failed to add with student id :"+id);
		return res;
		
	}
	
}

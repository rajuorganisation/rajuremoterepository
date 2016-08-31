package com.raju.springdao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class EmployeeController {
	public Logger l;
	public EmployeeMODEL empmodel;

	public EmployeeController(EmployeeMODEL empmodel) {
		l = Logger.getLogger(EmployeeDAO.class);
		l.info("------EmployeeController obj is created------");
		this.empmodel = empmodel;
	}
	
	public int insertRecords(EmployeeDTO empdto){
		l.info("------insertRecords(edto) called  in EmployeeController------");

		return empmodel.insertRecords(empdto);
	}
	
	public ArrayList<EmployeeVO> retrieveRecords(String sql){
		ArrayList<EmployeeVO> list = empmodel.retrieveRecords(sql);
		return list;
		
	}
	

}

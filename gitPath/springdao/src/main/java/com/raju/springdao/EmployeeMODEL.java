package com.raju.springdao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class EmployeeMODEL {
	public Logger l;
	
	public EmployeeDAO empdao;
	public EmployeeMODEL(EmployeeDAO empdao) {
		l = Logger.getLogger(EmployeeDAO.class);
		l.info("------EmployeeModel obj is created------");
		this.empdao=empdao;
	}
	public int insertRecords(EmployeeDTO empdto){
		l.info("------insertRecords(edto) called  in EmployeeModel------");

		return empdao.insertRecords(empdto);
	}
	
	public ArrayList<EmployeeVO> retrieveRecords(String sql){
		ArrayList<EmployeeVO> list = empdao.retrieveRecords(sql);
		return list;
		
	}

}

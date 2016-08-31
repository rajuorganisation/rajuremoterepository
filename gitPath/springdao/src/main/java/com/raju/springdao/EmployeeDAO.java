package com.raju.springdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDAO {
	public int coutn=0;
	public JdbcTemplate jt;
	public Logger l;

	public EmployeeDAO(JdbcTemplate jt) {
		l = Logger.getLogger(EmployeeDAO.class);
		l.info("------EmployeeDAO obj is created------");
		this.jt = jt;
	}

	public int insertRecords(EmployeeDTO edto) {
		l.info("------insertRecords(edto) called EmployeeDAO------");
		int no = jt.update("insert into employee values(?,?,?)",
				edto.getNo(), edto.getName(), edto.getSalary());
		return no;
	}

	public ArrayList<EmployeeVO> retrieveRecords(String sql) {
		l.info("------retrieveRecords(sql) called EmployeeDAO------");
		ArrayList list = jt.queryForObject(sql, new RowMapper() {

			public EmployeeVO mapRow(ResultSet rs, int rowNum)
					throws SQLException {
		l.info("------mapRow() executing------"+ ++coutn);

				EmployeeVO empvo = new EmployeeVO();
				l.info("------creating EmployeeVO()------");

				empvo.setNo(rs.getInt(1));
				empvo.setName(rs.getString(2));
				empvo.setSalary(rs.getDouble(3));
				l.info("------from ResultSet obj data is added to EmployeeVO()------");

				return empvo;
			}
		});
		return list;

	}

}

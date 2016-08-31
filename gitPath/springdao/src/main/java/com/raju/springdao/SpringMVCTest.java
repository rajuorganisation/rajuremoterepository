package com.raju.springdao;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringMVCTest {

	public static void main(String[] args) throws IOException {
	BasicConfigurator.configure(new FileAppender(new SimpleLayout(), "raju.log", false));
		Logger l = Logger.getLogger(SpringMVCTest.class);
		l.setLevel(Level.DEBUG);
		System.out.println("I am checking git");
		l.info("------container reading the contents from spring.xml file and store it in jvms memory----"); 
		ApplicationContext container = new ClassPathXmlApplicationContext("spring.xml");
		l.info("------creating the obj of EmployeeController by calling getBean()------");
        EmployeeController empcontroller = container.getBean("empcontroller",EmployeeController.class);
		l.info("------creating the obj of EmployeeDAO by calling getBean()------");
        EmployeeDTO empdto = container.getBean("empdto",EmployeeDTO.class);
		l.info("------calling the insertRecords() by passing empdto------");
        empcontroller.insertRecords(empdto);

	}}

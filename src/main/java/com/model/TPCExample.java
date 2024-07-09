package com.model;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class TPCExample {

public static void main(String args[]) {
	Transaction tr=null;
	try(Session ses=HBUtil.getSesFactory().openSession()){
		tr= ses.beginTransaction();
		Employee e1=new Employee("Ramesh");
		RegEmployee e2=new RegEmployee(5500,"sales","suresh");
		Trainee e3=new Trainee(200,"6 months","Umesh");
		ses.persist(e1);  ses.persist(e2);  ses.persist(e3);
		
		tr.commit();
		ses.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

}

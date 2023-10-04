package in.ineuron.Test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.Model.Student;

public class TestApp {

	public static void main(String[] args) throws IOException {
		//1.Inform JVM to activate hibernate
		Configuration configuration=new Configuration();
		configuration.configure();
		
		//Creating a SessionFactory object to hold many other objects  required for hibernate
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		
		//Using SessionFactory object , get one session object  to perform our persistence operation.
		Session session=sessionFactory.openSession();
		//connection object,ORM dailects,L1-Cache(Every operation reflected on L1 Cache)
		
		//Begin the transaction as the operation is   non-select 
		Transaction transaction=session.beginTransaction();
		
		//2.Create Persistence Object
		Student  student=new Student();
		student.setSid(1);
		student.setSaddress("MI");
		student.setSage(49);
		student.setSname("sachin");
		
		//3 perform Persistence operation using Entity/Model/POJO object
		session.save(student);
		System.in.read();
		//save() operation is non-select operation
		//whenever you work with non-select operation transaction object come into picture
		
		//Generate the query and Send Database for execution
		transaction.commit();
		System.out.println("Object saved to database");
		
		session.close();
		sessionFactory.close();
		
		
	}

}

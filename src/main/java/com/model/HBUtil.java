package com.model;




import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HBUtil {
private static SessionFactory sessionFactory ;
public static StandardServiceRegistry registry;
public static SessionFactory buildFactory() {

try {
registry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
MetadataSources sources = new MetadataSources(registry);
Metadata metadata=sources.getMetadataBuilder().build();
sessionFactory=metadata.getSessionFactoryBuilder().build();
return sessionFactory;
}catch(HibernateException e) {
    e.printStackTrace();
    throw new ExceptionInInitializerError();
    }
}
public static SessionFactory getSesFactory() {
	if(sessionFactory==null)
		sessionFactory=buildFactory();
	return sessionFactory;

}
}
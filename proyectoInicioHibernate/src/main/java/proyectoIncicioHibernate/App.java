package proyectoIncicioHibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import proyectoIncicioHibernate.entidades.Profesor;

public class App {

	public static void main(String[] args) throws HibernateException {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session sesion = sessionFactory.openSession();
		
		Transaction tx = sesion.beginTransaction();
		
		Profesor p1 = new Profesor("08", "Sergio", "Aviles");
		
		//sesion.persist(p1);
		
		Profesor p2 = sesion.get(Profesor.class, "08");
		System.out.println(p2);
		
		p2.setCiudad("Salinas");
		
		sesion.merge(p2);
		p2 = sesion.get(Profesor.class, "08");
		System.out.println(p2);
		
		sesion.delete(p2);
		
		tx.commit();
		sesion.close();
		sessionFactory.close();
		
		
	}

}
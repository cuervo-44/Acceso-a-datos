package proyectoIncicioHibernate;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;
	
	public static SessionFactory getSessionFactory() {
		try {
			if (sessionFactory == null) {
				registry = new StandardServiceRegistryBuilder().configure().build();
				MetadataSources source = new MetadataSources(registry);
			
				Metadata metadata = source.getMetadataBuilder().build();
			
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			}
		
		}
		
		catch(Exception e) {
			if(registry!=null)
				StandardServiceRegistryBuilder.destroy(registry);
		}
		
		return sessionFactory;
	}
	
	public static void shutdown() {
		if (registry!=null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
}

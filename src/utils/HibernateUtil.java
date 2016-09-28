package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory mapperSessionFactory = buildSessionFactory();
	private static final SessionFactory stationSessionFactory = buildSessionFactory();
	private static final SessionFactory nurseSessionFactory = buildSessionFactory();

	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getMapperSessionFactory() {
		return mapperSessionFactory;
	}
	public static SessionFactory getStationSessionFactory() {
		return stationSessionFactory;
	}
	public static SessionFactory getNurseSessionFactory() {
		return nurseSessionFactory;
	}
	public static SessionFactory getmapperSessionFactory() {
		return mapperSessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		mapperSessionFactory.close();
		stationSessionFactory.close();
		mapperSessionFactory.close();
	}
}
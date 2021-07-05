package za.co.sfy.dataAccess;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import za.co.sfy.domain.CD;
import za.co.sfy.domain.DVD;
import za.co.sfy.domain.MediaType;

public class MediaCatalogueResource {

	static Session sessionInst;
	static SessionFactory sessionFactoryInst;
	static HibernateUtil hibernateUtilInst;

	public final static Logger logger = Logger.getLogger(MediaCatalogueResource.class);

	public static SessionFactory getSessionFactory() {
		hibernateUtilInst = new HibernateUtil();
		sessionFactoryInst = HibernateUtil.getSessionFactory();
		;
		return sessionFactoryInst;
	}

	public boolean createMediaType(MediaType type) {
		try {
			sessionInst = getSessionFactory().openSession();
			sessionInst.beginTransaction();
			sessionInst.save(type);
			sessionInst.getTransaction().commit();
			logger.info("\nSuccessfully created : " + type.getTitle() + "!\n");
			return true;
		} catch (Exception ex) {
			if (null != sessionInst.getTransaction()) {
				logger.info("\nError: Roll Back\n");
				sessionInst.getTransaction().rollback();
			}
			ex.printStackTrace();
		} finally {
			if (sessionInst != null) {
				sessionInst.close();
			}
		}
		return false;
	}

	public List<MediaType> retrieveAllOfType(MediaType type) {
		try {
			if (type instanceof CD) {
				sessionInst = getSessionFactory().openSession();
				sessionInst.beginTransaction();
				List<MediaType> CDL = (List<MediaType>) sessionInst.createQuery("FROM CD", MediaType.class).list();
				return CDL;
			} else if (type instanceof DVD) {
				sessionInst = getSessionFactory().openSession();
				sessionInst.beginTransaction();
				List<MediaType> DVDL = (List<MediaType>) sessionInst.createQuery("FROM DVD", MediaType.class).list();
				return DVDL;
			}
		} catch (Exception ex) {
			if (null != sessionInst.getTransaction()) {
				logger.info("\nError: Roll Back\n");
				sessionInst.getTransaction().rollback();
				throw new RuntimeException("Find All Failed : ", ex);
			}
			ex.printStackTrace();
		} finally {
			if (sessionInst != null) {
				sessionInst.close();
			}
		}
		return Collections.emptyList();
	}

	public boolean updateMediaType(MediaType type) {
		String title = type.getTitle();
		try {
			if (type instanceof CD) {
				sessionInst = getSessionFactory().openSession();
				sessionInst.beginTransaction();
				CD cd = (CD) type;
				CD cdPersistent = (CD) sessionInst.get(CD.class, cd.getId());
				cdPersistent.setTitle(cd.getTitle());
				cdPersistent.setLength(cd.getLength());
				cdPersistent.setGenre(cd.getGenre());
				cdPersistent.setTracks(cd.getTracks());
				cdPersistent.setArtists(cd.getArtists());
				sessionInst.saveOrUpdate(cdPersistent);
				sessionInst.getTransaction().commit();
				logger.info("\nCD With title = " + cd.getTitle() + " successfully updated!\n");
				return true;
			} else if (type instanceof DVD) {
				sessionInst = getSessionFactory().openSession();
				sessionInst.beginTransaction();
				DVD dvd = (DVD) type;
				DVD dvdPersistent = (DVD) sessionInst.get(DVD.class, dvd.getId());
				dvdPersistent.setTitle(dvd.getTitle());
				dvdPersistent.setLength(dvd.getLength());
				dvdPersistent.setGenre(dvd.getGenre());
				dvdPersistent.setLeadActor(dvd.getLeadActor());
				dvdPersistent.setLeadActress(dvd.getLeadActress());
				sessionInst.saveOrUpdate(dvdPersistent);
				sessionInst.getTransaction().commit();
				logger.info("\nDVD With title = " + dvdPersistent.getTitle() + " successfully updated!\n");
				return true;
			}
		} catch (Exception ex) {
			if (null != sessionInst.getTransaction()) {
				logger.info("\nError: Roll Back\n");
				sessionInst.getTransaction().rollback();
				throw new RuntimeException("Update Of DVD " + title + " Unsuccessful: ", ex);
			}
			ex.printStackTrace();
		} finally {
			if (sessionInst != null) {
				sessionInst.close();
			}
		}
		return false;
	}

	public boolean deleteMediaType(MediaType type) {
		try {
			if (type instanceof CD) {
				sessionInst = getSessionFactory().openSession();
				sessionInst.beginTransaction();
				CD cd = (CD) type;
				CD cdPersistent = (CD) sessionInst.get(CD.class, cd.getId());
				sessionInst.delete(cdPersistent);
				sessionInst.getTransaction().commit();
				logger.info("\nCD With title = " + cdPersistent.getTitle() + " successfully deleted!\n");
				return true;
			} else if (type instanceof DVD) {
				sessionInst = getSessionFactory().openSession();
				sessionInst.beginTransaction();
				DVD dvd = (DVD) type;
				DVD dvdPersistent = (DVD) sessionInst.get(DVD.class, dvd.getId());
				sessionInst.delete(dvdPersistent);
				sessionInst.getTransaction().commit();
				logger.info("\nDVD With title = " + dvdPersistent.getTitle() + " successfully deleted!\n");
				return true;
			}
		} catch (Exception ex) {
			if (null != sessionInst.getTransaction()) {
				logger.info("\nError: Roll Back\n");
				sessionInst.getTransaction().rollback();
				throw new RuntimeException("Unsuccessful: ", ex);
			}
			ex.printStackTrace();
		} finally {
			if (sessionInst != null) {
				sessionInst.close();
			}
		}
		return false;
	}

	public MediaType retrieveMediaType(MediaType type) {
		try {
			if (type instanceof CD) {
				CD CDInst = (CD) type;
				sessionInst = getSessionFactory().openSession();
				sessionInst.beginTransaction();
				sessionInst.get(CD.class, CDInst.getId());
				sessionInst.getTransaction().commit();
				return CDInst;
			} else if (type instanceof DVD) {
				DVD DVDInst = (DVD) type;
				sessionInst = getSessionFactory().openSession();
				sessionInst.beginTransaction();
				sessionInst.get(DVD.class, DVDInst.getId());
				sessionInst.getTransaction().commit();
				return DVDInst;
			}
		} catch (Exception ex) {
			if (null != sessionInst.getTransaction()) {
				logger.info("\nError: Roll Back\n");
				sessionInst.getTransaction().rollback();
				throw new RuntimeException("Unsuccessful: ", ex);
			}
			ex.printStackTrace();
		}
		return type;
	}
}

//	public static void main(String[] args) {
//		DVD dvd = new DVD("Pirates of the Caribbean", 123, "Adventure", "Johnny Depp", "Keira Knightley");
//		DVD dvd1 = new DVD("Invictus", 114, "Action", "Matt Damon", "Emma Watson");
//		DVD dvd2 = new DVD("Day After Tomorrow", 124, "Drama", "Will Smith", "Miley Cyrus");
//		DVD dvd3 = new DVD("Titanic", 123, "Action", "Leonardo Di Caprio", "Kate Winslett");
//		DVD dvd4 = new DVD("Star Wars", 134, "Adventure", "Han Solo", "Carrie Fischer");
//		DVD dvd5 = new DVD("Harry Potter", 141, "Drama", "Daniel Radcliffe", "Emma Watson");
//		DVD dvd6 = new DVD("Madagascar", 124, "Comedy", "Ben Stiller", "Chris Rock");
//		DVD dvd7 = new DVD("Annabelle", 141, "Drama", "Vera Farmiga", "Patrice Wilson");
//		new MediaCatalogueResource().createMediaType(dvd);
//		new MediaCatalogueResource().createMediaType(dvd1);
//		new MediaCatalogueResource().createMediaType(dvd2);
//		new MediaCatalogueResource().createMediaType(dvd3);
//		new MediaCatalogueResource().createMediaType(dvd4);
//		new MediaCatalogueResource().createMediaType(dvd5);
//		new MediaCatalogueResource().createMediaType(dvd6);
//		new MediaCatalogueResource().createMediaType(dvd7);
//
//		List<String> list = new ArrayList<>();
//		list.add("Artist");
//		CD cd1 = new CD("Appetite for Destruction", 63, "Rock", 10, list);
//		CD cd0 = new CD("Abbey Road", 61, "Pop", 11, list);
//		CD cd2 = new CD("Sultans of Swing", 60, "Rock", 12, list);
//		CD cd3 = new CD("Supermarket", 59, "Rap", 9, list);
//		CD cd4 = new CD("American Idiot", 50, "Rock", 12, list);
//		CD cd5 = new CD("Go Your Own Way", 57, "Pop", 12, list);
//		CD cd6 = new CD("Super Trooper", 60, "Rock", 10, list);
//		new MediaCatalogueResource().createMediaType(cd1);
//		new MediaCatalogueResource().createMediaType(cd0);
//		new MediaCatalogueResource().createMediaType(cd2);
//		new MediaCatalogueResource().createMediaType(cd3);
//		new MediaCatalogueResource().createMediaType(cd4);
//		new MediaCatalogueResource().createMediaType(cd5);
//		new MediaCatalogueResource().createMediaType(cd6);
//	}
//}

class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static synchronized SessionFactory getSessionFactory() {
		if (null == sessionFactory) {
			try {
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			} catch (Throwable ex) {
				throw new ExceptionInInitializerError("Failed to create sessionFactory object: " + ex);
			}
		}
		return sessionFactory;
	}
}

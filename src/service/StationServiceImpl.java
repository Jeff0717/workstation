package service;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import utils.HibernateUtil;
import domain.Station;

@Service
public class StationServiceImpl implements StationService {
	Session session = HibernateUtil.getStationSessionFactory().openSession();
	@Override
	public void add(String name) {
		session.beginTransaction();
		Station station = new Station();
		station.setName(name);
		station.setUpdateTime(new Date());
		session.save(station);
		session.flush();
		session.clear();
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Station> list() {
		Query query = session.createQuery("from Station");
		List<Station> list = query.list();
		return list;
	}

	@Override
	public void delete(int id) {
		session.beginTransaction();
		Query query1 = session.createQuery("delete Mapper where stationId = :id");
		query1.setParameter("id", id);
		query1.executeUpdate();
		session.getTransaction().commit();
		session.beginTransaction();
		Query query2 = session.createQuery("delete Station where id = :id");
		query2.setParameter("id", id);
		query2.executeUpdate();
		session.flush();
		session.clear();
		session.getTransaction().commit();
	}
	@Override
	public void update(int id, String name) {
		System.out.println("session:"+session);
		session.beginTransaction();
		Query query = session.createQuery("update Station set name = :name where id = :id");
		query.setParameter("name", name);
		query.setParameter("id", id);
		query.executeUpdate();
		session.flush();
		session.clear();
		session.getTransaction().commit();
	}
	@Override
	public Station get(int id) {
		Query query = session.createQuery("from Station where id = :id");
		query.setParameter("id", id);
		Station station = (Station) query.list().get(0);
		System.out.println("size:" + list().size());
		return station;
	}



}

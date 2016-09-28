package service;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import utils.HibernateUtil;
import domain.Nurse;

@Service
public class NurseServiceImpl implements NurseService {
	Session session = HibernateUtil.getNurseSessionFactory().openSession();
	@Override
	public void add(int id,String name) {
		try{
		session.beginTransaction();
		Nurse nurse = new Nurse();
		nurse.setId(id);
		nurse.setName(name);
		nurse.setUpdateTime(new Date());
		session.save(nurse);
		session.flush();
		session.clear();
		session.getTransaction().commit();
	} catch (Exception e) {
		session.clear();
		session.getTransaction().commit();
		e.printStackTrace();
	}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Nurse> list() {
		Query query = session.createQuery("from Nurse");
		List<Nurse> list = query.list();
		return list;
	}

	@Override
	public void delete(int id) {
		session.beginTransaction();
		Query query1 = session.createQuery("delete Mapper where nurseId = :id");
		query1.setParameter("id", id);
		query1.executeUpdate();
		Query query2 = session.createQuery("delete Nurse where id = :id");
		query2.setParameter("id", id);		
		query2.executeUpdate();
		session.flush();
		session.clear();
		session.getTransaction().commit();
	}

	@Override
	public Nurse get(int id) {
		Query query = session.createQuery("from Nurse where id = :id");
		query.setParameter("id", id);
		Nurse nurse = (Nurse) query.list().get(0);
		return nurse;
	}

	@Override
	public void update(int id,String name) {
		session.beginTransaction();
		Query query = session.createQuery("update Nurse set name = :name where id = :id");
		query.setParameter("name", name);
		query.setParameter("id", id);
		query.executeUpdate();
		session.flush();
		session.clear();
		session.getTransaction().commit();
		
	}

}

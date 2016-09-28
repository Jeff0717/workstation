package service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import utils.HibernateUtil;
import domain.Mapper;
import domain.Nurse;
import domain.Station;

@Service
public class MapperServiceImpl implements MapperService {
	@Resource
	NurseService nurseService;
	@Resource
	StationService stationService;
	Session session = HibernateUtil.getMapperSessionFactory().openSession();
	
	@Override
	public void add(int nurseId, int stationId) {
		session.beginTransaction();
		Mapper mapper = new Mapper();
		mapper.setNurseId(nurseId);
		mapper.setStationId(stationId);
		mapper.setUpdateTime(new Date());
		session.save(mapper);
		session.flush();
		session.clear();
		session.getTransaction().commit();
	}
	
	@Override
	public void delete(int nurseId, int stationId) {
		session.beginTransaction();
		Query query = session.createQuery("delete Mapper where nurseId = :nurseId and stationId = :stationId");
		query.setParameter("nurseId", nurseId);
		query.setParameter("stationId", stationId);
		query.executeUpdate();
		session.flush();
		session.clear();
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Station> listMappedStation(int nurseId) {
		Query query = session.createQuery("from Station where id in(select stationId from Mapper where nurseId = :nurseId)");
		query.setParameter("nurseId", nurseId);
		List<Station> list = query.list();
		System.out.println("mapped list:" + list.size());
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Station> listUnmappedStation(int nurseId) {
		Query query = session.createQuery("from Station where id not in(select stationId from Mapper where nurseId = :nurseId)");
		query.setParameter("nurseId", nurseId);
		List<Station> list = query.list();
		System.out.println("list:" + list.size());
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Nurse> listMappedNurse(int stationId) {
		Query query = session.createQuery("from Nurse where id in(select nurseId from Mapper where stationId = :stationId)");
		query.setParameter("stationId", stationId);
		List<Nurse> list = query.list();
		System.out.println("mapped list:" + list.size());
		return list;
	}

}

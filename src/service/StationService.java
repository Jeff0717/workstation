package service;

import java.util.List;

import domain.Station;

public interface StationService {

	void add(String name);

	List<Station> list();

	void delete(int id);

	Station get(int id);

	void update(int id, String name);

}

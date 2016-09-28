package service;

import java.util.List;

import domain.Nurse;

public interface NurseService {

	void add(int id, String name);

	List<Nurse> list();

	void delete(int id);

	Nurse get(int id);

	void update(int id, String name);

}

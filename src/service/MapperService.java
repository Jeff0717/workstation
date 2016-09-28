package service;

import java.util.List;

import domain.Nurse;
import domain.Station;

public interface MapperService {

	void add(int nurseId, int stationId);

	void delete(int nurseId, int stationId);
	
	List<Station> listMappedStation(int nurseId);
	
	List<Station> listUnmappedStation(int nurseId);
	
	List<Nurse> listMappedNurse(int nurseId);
	
}

package domain;

import java.util.Date;

public class Mapper {
	int id;
	int stationId;
	int nurseId;
//	Station station;
//	Nurse nurse;
	
	Date updateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public int getNurseId() {
		return nurseId;
	}
	public void setNurseId(int nurseId) {
		this.nurseId = nurseId;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
//	public Station getStation() {
//		return station;
//	}
//	public void setStation(Station station) {
//		this.station = station;
//	}
//	public Nurse getNurse() {
//		return nurse;
//	}
//	public void setNurse(Nurse nurse) {
//		this.nurse = nurse;
//	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}

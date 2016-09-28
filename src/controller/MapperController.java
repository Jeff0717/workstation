package controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MapperService;
import service.NurseService;
import domain.Mapper;
import domain.Nurse;
import domain.Station;

@Controller
@RequestMapping(value = "/Mapper")
public class MapperController {
	private final Logger L = LoggerFactory.getLogger(StationController.class);
	@Resource
	NurseService nurseService;
	@Resource
	MapperService mapperService;

	@RequestMapping(value = "add", method = { RequestMethod.POST })
	public @ResponseBody
	String add(@RequestParam("nurseId") int nurseId, @RequestParam("stationId") int stationId) {
		System.out.println("nurseId:" + nurseId + "stationId:" + stationId);
		mapperService.add(nurseId, stationId);
		return "";
	}

	@RequestMapping(value = "delete", method = { RequestMethod.POST })
	public @ResponseBody
	String delete(@RequestParam("nurseId") int nurseId, @RequestParam("stationId") int stationId) {
		System.out.println("nurseId:" + nurseId + "stationId:" + stationId);
		mapperService.delete(nurseId, stationId);
		return "";
	}

}

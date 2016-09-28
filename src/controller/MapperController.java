package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MapperService;
import service.NurseService;

@Controller
@RequestMapping(value = "/Mapper")
public class MapperController {
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

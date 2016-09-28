package controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MapperService;
import service.StationService;
import domain.Nurse;
import domain.Station;

@Controller
@RequestMapping(value = "/Station")
public class StationController {
	private static final String ADD_PAGE = "station_add_page";
	private static final String LIST_PAGE = "station_list_page";
	private static final String VIEW_PAGE = "station_view_page";
	private final Logger L = LoggerFactory.getLogger(StationController.class);
	@Resource
	StationService stationService;
	@Resource
	MapperService mapperService;

	@RequestMapping(value = "addPage", method = { RequestMethod.GET })
	public String addPage() {
		return ADD_PAGE;
	}

	@RequestMapping(value = "listPage", method = { RequestMethod.GET })
	public String listPage(Model model) {
		List<Station> list = stationService.list();
		model.addAttribute("list", list);
		return LIST_PAGE;
	}

	@RequestMapping(value = "add", method = { RequestMethod.POST })
	public @ResponseBody
	String add(@RequestParam("name") String name) {
		L.info("name:" + name);
		System.out.println("name:" + name);
		stationService.add(name);
		return name;
	}

	@RequestMapping(value = "delete", method = { RequestMethod.GET })
	public String delete(Model model, @RequestParam("id") int id) {
		L.info("id:" + id);
		System.out.println("id:" + id);
		stationService.delete(id);
		List<Station> list = stationService.list();
		model.addAttribute("list", list);
		return LIST_PAGE;
	}

	@RequestMapping(value = "view", method = { RequestMethod.GET })
	public String view(Model model, @RequestParam("id") int id) {
		L.info("id:" + id);
		System.out.println("id:" + id);
		Station station = stationService.get(id);
		List<Nurse> list = mapperService.listMappedNurse(id);
		model.addAttribute("station", station);
		model.addAttribute("list", list);
		return VIEW_PAGE;
	}

	@RequestMapping(value = "update", method = { RequestMethod.POST })
	public @ResponseBody
	String update(@RequestParam("id") int id, @RequestParam("name") String name) {
		L.info("name:" + name);
		System.out.println("id:" + id + " name:" + name);
		stationService.update(id, name);
		return name;
	}
}

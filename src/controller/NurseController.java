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
@RequestMapping(value = "/Nurse")
public class NurseController {
	private static final String ADD_PAGE = "nurse_add_page";
	private static final String LIST_PAGE = "nurse_list_page";
	private static final String VIEW_PAGE = "nurse_view_page";
	private final Logger L = LoggerFactory.getLogger(StationController.class);
	@Resource
	NurseService nurseService;
	@Resource
	MapperService mapperService;

	@RequestMapping(value = "addPage", method = { RequestMethod.GET })
	public String addPage() {
		return ADD_PAGE;
	}

	@RequestMapping(value = "listPage", method = { RequestMethod.GET })
	public String listPage(Model model) {
		List<Nurse> list = nurseService.list();
		System.out.println("list:" + list.size());
		model.addAttribute("list", list);
		return LIST_PAGE;
	}

	@RequestMapping(value = "add", method = { RequestMethod.POST })
	public @ResponseBody
	String add(@RequestParam("id") int id, @RequestParam("name") String name) {
		L.info("id:" + id + "name:" + name);
		System.out.println("name:" + name);
		nurseService.add(id, name);
		return name;
	}

	@RequestMapping(value = "delete", method = { RequestMethod.GET })
	public String delete(Model model, @RequestParam("id") int id) {
		L.info("id:" + id);
		System.out.println("id:" + id);
		nurseService.delete(id);
		List<Nurse> list = nurseService.list();
		model.addAttribute("list", list);
		return LIST_PAGE;
	}

	@RequestMapping(value = "view", method = { RequestMethod.GET })
	public String view(Model model, @RequestParam("id") int id) {
		System.out.println("id:" + id);
		Nurse nurse = nurseService.get(id);
		List<Station> mappedlist = mapperService.listMappedStation(id);
		List<Station> unmappedlist = mapperService.listUnmappedStation(id);
		model.addAttribute("nurse", nurse);
		model.addAttribute("mappedlist", mappedlist);
		model.addAttribute("unmappedlist", unmappedlist);
		return VIEW_PAGE;
	}

	@RequestMapping(value = "update", method = { RequestMethod.POST })
	public @ResponseBody
	String update(@RequestParam("id") int id, @RequestParam("newId") int newId, @RequestParam("name") String name) {
		L.info("name:" + name);
		System.out.println("id:" + id+" newId:" + newId + " name:" + name);
		nurseService.update(id, name);
		return name;
	}
}

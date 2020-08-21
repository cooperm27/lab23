package co.grandcircus.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.demo.dao.GradesDao;
import co.grandcircus.jdbcintro.entity.Grade;

@Controller
public class GradesController {

	// Autowired tells spring to fill in the dao variable automatically
	// when the application starts.
	@Autowired
	private GradesDao dao;

	@RequestMapping("/")
	public String index() {
		return "redirect:/grades";
	}

	@RequestMapping("/grades")
	public String list(Model model) {
		List<Grade> grades = dao.findAll();
		model.addAttribute("grades", grades);
		return "list";
	}

	@RequestMapping("/grades/detail")
	public String detail(@RequestParam("id") Long id, Model model) {
		Grade grade = dao.findById(id);
		model.addAttribute("grade", grade);
		return "detail";
	}

	@RequestMapping("/grades/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		Grade grade = dao.findById(id);
		model.addAttribute("grade", grade);
		return "edit";
	}

	@PostMapping("/grades/edit")
	public String save(@RequestParam("id") Long id, Grade grade) {
		dao.update(grade);
		return "redirect:/grades/detail?id=" + id;
	}

	@RequestMapping("/grades/add")
	public String showAdd() {		
		return "add";
	}
	
	@PostMapping("/grades/add")
	public String submitAdd(Grade grade) {	
		dao.create(grade);
		return "redirect:/grades";
	}

	@RequestMapping("/grades/delete")
	public String remove(@RequestParam("id") Long id) {
		dao.delete(id);
		return "redirect:/grades";
	}
}

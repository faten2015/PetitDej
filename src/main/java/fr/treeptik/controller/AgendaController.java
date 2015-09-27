package fr.treeptik.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import fr.treeptik.model.Agenda;
import fr.treeptik.exception.ServiceException;

import fr.treeptik.service.AgendaService;

@Controller
@RequestMapping("/admin/agenda")
public class AgendaController {

	@Autowired
	private AgendaService agendaService;
	

	@RequestMapping(value = "/new.html", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("admin/agenda/agenda");
		modelAndView.addObject("agenda", new Agenda());
		modelAndView.addObject("action", "Ajouter");

		return modelAndView;
	}

	@RequestMapping(value = "/edit.html", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute("id") Integer id) {
		try {
			ModelAndView modelAndView = new ModelAndView("admin/agenda/agenda");

			modelAndView.addObject("agenda", agendaService.findById(id));
			modelAndView.addObject("action", "Editer");

			return modelAndView;

		} catch (Exception e) {
			return list();
		}
	}

	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("admin/agenda/list-agenda");

		try {
			modelAndView.addObject("agendas", agendaService.findAll());

		} catch (Exception e) {
			modelAndView.addObject("error", e.getMessage());
		}

		return modelAndView;

	}

	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute @Valid Agenda agenda,BindingResult result) throws ServiceException {
		 if(result.hasErrors()){
		 System.out.println(result.getAllErrors().toString());
		 
		 }
		
		try {
			if (agenda.getId() == null) {
				agendaService.save(agenda);

			} else {
				agendaService.update(agenda);
			}

			ModelAndView modelAndView = new ModelAndView("redirect:list.html");

			return modelAndView;

		} catch (Exception e) {

			ModelAndView modelAndView = edit(agenda.getId());
			modelAndView.addObject("error", e.getMessage());

			return modelAndView;
		}
	}

	@RequestMapping(value = "/delete.html", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute("id") Integer id) throws ServiceException {
		ModelAndView modelAndView = null;

		try {
			agendaService.removeById(id);

			modelAndView = new ModelAndView("redirect:list.html");

			return modelAndView;

		} catch (Exception e) {
			modelAndView = edit(id);

			modelAndView.addObject("error", e.getMessage());

			return modelAndView;
		}
	}
}
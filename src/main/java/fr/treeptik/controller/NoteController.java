package fr.treeptik.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Note;
import fr.treeptik.service.NoteService;

public class NoteController {
	@Autowired
	private NoteService noteService;
	

	@RequestMapping(value = "/new.html", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("admin/note/note");
		modelAndView.addObject("note", new Note());
		modelAndView.addObject("action", "Ajouter");

		return modelAndView;
	}

	@RequestMapping(value = "/edit.html", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute("id") Integer id) {
		try {
			ModelAndView modelAndView = new ModelAndView("admin/note/note");

			modelAndView.addObject("note", noteService.findById(id));
			modelAndView.addObject("action", "Editer");

			return modelAndView;

		} catch (Exception e) {
			return list();
		}
	}

	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("admin/note/list-note");

		try {
			modelAndView.addObject("notes", noteService.findAll());

		} catch (Exception e) {
			modelAndView.addObject("error", e.getMessage());
		}

		return modelAndView;

	}

	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute @Valid Note note,BindingResult result) throws ServiceException {
		 if(result.hasErrors()){
		 System.out.println(result.getAllErrors().toString());
		 
		 }
		
		try {
			if (note.getId() == null) {
				noteService.save(note);

			} else {
				noteService.update(note);
			}

			ModelAndView modelAndView = new ModelAndView("redirect:list.html");

			return modelAndView;

		} catch (Exception e) {

			ModelAndView modelAndView = edit(note.getId());
			modelAndView.addObject("error", e.getMessage());

			return modelAndView;
		}
	}

	@RequestMapping(value = "/delete.html", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute("id") Integer id) throws ServiceException {
		ModelAndView modelAndView = null;

		try {
			noteService.removeById(id);

			modelAndView = new ModelAndView("redirect:list.html");

			return modelAndView;

		} catch (Exception e) {
			modelAndView = edit(id);

			modelAndView.addObject("error", e.getMessage());

			return modelAndView;
		}
	}
}

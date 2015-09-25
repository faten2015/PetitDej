package fr.treeptik.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import fr.treeptik.model.Member;
import fr.treeptik.exception.ServiceException;

import fr.treeptik.service.MemberService;

@Controller
@RequestMapping("/admin/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	

	@RequestMapping(value = "/new.html", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("admin/member/member");
		modelAndView.addObject("member", new Member());
		modelAndView.addObject("action", "Ajouter");

		return modelAndView;
	}

	@RequestMapping(value = "/edit.html", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute("id") Integer id) {
		try {
			ModelAndView modelAndView = new ModelAndView("admin/member/member");

			modelAndView.addObject("member", memberService.findById(id));
			modelAndView.addObject("action", "Editer");

			return modelAndView;

		} catch (Exception e) {
			return list();
		}
	}

	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("admin/member/list-member");

		try {
			modelAndView.addObject("members", memberService.findAll());

		} catch (Exception e) {
			modelAndView.addObject("error", e.getMessage());
		}

		return modelAndView;

	}

	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute @Valid Member member,BindingResult result) throws ServiceException {
		 if(result.hasErrors()){
		 System.out.println(result.getAllErrors().toString());
		 
		 }
		
		try {
			if (member.getId() == null) {
				memberService.save(member);

			} else {
				memberService.update(member);
			}

			ModelAndView modelAndView = new ModelAndView("redirect:list.html");

			return modelAndView;

		} catch (Exception e) {

			ModelAndView modelAndView = edit(member.getId());
			modelAndView.addObject("error", e.getMessage());

			return modelAndView;
		}
	}

	@RequestMapping(value = "/delete.html", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute("id") Integer id) throws ServiceException {
		ModelAndView modelAndView = null;

		try {
			memberService.removeById(id);

			modelAndView = new ModelAndView("redirect:list.html");

			return modelAndView;

		} catch (Exception e) {
			modelAndView = edit(id);

			modelAndView.addObject("error", e.getMessage());

			return modelAndView;
		}
	}
}
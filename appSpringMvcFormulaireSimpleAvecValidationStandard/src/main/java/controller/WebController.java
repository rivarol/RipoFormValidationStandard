package controller;

import java.net.Authenticator.RequestorType;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import appspringmvc.PersonForm;

	@Controller
	public class WebController {
		
		@RequestMapping(value="/showMessage", method=RequestMethod.GET)
		public String showMessage(ModelMap model) {
			model.addAttribute("message", "Bienvenue");
			return "showMessage";
		}
		
		@RequestMapping(value="/inscription", method=RequestMethod.GET)
		public String showForm(@ModelAttribute PersonForm personForm) {
			return "form";
		}

		@RequestMapping(value="/addPerson", method=RequestMethod.POST)
		public String checkPersonInfo(@Valid @ModelAttribute("personForm")  PersonForm personForm, BindingResult bindingResult, ModelMap model) {
			if (bindingResult.hasErrors()) {
	            return "form";
			}
			model.addAttribute("name", personForm.getName());
			model.addAttribute("age", personForm.getAge());
			return "results";
	    
		}

}

package pawcio.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pawcio.spring.commands.PersonForm;
import pawcio.spring.converters.PersonToPersonForm;
import pawcio.spring.domain.Person;
import pawcio.spring.services.PersonService;

import javax.validation.Valid;

@Validated
@Controller
public class PersonController {
    private PersonService personService;
    private PersonToPersonForm personToPersonForm;


    @Autowired
    public void setPersonToPersonForm(PersonToPersonForm personToPersonForm){
        this.personToPersonForm = personToPersonForm;
    }

    @Autowired
    public void setPersonService(PersonService personService){
        this.personService = personService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/person/list";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "person/welcome";
    }

    @RequestMapping({"/person/list"})
    public String listPerson(Model model){
        model.addAttribute("people",personService.listAll());
        return "person/list";
    }

    @RequestMapping("/person/new")
    public String newPerson(Model model){
        model.addAttribute("personForm",new PersonForm());
        return "person/personform";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String saveOrUpdatePerson(@Valid PersonForm personForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "person/personform";
        }
            Person savedPerson = personService.saveOrUpdatePersonForm(personForm);
            return "redirect:/person/list";
    }

    @RequestMapping("/person/show/{id}")
    public String getPerson(@PathVariable String id, Model model){
        model.addAttribute("person", personService.getById(id));
        return "person/show";
    }

    @RequestMapping("person/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Person person = personService.getById(id);
        PersonForm personForm = personToPersonForm.convert(person);

        model.addAttribute("personForm", personForm);
        return "person/personform";
    }

    @RequestMapping("person/delete/{id}")
    public String delete (@PathVariable String id){
        personService.delete(id);
        return "redirect:/person/list";
    }

}

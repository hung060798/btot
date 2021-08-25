package codegym.controller;

import codegym.model.Classroom;
import codegym.model.Student;
import codegym.service.IClassroomService;
import codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class StudentController {
    @Autowired
    IStudentService iStudentService;
    @Autowired
    IClassroomService iClassroomService;
    @ModelAttribute("classroomList")
    public ArrayList<Classroom> findAll(){
        return iClassroomService.findAll();
    }

    @GetMapping("/show")
    public ModelAndView show(@RequestParam(defaultValue = "0") int page){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("page", iStudentService.findAll(PageRequest.of(page, 3, Sort.by("name"))));
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("stu", new Student());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("stu") Student student,
                               BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        iStudentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/show");
        return modelAndView;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("student", iStudentService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Student student) {
        iStudentService.save(student);
        return new ModelAndView("redirect:/show");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        iStudentService.delete(iStudentService.findById(id));
        return new ModelAndView("redirect:/show");
    }

    @RequestMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("page", iStudentService.findByName(findName));
        return modelAndView;
    }

}

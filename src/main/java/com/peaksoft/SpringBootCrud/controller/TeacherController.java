package com.peaksoft.SpringBootCrud.controller;

import com.peaksoft.SpringBootCrud.model.Teacher;
import com.peaksoft.SpringBootCrud.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


public class TeacherController {
 @Autowired
private TeacherService teacherService;

    // display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listTeachers", teacherService.getAllTeachers());
        return "index";
    }

    @GetMapping("/showNewTeacherForm")
    public String showNewTeacherForm(Model model) {
        // create model attribute to bind form data
        Teacher teacher=new Teacher();
        model.addAttribute("teacher", teacher);
        return "new_teacher";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        // save teacher to database
        teacherService.saveTeacher(teacher);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get teacher from the service
        Teacher teacher = teacherService.getTeacherById(id);

        // set teacher as a model attribute to pre-populate the form
        model.addAttribute("teacher", teacher);
        return "update_teacher";
    }

    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable(value = "id") long id) {

        // call delete teacher method
        this.teacherService.deleteTeacherById(id);
        return "redirect:/";
    }
}

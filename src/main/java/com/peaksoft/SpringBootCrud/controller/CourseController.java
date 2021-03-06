package com.peaksoft.SpringBootCrud.controller;

import com.peaksoft.SpringBootCrud.model.Course;
import com.peaksoft.SpringBootCrud.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/index_course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("listCourses", courseService.getAllCourses());
        return "/index_course";
    }

    @GetMapping("/showNewCourseForm")
    public String showNewCourseForm(Model model) {
        // create model attribute to bind form data
        Course course=new Course();
        model.addAttribute("course", course);
        return "/new_course";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course) {
        // save course to database
        courseService.saveCourse(course);
        return "redirect:/index_course";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get course from the service
        Course course = courseService.getCourseById(id);

        // set course as a model attribute to pre-populate the form
        model.addAttribute("course", course);
        return "/update_course";
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable(value = "id") long id) {

        // call delete course method
        this.courseService.deleteCourseById(id);
        return "redirect:/index_course";
    }

}


package com.peaksoft.SpringBootCrud.controller;

import com.peaksoft.SpringBootCrud.model.Group;
import com.peaksoft.SpringBootCrud.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/index_group")
public class GroupController {

    private final GroupService groupService;

    // display list of groups
    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("listGroups", groupService.getAllGroups());
        return "/index_group";
    }

    @GetMapping("/showNewGroupForm")
    public String showNewGroupForm(Model model) {
        // create model attribute to bind form data
        Group group=new Group();
        model.addAttribute("group", group);
        return "/new_group";
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute("group") Group group) {
        // save group to database
        groupService.saveGroup(group);
        return "redirect:/index_group";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get group from the service
        Group group = groupService.getGroupById(id);

        // set group as a model attribute to pre-populate the form
        model.addAttribute("group", group);
        return "/update_group";
    }

    @GetMapping("/deleteGroup/{id}")
    public String deleteGroup(@PathVariable(value = "id") long id) {

        // call delete group method
        this.groupService.deleteGroupById(id);
        return "redirect:/index_group";
    }

}

package com.peaksoft.SpringBootCrud.controller;

import com.peaksoft.SpringBootCrud.model.Company;
import com.peaksoft.SpringBootCrud.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/index_company")
public class CompanyController {

    private final CompanyService companyService;

    // display list of companies
    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("listCompanies", companyService.getAllCompanies());
        return "/index_company";
    }

    @GetMapping("/showNewCompanyForm")
    public String showNewCompanyForm(Model model) {
        // create model attribute to bind form data
        Company company=new Company();
        model.addAttribute("company", company);
        return "/new_company";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company) {

        // save company to database
        companyService.saveCompany(company);
        return "redirect:/index_company";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get company from the service
        Company company = companyService.getCompanyById(id);

        // set company as a model attribute to pre-populate the form
        model.addAttribute("company", company);
        return "/update_company";
    }

    @GetMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable(value = "id") long id) {

        // call delete company method
        this.companyService.deleteCompanyById(id);
        return "redirect:/index_company";
    }
}


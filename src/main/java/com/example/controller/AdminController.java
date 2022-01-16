package com.example.controller;

import com.example.pojo.Admin;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin")
    public String showAdmin(Model model,
                            @ModelAttribute("resultado") String resultado){

        List<Admin> admins = adminService.findAll();
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        model.addAttribute("resultado", resultado);
        model.addAttribute("admins", admins);

        return "admin";
    }

    @RequestMapping(value = "/admin/save", method = RequestMethod.POST)
    public String handleAdmin(@ModelAttribute("admin") Admin adminForm,
                              RedirectAttributes ra){

        if(adminService.saveOrUpdate(adminForm)){
            ra.addFlashAttribute("resultado","cambios guardados con exito");
        }else {
            ra.addFlashAttribute("resultado","error");
        }

        return "redirect:/admin";
    }

    @RequestMapping("/admin/{id}/update")
    public String showUpdate(Model model,
                            @PathVariable("id") int id){

        Admin admin = adminService.findById(id);
        model.addAttribute("admin", admin);

        return "/admin";
    }

    @RequestMapping("/admin/{id}/delete")
    public String showDelete(@PathVariable("id") int id,
                             RedirectAttributes ra){
        if (adminService.deleteById(id)){
            ra.addFlashAttribute("resultado", "cambios guardados con exito");
        }else{
            ra.addFlashAttribute("resultado", "error");
        }
        return "redirect:/admin";
    }
}

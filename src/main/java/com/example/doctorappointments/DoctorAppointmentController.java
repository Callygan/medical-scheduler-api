package com.example.doctorappointments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DoctorAppointmentController {

    private final AppointmentService service;

    public DoctorAppointmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("appointments", service.findAll());
        return "appointments";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Appointment appointment) {
        service.save(appointment);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("appointment", service.findById(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}

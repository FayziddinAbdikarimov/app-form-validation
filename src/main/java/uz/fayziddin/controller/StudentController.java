package uz.fayziddin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uz.fayziddin.entity.Student;
import uz.fayziddin.Repository.StudentRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository repository;

    @GetMapping
    public String openHomePage(Model model) {
        model.addAttribute("students", repository.findAll());
        return "home";
    }

    @GetMapping("/registration")
    public String registerPage(Student student) {
        return "register";
    }

    @PostMapping("/save")
    public String saveStudent(@Valid Student student, BindingResult result,Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        repository.save(student);
        model.addAttribute("students", repository.findAll());
        return "home";
    }
}

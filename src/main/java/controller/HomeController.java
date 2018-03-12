package controller;

import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.ClassesService;
import service.StudentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("classesList")
//如果放入model的属性名和此处的相同
//则该变量自动进入HttpSession作用域
public class HomeController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassesService classesService;

    @RequestMapping("abc")
    public String abc(@RequestParam(
            value = "n",
            required = false,
            defaultValue = "zzzzz") String name) {
        System.out.println(name);
        return name;
    }

    @RequestMapping("def")
    public String def(@PathVariable String name) {
        System.out.println(name);
        return name;
    }

    @RequestMapping(value = "def",
            method = {RequestMethod.POST})
    public String def() {
        return "def";
    }


    @RequestMapping("/")
    public String root() {
        return "redirect:students";
    }

    @RequestMapping(value = "students",
            method = {RequestMethod.GET, RequestMethod.POST})
    public List<Student> home() {
        return studentService.selectAll();
        //studentList
        //return a list 自动被放入model
        //视图名=该方法RequestMapping的取值
    }

    @RequestMapping("toAdd")
    public String toAdd(Model model) {
        model.addAttribute(new Student());
        model.addAttribute(classesService.selectAll());
        //classesList
        return "add";
    }

    @RequestMapping(value = "add")
        public String add(@Valid Student student, Errors errors) {

        if (errors.hasErrors()) {
            return "add";
        } else {
            studentService.insert(student);
            return "redirect:/";
        }


    }
}

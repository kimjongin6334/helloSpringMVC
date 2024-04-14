package kr.ac.hansung.cse.controller.controller;

import kr.ac.hansung.cse.controller.model.Course;
import kr.ac.hansung.cse.controller.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseController {

    // Controller -> Service -> Dao
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String showCourse(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("id_courses", courses);

        return "courses";
    }

    @GetMapping("/createcourse")
    public String createCourse(Model model) {

        model.addAttribute("course", new Course());

        return "createcourse";
    }

    @PostMapping("/docreate")
    public String doCreate(Model model, @Valid Course course, BindingResult result) {

        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "createcourse";
        }

        // Controller -> Service -> Dao
        courseService.insert(course);

        return "coursecreated";
    }
}
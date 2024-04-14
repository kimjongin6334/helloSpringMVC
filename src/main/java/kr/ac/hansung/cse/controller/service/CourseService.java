package kr.ac.hansung.cse.controller.service;

import kr.ac.hansung.cse.controller.dao.CourseDao;
import kr.ac.hansung.cse.controller.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public List<Course> getAllCourses() {
        return courseDao.getCourses();
    }

    public void insert(Course course) {
        courseDao.insert(course);
    }

}

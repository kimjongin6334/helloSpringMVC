package kr.ac.hansung.cse.controller.dao;

import kr.ac.hansung.cse.controller.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CourseDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getRowCount() {
        String sqlStatement= "select count(*) from courses";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    }

    public Course getCourse(String name) {
        String sqlStatement= "select * from courses where name=?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name},
                new RowMapper<Course>() {
                    @Override
                    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Course course = new Course();
                        course.setYearOfAttendance(rs.getInt("year_of_attendance"));
                        course.setSemester(rs.getInt("semester"));
                        course.setCourseCode(rs.getString("course_code"));
                        course.setCourseTitle(rs.getString("course_title"));
                        course.setCourseClassification(rs.getString("course_classification"));
                        course.setProfessorInCharge(rs.getString("professor_in_charge"));
                        course.setCredits(rs.getInt("credits"));
                        return course;
                    }
                });
    }

    public List<Course> getCourses() {
        String sqlStatement= "select * from courses";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                Course course = new Course();
                course.setYearOfAttendance(rs.getInt("year_of_attendance"));
                course.setSemester(rs.getInt("semester"));
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseTitle(rs.getString("course_title"));
                course.setCourseClassification(rs.getString("course_classification"));
                course.setProfessorInCharge(rs.getString("professor_in_charge"));
                course.setCredits(rs.getInt("credits"));
                return course;
            }
        });
    }

    public boolean insert(Course course) {
        int yearOfAttendance = course.getYearOfAttendance();
        int semester = course.getSemester();
        String courseCode = course.getCourseCode();
        String courseTitle = course.getCourseTitle();
        String courseClassification = course.getCourseClassification();
        String professorInCharge = course.getProfessorInCharge();
        int credits = course.getCredits();

        String sqlStatement= "insert into courses (year_of_attendance, semester, course_code, course_title, course_classification, professor_in_charge, credits) values (?,?,?,?,?,?,?)";
        return (jdbcTemplate.update(sqlStatement, new Object[] {yearOfAttendance, semester, courseCode, courseTitle, courseClassification, professorInCharge, credits}) == 1);
    }

    public boolean update(Course course) {
        int yearOfAttendance = course.getYearOfAttendance();
        int semester = course.getSemester();
        String courseCode = course.getCourseCode();
        String courseTitle = course.getCourseTitle();
        String courseClassification = course.getCourseClassification();
        String professorInCharge = course.getProfessorInCharge();
        int credits = course.getCredits();

        String sqlStatement= "update courses set year_of_attendance=?, semester=?, course_code=?, course_title=?, course_classification=?, professor_in_charge=?, credits=? where id=?";
        return (jdbcTemplate.update(sqlStatement, new Object[] {yearOfAttendance, semester, courseCode, courseTitle, courseClassification, professorInCharge, credits}) == 1);
    }

    public boolean delete(int id) {
        String sqlStatement= "delete from courses where id=?";
        return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
    }
}

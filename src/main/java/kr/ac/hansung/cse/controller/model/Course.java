package kr.ac.hansung.cse.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Course {
   private int id;
   @Size(min=1, max=100, message = "Please enter within 100 characters.")
   private int yearOfAttendance;
   @Size(min=1, max=100, message="Text must be between 1 and 100 chars")
   private int semester;
   @Size(min=5, max=100, message="Text must be between 5 and 100" +
           "chars")
   private String courseCode;
   @Size(min=5, max=100, message="Text must be between 5 and 100 chars")
   private String courseTitle;
   @Size(min=5, max=100, message="Text must be between 5 and 100 chars")
   private String courseClassification;
   @Size(min=5, max=100, message="Text must be between 5 and 100 chars")
   private String professorInCharge;
   @Size(min=1, max=100, message="Text must be between 1 and 100 chars")
   private int credits;

}


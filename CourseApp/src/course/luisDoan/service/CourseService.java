package course.luisDoan.service;

import java.util.ArrayList;

import course.luisDoan.data.Course;

public interface CourseService {
	
	ArrayList<Course> showAllCourse();
	void showCourseDetsil(int id);
}
package course.luisDoan.service;

import course.luisDoan.data.Course;
import course.luisDoan.data.User;

public interface UserService {
	
	public void registerNewUser(int id, String password, String name);
	public boolean login(int id, String password);
	public void showRegisteredCourseToUser(Course course, User user);
	public void registerNewCourse(Course course, User user);
}

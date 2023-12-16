package course.luisDoan.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import course.luisDoan.data.Course;
import course.luisDoan.data.database.DBUtils;
import course.luisDoan.data.database.MySQLConnectionUtils;

public class CourseImpl implements CourseService{

	@Override
	public ArrayList<Course> showAllCourse() {
		
		ArrayList<Course> courseList = null;
		//connect DB
		Connection conn = null;
		try {
			conn = MySQLConnectionUtils.getMySQLConnection();
			courseList = DBUtils.getCourseList(conn);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//get course list
		
		return  courseList;
		
	}

	@Override
	public void showCourseDetsil(int id) {
		// TODO Auto-generated method stub
		
	}

}

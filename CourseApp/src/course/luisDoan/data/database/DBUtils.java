package course.luisDoan.data.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import course.luisDoan.data.Course;
import course.luisDoan.data.User;

public class DBUtils {
	/*
	 * true is user  exist
	 * false is user not exist
	 */
	public static boolean checkUserExist(Connection conn, User user) {
		boolean checked = true;
		String sql = "select * from user where username = ? and password = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				checked = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checked;
		
	}
	
	public static void createNewUser(Connection conn, User user) {
		String sql = "insert into user(username, password) value(?,?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static ArrayList<Course> getCourseList(Connection conn) {
		
		String sql = "SELECT * FROM courses";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Course> courseList = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String courseName = rs.getString("name");
				Date courseBeginDate = new Date(rs.getDate("begin").getTime());
				Date courseEndDate = new Date(rs.getDate("end").getTime());
				float courseFee = rs.getFloat("fee");
				Course course = new Course( courseName,courseBeginDate,
						courseEndDate, courseFee);
				
				courseList.add(course);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}
	
}

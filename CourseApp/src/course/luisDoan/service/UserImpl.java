package course.luisDoan.service;

import java.sql.Connection;
import java.sql.SQLException;

import course.luisDoan.data.Course;
import course.luisDoan.data.User;
import course.luisDoan.data.database.DBUtils;
import course.luisDoan.data.database.MySQLConnectionUtils;

public class UserImpl implements RegisterService, LoginService{

	@Override
	public void registerNewUser( String username, String password) {
		boolean checked = false;
		User user = null;
		Connection conn = null;
		try {
			user = new User(password, username);
			conn = MySQLConnectionUtils.getMySQLConnection();
			checked = DBUtils.checkUserExist(conn, user);
			 if(!checked) {
				 System.out.println("This user is taken!!");
				 System.out.println("Try again !!");
			 }else {
				 DBUtils.createNewUser(conn, user);
				 System.out.println("User is successfully created !!");
			 }
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	/*
	 * false is login successfully
	 * true is to create new account
	 */
	@Override
	public void  loginUser(String username, String password) {
		
		//connect DB
		boolean checked = false;
		User user = null;
		Connection conn = null;
		user = new User(username, password);
		
		try {
			conn = MySQLConnectionUtils.getMySQLConnection();
			checked = DBUtils.checkUserExist(conn, user);
			if(checked) {
				System.out.println("Login successfully");
			}else {
				System.out.println("Account does not exist");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//check if user already existed
		
		
		//1. if already existed, login
		
		//2. if not existed, register
		
		
	}

	

}

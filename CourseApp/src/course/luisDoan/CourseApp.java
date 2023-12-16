package course.luisDoan;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import course.luisDoan.data.Course;
import course.luisDoan.data.database.MySQLConnectionUtils;
import course.luisDoan.service.CourseImpl;
import course.luisDoan.service.CourseService;
import course.luisDoan.service.LoginService;
import course.luisDoan.service.RegisterService;
import course.luisDoan.service.UserImpl;

public class CourseApp {

	static Scanner stdIn = new Scanner(System.in);

	public static void main(String[] args) {

		controlLoop();

	}

	static void controlLoop() {
		String cmmd = "";

		while (true) {
			System.out.println("type[help] for commands");

			cmmd = stdIn.nextLine();
			cmmd = cmmd.trim();

			if (cmmd.equals("help")) {
				menu();
				continue;
			}

			if (cmmd.equalsIgnoreCase("2")) {
				registerNewUser();
				continue;
			}

			if (cmmd.equalsIgnoreCase("1")) {
				login();
				continue;

			}

			if (cmmd.equalsIgnoreCase("3")) {
				showCourseList();
				continue;
			}
		}
	}

	private static void showCourseList() {

		CourseService showCourseList = new CourseImpl();
		ArrayList<Course> courseList = showCourseList.showAllCourse();
		for (Course x : courseList) {
			System.out.println(x);
		}

	}

	static void menu() {
		System.out.println("-------------------Menu-------------------");
		System.out.println("                        ");
		System.out.println("1.Login");
		System.out.println("2.Register Account");
		System.out.println("3.Show course list");
		System.out.println("                        ");
		System.out.println("-------------------Menu--------------------");
		System.out.println("                        ");

	}

	static void registerNewUser() {
		System.out.println("------------------Registration------------");
		System.out.println("Input username: ");
		String userName = stdIn.nextLine();
		System.out.println("Input password: ");
		String password = stdIn.nextLine();

		RegisterService registerService = new UserImpl();
		registerService.registerNewUser(userName, password);
	}

	static void login() {
		System.out.println("------------------Login------------");
		System.out.println("Input username: ");
		String userName = stdIn.nextLine();
		System.out.println("Input password: ");
		String password = stdIn.nextLine();

		LoginService login = new UserImpl();
		login.loginUser(userName, password);
	}
}

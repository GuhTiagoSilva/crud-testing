package application;

import java.util.List;
import java.util.Scanner;

import model.dao.CourseDao;
import model.dao.DaoFactory;
import model.entities.Course;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter course name: ");
		String courseName = sc.nextLine();

		System.out.print("Enter class description: ");
		String classDescription = sc.nextLine();

		System.out.print("Enter period: ");
		String period = sc.nextLine();

		System.out.print("Enter year: ");
		int year = sc.nextInt();

		CourseDao courseDao = DaoFactory.createCourseDao();

		Course course = new Course(null, courseName, classDescription, period, year);

		courseDao.insert(course);

		List<Course> courseList = courseDao.listAll();

		System.out.println("DATAS: ");

		for (Course c : courseList) {
			System.out.println(courseList);
		}

		System.out.print("Enter id to be deleted: ");
		int id = sc.nextInt();
		
		for (Course c : courseList) {
			System.out.println(courseList);
		}

		System.out.println("ID " + id + "DELETED");

		courseDao.delete(id);

		sc.close();
	}

}

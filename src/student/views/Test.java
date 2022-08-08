package student.views;

import java.util.*;


import student.model.Student;
import student.service.StudentClass;
import student.service.StudentClassImpl;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentClass sclass = new StudentClassImpl();
		System.out.println("WELLCOME TO BROADWAY INFOSYS INSTITUTE!!!!");
		restart: while (true) {
			menu();
			int option = sc.nextInt();
			switch (option) {
			case 1:
				addStu(sc);
			 continue restart;

			case 2:
				deleteStudent(sc, sclass);
				continue restart;

			case 3:
				getStu(sclass);
				continue restart;

			case 4:
				System.out.println("Thank you for visiting us.");
				break restart;
			}
		}

//		// ==============to get all student===========
//		System.out.println("student collection after deletion is:");
//		List<Student> list = sclass.getAllStudent();
//		System.out.println(list);
	}

	public static void menu() {
		System.out.println("\n\nWhat you wanted to do?");
		System.out.println("1> add student");
		System.out.println("2> delete student");
		System.out.println("3> check the student list");
		System.out.println("4> exit");
		System.out.println("(please enter 1 or 2 or 3 or 4)");
	}

	public static void deleteStudent(Scanner sc, StudentClass sclass) {
		// ===============to delete a student============
		System.out.println("enter a index of student to delete it:");
		int ind = sc.nextInt();
		sclass.deletestudent(ind);
	}

	public static void getStu(StudentClass sclass) {
		// ==============to get all student===========
		System.out.println("all student list after adding all the data:");
		List<Student> slist = sclass.getAllStudent();
		System.out.println(slist);
	}

	public static void addStu(Scanner sc) {
		Student s = new Student();
		StudentClass sclass = new StudentClassImpl();
		char flag = 'y';
		do {
			System.out.println("enter id:");
			s.setId(sc.nextInt());
			System.out.println("enter first name:");
			s.setFname(sc.next());
			System.out.println("enter last name");
			s.setLname(sc.next());
			System.out.println("enter roll number");
			s.setRoll(sc.nextInt());
			System.out.println("enter the faculty");
			s.setFaculty(sc.next());

			sclass.addStudent(s);
			System.out.println("do you want to add more student(y/n):");
			flag = sc.next().charAt(0);

		} while (flag == 'y');
	}

}

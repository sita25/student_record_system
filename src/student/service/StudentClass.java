package student.service;

import java.util.List;

import student.model.Student;

public interface StudentClass {
//	List<Student> slist= new ArrayList<>();
	void addStudent(Student s);
	
	void deletestudent(int ind);
	
	List<Student> getAllStudent();

}

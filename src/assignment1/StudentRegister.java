package assignment1;

import java.util.ArrayList;

public class StudentRegister {
	private ArrayList<Student> studentList;
	
	public StudentRegister() {
		studentList = new ArrayList<Student>();
	}
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	public void addStudent(Student student) {
		studentList.add(student);
	}
		
	public Student findStudent(String number) {
		int s = studentList.size();
		
		for (int i = 0; i < s; i++) {
			Student student = studentList.get(i);
			String pnmr = student.getPnr();
			if (pnmr == number) {
				return student;
			}
		}
		return null;
	}
}

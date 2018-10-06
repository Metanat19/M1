package assignment1;

import javax.swing.JFrame;

public class Controller {
	JFrame frame;
	StudentRegister sr;
	
	public String findStudent(String number) {
		Student s = sr.findStudent(number);
		if (s != null) {
			return s.getName();
		} else {
		
		return null;
		}

	}

	public void addNewStudent(String name, String pnr) {
		
		
	}
}

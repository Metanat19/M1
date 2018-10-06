package assignment1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private StudentRegister sr;
	private Controller con;
	
	JTextField textField_pr = new JTextField();
	JTextField textField_name = new JTextField();
	JLabel lblInfo = new JLabel("  Response :");
	JLabel lblName = new JLabel("Name ");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		this.sr = new StudentRegister();
		this.con = new Controller();
		
		frame.setBounds(100, 100, 517, 626);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnFindStudent = new JButton("Find Student");
		btnFindStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String number = textField_pr.getText();
				String name = con.findStudent(number);
				if (name != null) {
					lblInfo.setText(name);
				}else {
					lblInfo.setText(" Not found! ");
				}
			}
		});
		btnFindStudent.setBounds(301, 119, 115, 23);
		frame.getContentPane().add(btnFindStudent);
		
		JButton btnFindCourse = new JButton("Find Course");
		btnFindCourse.setBounds(301, 340, 115, 23);
		frame.getContentPane().add(btnFindCourse);
		
		JButton btnRemoveStudent = new JButton("Remove Student");
		btnRemoveStudent.setBounds(301, 153, 115, 23);
		frame.getContentPane().add(btnRemoveStudent);
		
		JButton btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.setBounds(301, 374, 115, 23);
		frame.getContentPane().add(btnRemoveCourse);
		
		JButton btnRegisterStudent = new JButton("Register Student");
		btnRegisterStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_name.getText();
				String pnr = textField_pr.getText();
				con.addNewStudent(name,pnr);
				
				
			}
		});
		btnRegisterStudent.setBounds(301, 85, 115, 23);
		frame.getContentPane().add(btnRegisterStudent);
		
		JButton btnRegisterCourse = new JButton("Register Course");
		btnRegisterCourse.setBounds(301, 306, 115, 23);
		frame.getContentPane().add(btnRegisterCourse);
		
		JButton btnResult = new JButton("Result");
		btnResult.setBounds(21, 5, 115, 23);
		frame.getContentPane().add(btnResult);
		
		
		textField_pr.setBounds(301, 5, 115, 26);
		frame.getContentPane().add(textField_pr);
		textField_pr.setColumns(10);
		
		textField_name.setBounds(301, 42, 115, 26);
		frame.getContentPane().add(textField_name);
		textField_name.setColumns(10);
		
		JTextField textField_cID = new JTextField();
		textField_cID.setBounds(301, 269, 115, 26);
		frame.getContentPane().add(textField_cID);
		textField_cID.setColumns(10);
		
		JTextArea textArea_rs = new JTextArea();
		frame.getContentPane().add(textArea_rs);
		textArea_rs.setBounds(21, 39, 111, 189);
		
		JLabel lblPersonalNumber = new JLabel("Course Number");
		lblPersonalNumber.setBounds(205, 269, 94, 26);
		frame.getContentPane().add(lblPersonalNumber);
		
		JLabel lblCoursNumber = new JLabel("  Personal Number");
		lblCoursNumber.setBounds(197, 3, 94, 26);
		frame.getContentPane().add(lblCoursNumber);
		
		lblName.setBounds(205, 42, 94, 26);
		frame.getContentPane().add(lblName);
		
		
		lblInfo.setBounds(32, 270, 94, 26);
		frame.getContentPane().add(lblInfo);
	}
}

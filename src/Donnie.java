import java.awt.EventQueue;

import javax.swing.JFrame;

import assignment1.AssignmentOne;
import assignment2.AssignmentTwo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Donnie {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Donnie window = new Donnie();
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
	public Donnie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Donnie Projekt");
		
		JButton btnUppgift_1 = new JButton("Uppgift 1");
		btnUppgift_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AssignmentOne asgmnOne = new AssignmentOne();
				asgmnOne.run();
			}
		});
		btnUppgift_1.setBounds(156, 50, 89, 23);
		frame.getContentPane().add(btnUppgift_1);
		
		JButton btnUppgift_2 = new JButton("Uppgift 2");
		btnUppgift_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				AssignmentTwo asgmnTwo = new AssignmentTwo();
				asgmnTwo.run();
			}
		});
		btnUppgift_2.setBounds(156, 107, 89, 23);
		frame.getContentPane().add(btnUppgift_2);
		
		JButton btnUppgift_3 = new JButton("Uppgift 3");
		btnUppgift_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnUppgift_3.setBounds(156, 163, 89, 23);
		frame.getContentPane().add(btnUppgift_3);
	}

}

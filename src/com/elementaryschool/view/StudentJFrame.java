package com.elementaryschool.view;




import com.elementaryschool.model.business.exceptions.ServiceLoadException;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.elementaryschool.model.business.managers.DeleteStudentManager;
import com.elementaryschool.model.business.managers.DisplayGradeManager;
import com.elementaryschool.model.business.managers.DisplayStudentManager;
import com.elementaryschool.model.business.managers.DisplayTeacherManager;
import com.elementaryschool.model.business.managers.RegisterStudentManager;
import com.elementaryschool.model.business.managers.UpdateStudentManager;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import com.elementaryschool.model.domain.Student;



import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class StudentJFrame extends JFrame {
	private JFrame frame;
	private JTextField txtsfirstname;
	private JTextField txtslastname;
	private JTextField txtage;
	private JTextField txtemail;
	private JTextField txtmobile;
	private JTextField txtsgrade;
	private JTable table;
	private JTable gradetable;
	private JTable teachertable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentJFrame window = new StudentJFrame();
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
	public StudentJFrame() {
		Initialize();
		StudentRegistrationTableDisplay();
		GradeTableDisplay();
		TeacherTableDisplay();
	}

	// Display Student Table Method that Initializes with Register, Update and
	// Delete Student functionality

	public void StudentRegistrationTableDisplay() {

		try {
			DisplayStudentManager dspMgr = new DisplayStudentManager();
			DefaultTableModel stumodel = dspMgr.displayStudentTable();
			table.setModel(stumodel);
		}

		catch (Exception e) {
			System.out.println("Unable to load Student Registration Table");
		}

	}

	// Display Grade Table

	public void GradeTableDisplay() {

		try {
			DisplayGradeManager dspGrdMgr = new DisplayGradeManager();
			DefaultTableModel grdmodel = dspGrdMgr.displayGradeTable();
			gradetable.setModel(grdmodel);
		}

		catch (Exception e) {
			System.out.println("Unable to load Grade Table");
		}

	}

	// Display Teacher's Table

	public void TeacherTableDisplay() {

		try {
			DisplayTeacherManager dspTchMgr = new DisplayTeacherManager();
			DefaultTableModel tchmodel = dspTchMgr.displayTeacherTable();
			teachertable.setModel(tchmodel);
		}

		catch (Exception e) {
			System.out.println("Unable to load Grade Table");
		}

	}

	public void Initialize() {

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.setBounds(100, 100, 1401, 954);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Elementary School Registration Label

		JLabel lblNewLabel = new JLabel("Elementary School Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(498, 10, 422, 29);
		frame.getContentPane().add(lblNewLabel);

		// Student Registration Form Panel
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(26, 89, 471, 395);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// Student Registration Form Lables

		JLabel lblNewLabel_FirstName = new JLabel("First Name");
		lblNewLabel_FirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_FirstName.setBounds(23, 34, 97, 20);
		panel.add(lblNewLabel_FirstName);

		JLabel lblNewLabel_LastName = new JLabel("Last Name");
		lblNewLabel_LastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_LastName.setBounds(23, 84, 97, 20);
		panel.add(lblNewLabel_LastName);

		JLabel lblNewLabel_Age = new JLabel("Age");
		lblNewLabel_Age.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_Age.setBounds(23, 134, 97, 20);
		panel.add(lblNewLabel_Age);

		JLabel lblNewLabel_Email = new JLabel("Email");
		lblNewLabel_Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_Email.setBounds(23, 184, 97, 20);
		panel.add(lblNewLabel_Email);

		JLabel lblNewLabel_Mobile = new JLabel("Mobile");
		lblNewLabel_Mobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_Mobile.setBounds(23, 234, 97, 20);
		panel.add(lblNewLabel_Mobile);

		JLabel lblNewLabel_Grade = new JLabel("Grade");
		lblNewLabel_Grade.setToolTipText("Input Grade from Grade Table");
		lblNewLabel_Grade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_Grade.setBounds(23, 284, 97, 20);
		panel.add(lblNewLabel_Grade);

		// Student Registration Form Text Fields

		txtsfirstname = new JTextField();
		txtsfirstname.setBounds(147, 37, 201, 19);
		panel.add(txtsfirstname);
		txtsfirstname.setColumns(10);

		txtslastname = new JTextField();
		txtslastname.setBounds(147, 87, 201, 19);
		panel.add(txtslastname);
		txtslastname.setColumns(10);

		txtage = new JTextField();
		// To accept only Max of 2 Digits in Age Text Field
		txtage.setDocument(new TextFieldLimit(2));
		// To accept only Digits in Age Field
		txtage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evtage) { 
				
				char d = evtage.getKeyChar();
				if(!Character.isDigit(d)) {
					evtage.consume();
				}
			}
		});
		txtage.setToolTipText("Age Must Be maximum of 2 Digits");
		txtage.setBounds(147, 137, 201, 19);
		panel.add(txtage);
		txtage.setColumns(10);

		txtemail = new JTextField();
		txtemail.setBounds(147, 187, 201, 19);
		panel.add(txtemail);
		txtemail.setColumns(10);

		txtmobile = new JTextField();
		// To accept only Max of 10 Digits in Mobile Text Field
		txtmobile.setDocument(new TextFieldLimit(10));
		// To accept only Digits in Mobile Field
		txtmobile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evtmobile) { 
				
				char e = evtmobile.getKeyChar();
				if(!Character.isDigit(e)) {
					evtmobile.consume();
				}
			}
		});
		txtmobile.setToolTipText("Mobile Number must be 10 Digits");
		txtmobile.setBounds(147, 237, 201, 19);
		panel.add(txtmobile);
		txtmobile.setColumns(10);

		txtsgrade = new JTextField();
		txtsgrade.setToolTipText("Input Grade from Grade Table");
		txtsgrade.setBounds(147, 287, 201, 19);
		panel.add(txtsgrade);
		txtsgrade.setColumns(10);

		// Student Registration Form Buttons

		JButton registerButton = new JButton("REGISTER");
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		registerButton.setBounds(10, 352, 122, 21);
		panel.add(registerButton);

		JButton updateButton = new JButton("UDPATE");
		updateButton.setToolTipText("Select Student Application from Student Registration Table");

		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		updateButton.setBounds(134, 352, 104, 21);
		panel.add(updateButton);

		JButton deleteButton = new JButton("DELETE");
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deleteButton.setBounds(244, 352, 104, 21);
		panel.add(deleteButton);
		
		JButton clearButton = new JButton("CLEAR");
		clearButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clearButton.setBounds(358, 352, 103, 21);
		panel.add(clearButton);

		// Student Application Table

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 537, 1339, 359);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);

		// Grade Table

		JScrollPane scrollPaneGrade = new JScrollPane();
		scrollPaneGrade.setBounds(507, 89, 265, 395);
		frame.getContentPane().add(scrollPaneGrade);
		gradetable = new JTable();
		scrollPaneGrade.setViewportView(gradetable);

		// Teacher Table

		JScrollPane scrollPaneTeacher = new JScrollPane();
		scrollPaneTeacher.setBounds(785, 89, 580, 395);
		frame.getContentPane().add(scrollPaneTeacher);
		teachertable = new JTable();
		scrollPaneTeacher.setViewportView(teachertable);
		
		JLabel registrationFormLabel = new JLabel("Registration Form");
		registrationFormLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		registrationFormLabel.setBounds(188, 59, 144, 20);
		frame.getContentPane().add(registrationFormLabel);
		
		JLabel gradeTableLabel = new JLabel("Grade Table");
		gradeTableLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		gradeTableLabel.setBounds(582, 59, 118, 20);
		frame.getContentPane().add(gradeTableLabel);
		
		JLabel teacherTableLabel = new JLabel("Teacher's Table");
		teacherTableLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		teacherTableLabel.setBounds(975, 59, 137, 20);
		frame.getContentPane().add(teacherTableLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Registration Table");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(608, 505, 207, 22);
		frame.getContentPane().add(lblNewLabel_1);

		// Register Button ActionListener

		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtsfirstname.getText().isEmpty() || txtslastname.getText().isEmpty() || txtage.getText().isEmpty()
						|| txtemail.getText().isEmpty() || txtmobile.getText().isEmpty()
						|| txtsgrade.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Fill All Fields"); // Checking if All Text Fields have
																					// data for registration

				}

				else

				{
					Student sTU1 = new Student(0, txtsfirstname.getText(), txtslastname.getText(), txtage.getText(),
							txtemail.getText(), txtmobile.getText(), txtsgrade.getText());
					RegisterStudentManager rgsMgr = new RegisterStudentManager();

					try {
						rgsMgr.registerNewStudent(sTU1);
					} catch (ServiceLoadException e1) {
						e1.printStackTrace();
					}

					finally {
						// Text Boxes are cleared

						txtsfirstname.setText("");
						txtslastname.setText("");
						txtage.setText("");
						txtemail.setText("");
						txtmobile.setText("");
						txtsgrade.setText("");

						// Focus comes back to Student First Name

						txtsfirstname.requestFocus();
						StudentRegistrationTableDisplay();
					}
				}
			}
		});

		// Update Button ActionListener

		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();

				int selectedIndex = table.getSelectedRow();
				
				if (txtsfirstname.getText().isEmpty() || txtslastname.getText().isEmpty() || txtage.getText().isEmpty()
						|| txtemail.getText().isEmpty() || txtmobile.getText().isEmpty()
						|| txtsgrade.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Fill All Fields"); // Checking if All Text Fields have
																					// data for registration

				}
				
				// Checking if user selected student registration from Student Registration Table for Update
				else if (selectedIndex < 0) {
					JOptionPane.showMessageDialog(null, "Please Select Student Registration from Student Registration Table");
				}
				
				else {

				int id = Integer.parseInt(model1.getValueAt(selectedIndex, 0).toString());
				
				


				Student sTU2 = new Student(id, txtsfirstname.getText(), txtslastname.getText(), txtage.getText(),
						txtemail.getText(), txtmobile.getText(), txtsgrade.getText());

				UpdateStudentManager updMgr = new UpdateStudentManager();

				try {
					updMgr.updateNewStudent(sTU2);
				} catch (ServiceLoadException e1) {
					e1.printStackTrace();
				}

				finally {
					// Text Boxes are cleared

					txtsfirstname.setText("");
					txtslastname.setText("");
					txtage.setText("");
					txtemail.setText("");
					txtmobile.setText("");
					txtsgrade.setText("");

					// Focus comes back to Student First Name

					txtsfirstname.requestFocus();

					// Updating Student Table after updating Student Registration record

					StudentRegistrationTableDisplay();
				}
				}
			}
		});

		// Delete Button Action Listener

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
				DefaultTableModel model1 = (DefaultTableModel) table.getModel();

				int selectedIndex = table.getSelectedRow();
				
				
				//Checking below if user selected Student Record to Delete it
				
				if (selectedIndex < 0) {
					JOptionPane.showMessageDialog(null, "Please Select Student Registration from Student Registration Table");
				}

				
				else {
				int id = Integer.parseInt(model1.getValueAt(selectedIndex, 0).toString());

				Student sTU2 = new Student(id, txtsfirstname.getText(), txtslastname.getText(), txtage.getText(),
						txtemail.getText(), txtmobile.getText(), txtsgrade.getText());

				DeleteStudentManager delMgr = new DeleteStudentManager();

				
					delMgr.deleteNewStudent(sTU2);
				} 
				
				}
				
				
				catch (ServiceLoadException e1) {
					e1.printStackTrace();
				}
				
				catch (Exception e1) {
					System.out.println("Something Went Wrong");
				}

				finally {
					// Text Boxes are cleared

					txtsfirstname.setText("");
					txtslastname.setText("");
					txtage.setText("");
					txtemail.setText("");
					txtmobile.setText("");
					txtsgrade.setText("");

					// Focus comes back to Student First Name

					txtsfirstname.requestFocus();

					// Updating Student Table after updating Student Registration record

					StudentRegistrationTableDisplay();
				}
				
			}
		});
		
		//Clear Button Text Fields Action Listener
		
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Text Boxes are cleared

				txtsfirstname.setText("");
				txtslastname.setText("");
				txtage.setText("");
				txtemail.setText("");
				txtmobile.setText("");
				txtsgrade.setText("");

				// Focus comes back to Student First Name

				txtsfirstname.requestFocus();
			}
		});

		// Display on Selected Row in Student Registration Table

		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent me) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();

				int selectedIndex = table.getSelectedRow();

				// Getting Data in to Text Fieleds from Table Row
				txtsfirstname.setText((String) model.getValueAt(selectedIndex, 1));
				txtslastname.setText((String) model.getValueAt(selectedIndex, 2));
				txtage.setText((String) model.getValueAt(selectedIndex, 3));
				txtemail.setText((String) model.getValueAt(selectedIndex, 4));
				txtmobile.setText((String) model.getValueAt(selectedIndex, 5));
				txtsgrade.setText((String) model.getValueAt(selectedIndex, 6));

			}
		});

	}
}

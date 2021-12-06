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
import com.elementaryschool.model.business.managers.DisplayRegistrarManager;
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
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

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
	private JLabel schoolNameLabel = new JLabel();

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
		RegistrarSchoolNameDisplay();
	}

	// Display Student Table Method that Initializes with Register, Update and
	// Delete Student functionality

	public void StudentRegistrationTableDisplay() {

		try {
			DisplayStudentManager dspMgr = new DisplayStudentManager();
			DefaultTableModel stumodel = dspMgr.displayStudentTable();
			table.setModel(stumodel);
			table.getColumnModel().getColumn(0).setPreferredWidth(60);
			table.getColumnModel().getColumn(3).setPreferredWidth(40);
			table.getColumnModel().getColumn(4).setPreferredWidth(90);
			table.getColumnModel().getColumn(5).setPreferredWidth(65);
			table.getColumnModel().getColumn(6).setPreferredWidth(85);
		}

		catch (ServiceLoadException e) {
			JOptionPane.showMessageDialog(null, "Unable to load Student Registration Table. Please contact System/Database Administrator");
			e.printStackTrace();
		}

	}

	// Display Grade Table

	public void GradeTableDisplay() {

		try {
			DisplayGradeManager dspGrdMgr = new DisplayGradeManager();
			DefaultTableModel grdmodel = dspGrdMgr.displayGradeTable();
			gradetable.setModel(grdmodel);
			gradetable.getColumnModel().getColumn(0).setPreferredWidth(30);
			gradetable.getColumnModel().getColumn(1).setPreferredWidth(80);
		}

		catch (ServiceLoadException e) {
			JOptionPane.showMessageDialog(null, "Unable to load Grade Table. Please contact System/Database Administrator");
			e.printStackTrace();
		}

	}

	// Display Teacher's Table

	public void TeacherTableDisplay() {

		try {
			DisplayTeacherManager dspTchMgr = new DisplayTeacherManager();
			DefaultTableModel tchmodel = dspTchMgr.displayTeacherTable();
			teachertable.setModel(tchmodel);
			teachertable.getColumnModel().getColumn(0).setPreferredWidth(30);
			teachertable.getColumnModel().getColumn(1).setPreferredWidth(95);
			teachertable.getColumnModel().getColumn(2).setPreferredWidth(90);
			teachertable.getColumnModel().getColumn(3).setPreferredWidth(60);
		}

		catch (ServiceLoadException e) {
			JOptionPane.showMessageDialog(null, "Unable to load Teacher Table. Please contact System/Database Administrator");
			e.printStackTrace();
		}

	}

	// Display School Name in Label

	public void RegistrarSchoolNameDisplay() {
		try {
			DisplayRegistrarManager dspRgsMgr = new DisplayRegistrarManager();
			String rgsSchoolName = dspRgsMgr.displayRegistrarSchoolName();
			schoolNameLabel.setForeground(Color.WHITE);

			schoolNameLabel.setText(rgsSchoolName);
		}

		catch (ServiceLoadException e) {
			JOptionPane.showMessageDialog(null, "Unable to load School Name. Please contact System/Database Administrator");
			e.printStackTrace();
		}

	}

	public void Initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 153, 255));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.setBounds(100, 100, 1626, 983);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Elementary School Registration Label

		schoolNameLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		schoolNameLabel.setBounds(480, 10, 679, 29);
		frame.getContentPane().add(schoolNameLabel);

		// Student Registration Form Panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(26, 89, 546, 395);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// Student Registration Form Lables

		JLabel lblNewLabel_FirstName = new JLabel("FIRST NAME");
		lblNewLabel_FirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_FirstName.setBounds(25, 29, 100, 20);
		panel.add(lblNewLabel_FirstName);

		JLabel lblNewLabel_LastName = new JLabel("LAST NAME");
		lblNewLabel_LastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_LastName.setBounds(25, 79, 100, 20);
		panel.add(lblNewLabel_LastName);

		JLabel lblNewLabel_Age = new JLabel("AGE");
		lblNewLabel_Age.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_Age.setBounds(25, 129, 100, 20);
		panel.add(lblNewLabel_Age);

		JLabel lblNewLabel_Email = new JLabel("EMAIL");
		lblNewLabel_Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_Email.setBounds(25, 179, 100, 20);
		panel.add(lblNewLabel_Email);

		JLabel lblNewLabel_Mobile = new JLabel("MOBILE");
		lblNewLabel_Mobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_Mobile.setBounds(25, 229, 100, 20);
		panel.add(lblNewLabel_Mobile);

		JLabel lblNewLabel_Grade = new JLabel("GRADE");
		lblNewLabel_Grade.setToolTipText("Input Grade from Grade Table");
		lblNewLabel_Grade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_Grade.setBounds(25, 279, 100, 20);
		panel.add(lblNewLabel_Grade);

		// Student Registration Form Text Fields

		txtsfirstname = new JTextField();
		txtsfirstname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtsfirstname.setBounds(155, 20, 250, 36);
		panel.add(txtsfirstname);
		txtsfirstname.setColumns(10);

		txtslastname = new JTextField();
		txtslastname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtslastname.setBounds(155, 70, 250, 36);
		panel.add(txtslastname);
		txtslastname.setColumns(10);

		txtage = new JTextField();
		txtage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// To accept only Max of 2 Digits in Age Text Field
		txtage.setDocument(new TextFieldLimit(2));
		// To accept only Digits in Age Field
		txtage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evtage) {

				char d = evtage.getKeyChar();
				if (!Character.isDigit(d)) {
					evtage.consume();
				}
			}
		});
		txtage.setToolTipText("Age Must Be maximum of 2 Digits");
		txtage.setBounds(155, 120, 250, 36);
		panel.add(txtage);
		txtage.setColumns(10);

		txtemail = new JTextField();
		txtemail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtemail.setBounds(155, 170, 250, 36);
		panel.add(txtemail);
		txtemail.setColumns(10);

		txtmobile = new JTextField();
		txtmobile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// To accept only Max of 10 Digits in Mobile Text Field
		txtmobile.setDocument(new TextFieldLimit(10));
		// To accept only Digits in Mobile Field
		txtmobile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evtmobile) {

				char e = evtmobile.getKeyChar();
				if (!Character.isDigit(e)) {
					evtmobile.consume();
				}
			}
		});
		txtmobile.setToolTipText("Mobile Number must be 10 Digits");
		txtmobile.setBounds(155, 220, 250, 36);
		panel.add(txtmobile);
		txtmobile.setColumns(10);

		txtsgrade = new JTextField();
		txtsgrade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtsgrade.setToolTipText("Input Grade from Grade Table");
		txtsgrade.setBounds(155, 270, 250, 36);
		panel.add(txtsgrade);
		txtsgrade.setColumns(10);

		// Student Registration Form Buttons

		JButton registerButton = new JButton("REGISTER");
		registerButton.setBorderPainted(false);
		registerButton.setForeground(Color.WHITE);
		registerButton.setBackground(new Color(51, 153, 255));
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		registerButton.setBounds(10, 352, 120, 25);
		panel.add(registerButton);

		JButton updateButton = new JButton("UPDATE");
		updateButton.setBackground(new Color(255, 140, 0));
		updateButton.setBorderPainted(false);
		updateButton.setForeground(Color.WHITE);
		updateButton.setToolTipText("Select Student Application from Student Registration Table");

		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		updateButton.setBounds(145, 352, 120, 25);
		panel.add(updateButton);

		JButton deleteButton = new JButton("DELETE");
		deleteButton.setBackground(new Color(255, 69, 0));
		deleteButton.setBorderPainted(false);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deleteButton.setBounds(280, 352, 120, 25);
		panel.add(deleteButton);

		JButton clearButton = new JButton("CLEAR");
		clearButton.setBorderPainted(false);
		clearButton.setBackground(new Color(0, 139, 139));
		clearButton.setForeground(Color.WHITE);
		clearButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clearButton.setBounds(415, 352, 120, 25);
		panel.add(clearButton);

		// Student Application Table

		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(Color.WHITE);//To set Background color of Scrollpane
		scrollPane.getViewport().setOpaque(true);//To set Background color of Scrollpane
		scrollPane.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), null));
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setBounds(26, 537, 1576, 359);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));//Header font
		table.getTableHeader().setBackground(new Color(188, 143, 143));//Header Background color
		table.getTableHeader().setForeground(Color.WHITE);//Header Background color
		table.setBackground(Color.WHITE);
	    table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(table);

		// Grade Table

		JScrollPane scrollPaneGrade = new JScrollPane();
		//scrollPaneGrade.setBackground(Color.WHITE);
		scrollPaneGrade.getViewport().setBackground(Color.WHITE);//To set Background color of Scrollpane
		scrollPaneGrade.getViewport().setOpaque(true);//To set Background color of Scrollpane
		scrollPaneGrade.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		scrollPaneGrade.setBounds(582, 89, 321, 395);
		frame.getContentPane().add(scrollPaneGrade);
		gradetable = new JTable();
		gradetable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));//Header font
		gradetable.getTableHeader().setBackground(new Color(188, 143, 143));//Header Background color
		gradetable.getTableHeader().setForeground(Color.WHITE);//Header Background color
		gradetable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPaneGrade.setViewportView(gradetable);

		// Teacher Table

		JScrollPane scrollPaneTeacher = new JScrollPane();
		//scrollPaneTeacher.setBackground(Color.WHITE);
		scrollPaneTeacher.getViewport().setBackground(Color.WHITE);//To set Background color of Scrollpane
		scrollPaneTeacher.getViewport().setOpaque(true);//To set Background color of Scrollpane
		scrollPaneTeacher.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		scrollPaneTeacher.setBounds(913, 89, 689, 395);
		frame.getContentPane().add(scrollPaneTeacher);
		teachertable = new JTable();
		teachertable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));//Header font
		teachertable.getTableHeader().setBackground(new Color(188, 143, 143));//Header Background color
		teachertable.getTableHeader().setForeground(Color.WHITE);//Header Background color
		teachertable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPaneTeacher.setViewportView(teachertable);

		JLabel registrationFormLabel = new JLabel("Registration Form");
		registrationFormLabel.setForeground(Color.WHITE);
		registrationFormLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		registrationFormLabel.setBounds(221, 59, 177, 20);
		frame.getContentPane().add(registrationFormLabel);

		JLabel gradeTableLabel = new JLabel("Grade Table");
		gradeTableLabel.setForeground(Color.WHITE);
		gradeTableLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		gradeTableLabel.setBounds(688, 59, 118, 20);
		frame.getContentPane().add(gradeTableLabel);

		JLabel teacherTableLabel = new JLabel("Teacher's Table");
		teacherTableLabel.setForeground(Color.WHITE);
		teacherTableLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		teacherTableLabel.setBounds(1164, 59, 137, 20);
		frame.getContentPane().add(teacherTableLabel);

		JLabel studentTableLabel = new JLabel("Student Registration Table");
		studentTableLabel.setForeground(Color.WHITE);
		studentTableLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		studentTableLabel.setBounds(660, 505, 262, 22);
		frame.getContentPane().add(studentTableLabel);

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
						JOptionPane.showMessageDialog(null, "Unable to Register Student. Please contact System/Database Administrator");
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

				// Checking if user selected student registration from Student Registration
				// Table for Update
				else if (selectedIndex < 0) {
					JOptionPane.showMessageDialog(null,
							"Please Select Student Registration from Student Registration Table");
				}

				else {

					int id = Integer.parseInt(model1.getValueAt(selectedIndex, 0).toString());

					Student sTU2 = new Student(id, txtsfirstname.getText(), txtslastname.getText(), txtage.getText(),
							txtemail.getText(), txtmobile.getText(), txtsgrade.getText());

					UpdateStudentManager updMgr = new UpdateStudentManager();

					try {
						updMgr.updateNewStudent(sTU2);
					} catch (ServiceLoadException e1) {
						JOptionPane.showMessageDialog(null, "Unable to Update Student Registration. Please contact System/Database Administrator");
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

					// Checking below if user selected Student Record to Delete it

					if (selectedIndex < 0) {
						JOptionPane.showMessageDialog(null,
								"Please Select Student Registration from Student Registration Table");
					}

					else {
						int id = Integer.parseInt(model1.getValueAt(selectedIndex, 0).toString());

						Student sTU2 = new Student(id, txtsfirstname.getText(), txtslastname.getText(),
								txtage.getText(), txtemail.getText(), txtmobile.getText(), txtsgrade.getText());

						DeleteStudentManager delMgr = new DeleteStudentManager();

						delMgr.deleteNewStudent(sTU2);
					}

				}

				catch (ServiceLoadException e1) {
					JOptionPane.showMessageDialog(null, "Unable to Delete Student Registration. Please contact System/Database Administrator");
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

		// Clear Button Text Fields Action Listener

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

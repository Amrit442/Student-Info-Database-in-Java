import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class NewFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
static public ResultSet rs;
static public String query="";
static PreparedStatement stmt;
static Connection con;
static String name;
private JTable table;
JComboBox comboBox_1;
private JTextField textField_2;
private JTextField textField_6;
private JTextField textField_5;
private JTextField textField_7;
private JTextField textField_8;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewFrame frame = new NewFrame();
					frame.setVisible(true);
frame.setTitle("Student Management");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("MyMenu", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewRegistration = new JButton("New Student");
		
		btnNewRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnNewRegistration.setBounds(122, 23, 148, 23);
		panel.add(btnNewRegistration);
		
		JButton btnNewButton = new JButton("DataBase Record");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{  
					tabbedPane.setSelectedIndex(1);
					Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/amrithdb?useSSL = false","root","sukruthjayam");   
					Statement stmt=con.createStatement();  
					rs=stmt.executeQuery("SELECT * from stt");
				table.setModel(DbUtils.resultSetToTableModel(rs));
					stmt.close();
					con.close();  
					}
				catch(Exception ex){ 
					System.out.println(ex);
					}  
					

			}
		});
		btnNewButton.setBounds(122, 75, 148, 23);
		panel.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Student Record", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 730, 301);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Registration", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblStudentName = new JLabel("Name of the Student");
		lblStudentName.setBounds(20, 24, 115, 14);
		panel_1.add(lblStudentName);
		
		textField = new JTextField();
		textField.setBounds(145, 21, 141, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		String stud= textField.getText().toString();
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(334, 24, 46, 14);
		panel_1.add(lblBranch);
		
		textField_1 = new JTextField();
		textField_1.setBounds(423, 21, 141, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSem = new JLabel("Sem");
		lblSem.setBounds(334, 61, 46, 14);
		panel_1.add(lblSem);
		
		JLabel lblNewLabel = new JLabel("Phone no.");
		lblNewLabel.setBounds(20, 106, 58, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("email id");
		lblNewLabel_1.setBounds(334, 149, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(145, 103, 141, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		textField_1.getText();
		textField_4 = new JTextField();
		textField_4.setBounds(423, 146, 141, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		JButton btnSubmit = new JButton("Add Student");
		btnSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String str1=textField.getText();
				String str2=textField_6.getText();
				String str3=textField_1.getText();
				String str4= (String) comboBox_1.getItemAt(comboBox_1.getSelectedIndex());
				String str5=textField_2.getText();
				String str6=textField_4.getText();
				String str7=textField_3.getText();
				String str8=textField_5.getText();
				String str9=textField_7.getText();
				String str10=textField_8.getText();

				 query ="insert into stT values (?,?,?,?,?,?,?,?,?,?)";
					try {
						 con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/amrithDB?useSSL = false","root","sukruthjayam");   
						stmt=con.prepareStatement(query);
						stmt.setString(1,str1);
						stmt.setString(2,str2);
						stmt.setString(3,str3);
						stmt.setString(4,str4);
						stmt.setString(5,str5);
						stmt.setString(6,str6);
						stmt.setString(7,str7);
						stmt.setString(8,str8);
						stmt.setString(9,str9);
						stmt.setString(10,str10);
						stmt.executeUpdate();
						stmt.close();
						con.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
					
			}
		});
		btnSubmit.setBounds(145, 239, 141, 23);
		panel_1.add(btnSubmit);
		String[] st_1= {"1","2","3","4","5","6","7","8"};
		comboBox_1 = new JComboBox(st_1);
		comboBox_1.setBounds(423, 58, 80, 20);
		panel_1.add(comboBox_1);
		
		JLabel lblCityState = new JLabel("City & State");
		lblCityState.setBounds(334, 106, 86, 14);
		panel_1.add(lblCityState);
		
		textField_2 = new JTextField();
		textField_2.setBounds(423, 103, 141, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setBounds(20, 61, 46, 14);
		panel_1.add(lblUsn);
		
		textField_6 = new JTextField();
		textField_6.setBounds(145, 58, 141, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblCriteria = new JLabel("criteria");
		lblCriteria.setBounds(20, 149, 46, 14);
		panel_1.add(lblCriteria);
		
		textField_5 = new JTextField();
		textField_5.setBounds(145, 146, 86, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblthPercentage = new JLabel("10th percentage");
		lblthPercentage.setBounds(20, 186, 101, 14);
		panel_1.add(lblthPercentage);
		
		textField_7 = new JTextField();
		textField_7.setBounds(145, 183, 141, 20);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblthPercentage_1 = new JLabel("12th percentage");
		lblthPercentage_1.setBounds(334, 186, 80, 14);
		panel_1.add(lblthPercentage_1);
		
		textField_8 = new JTextField();
		textField_8.setBounds(423, 183, 96, 20);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		String[] arrBlo = {"A-block","B-block","C-block"};
	}

	protected int parseInt(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
}

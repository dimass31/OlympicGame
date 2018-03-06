package Olymp;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Form {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
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
	public Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 530, 362);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 471, 83);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u043E\u0442\u043A\u0440\u044B\u0442\u044C \u0431\u0430\u0437\u0443 \u0434\u0430\u043D\u043D\u044B\u0445");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ResultSet rs;
					Statement stmt;
					//SQLiteDB A = new SQLiteDB();
					//SQLiteDB. 
					Connection c = SQLiteDB.viewDB();
					String query = "SELECT * FROM 'athletes'";
					stmt = c.createStatement();
					rs = stmt.executeQuery(query);
					//ResultSet rm = SQLiteDB.viewDB();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					//rm.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 105, 145, 23);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 139, 481, 55);
		panel.show(false);
		frame.getContentPane().add(panel);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Country", "Surname", "Name", "Kind"},
				{null, null, null, null},
			},
			new String[] {
				"Country", "Surname", "Name", "Kind"
			}
		));
		panel.add(table_1);
		
		JButton btnNewButton_1 = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043D\u043E\u0432\u0443\u044E \u0441\u0442\u0440\u043E\u043A\u0443");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Country = (table_1.getModel().getValueAt(1, 0)).toString();
				String Name = (table_1.getModel().getValueAt(1, 2)).toString();
				String Surname = (table_1.getModel().getValueAt(1, 1)).toString();
				String Kind = (table_1.getModel().getValueAt(1, 3)).toString();
				System.out.println(Country);
				try {
					SQLiteDB C = new SQLiteDB();
					C.InsertDB(Country, Surname, Surname, Kind);
				} catch (Exception es) {
					es.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_1);
		
		JButton button = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u0443\u0447\u0430\u0441\u0442\u043D\u0438\u043A\u043E\u0432");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.show(true); 
			}
		});
		button.setBounds(165, 105, 175, 23);
		frame.getContentPane().add(button);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 205, 481, 76);
		panel_1.show(false);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		table_2 = new JTable();
		table_2.setBounds(181, 0, 300, 32);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"type", "date", "Result", "Time"},
				{null, null, null, null},
			},
			new String[] {
				"type", "date", "Result", "Time"
			}
		));
		panel_1.add(table_2);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{"Country", "Surname", "Name"},
				{null, null, null},
			},
			new String[] {
				"Country", "Surname", "Name"
			}
		));
		table_3.setBounds(0, 0, 174, 32);
		panel_1.add(table_3);
		
		JButton button_2 = new JButton("\u041E\u0431\u043D\u043E\u0432\u0438\u0442\u044C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
				String Country = (table_3.getModel().getValueAt(1, 0)).toString();
				String Surname = (table_3.getModel().getValueAt(1, 1)).toString();
				String Name = (table_3.getModel().getValueAt(1, 2)).toString();
				String type = (table_2.getModel().getValueAt(1, 0)).toString();
				int Result = Integer.parseInt((table_2.getModel().getValueAt(1, 2)).toString());
				String date = (table_2.getModel().getValueAt(1, 1)).toString();
				String Time = (table_2.getModel().getValueAt(1, 3)).toString();
				//String Surname="Шипулин";
				//String Name="Антон";
				System.out.println(Country);
				SQLiteDB C = new SQLiteDB();
				C.UpdateDB(Country, Surname, Name, type, Result, date, Time);;
				}
				catch(ClassNotFoundException se)
				{
					se.printStackTrace();
				}
			}
			});
		button_2.setBounds(37, 43, 115, 23);
		panel_1.add(button_2);
		
		JButton button_1 = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u0440\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442\u044B");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.show(true);
			}
		});
		button_1.setBounds(350, 105, 154, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_3 = new JButton("\u041F\u0440\u043E\u0432\u0435\u0440\u043A\u0430 \u043F\u043E\u0434\u043A\u043B\u044E\u0447\u0435\u043D\u0438\u044F");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestConnect.ConnectionDataBase();
			}
		});
		button_3.setBounds(10, 292, 175, 23);
		frame.getContentPane().add(button_3);
		
		
		
	}
}

package Olymp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class TestConnect 
{

	public static Connection conn;
	public static Statement statmt;

	public static Connection ConnectionDataBase() 
	{
		try{
		conn = null;
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:Olymp.sqlite");
		JOptionPane.showMessageDialog(null, "Подключение прошло успешно");
		return conn;
		
		}
		
		catch(Exception e)
		{
		e.printStackTrace();
		return null;
		}
	}
}

package Olymp;
import java.sql.*;

public class SQLiteDB {

	public Connection con=null;
	public ResultSet rs=null;
	public Statement stmt=null;
	
	public static void main(String[] args)
	{
	}
	
	public void CreateTable() throws ClassNotFoundException, SQLException
	{
		String url = "jdbc:sqlite:Olymp.sqlite";
		String query = "CREATE TABLE athletesese"
				+ "(Country TEXT NOT NULL,"
				+ " "
				+ "Surname TEXT NOT NULL, "
				+ "Name TEXT NOT NULL, "
				+ "Kind of sport TEXT NOT NULL, "
				+ "type of competition TEXT, "
				+ "date DATE, "
				+ "Result INTEGER, "
				+ "Time TIME);";
		//Connection con;
		//ResultSet rs;
		//Statement stmt;
		try
		{
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		con.close();
		stmt.close();
		rs.close();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	
	public void InsertDB(String Country, String Surname, String Name, String King) throws ClassNotFoundException, SQLException
	{
		String url = "jdbc:sqlite:Olymp.sqlite";	
		String query = "INSERT INTO 'athletes'"
				+ "	('Country', 'Surname', 'Name', 'Kind of sport', 'type of competition', 'date', 'Result', 'Time') "
				 + "VALUES ('"
				 + Country
				 + "', '"
				 + Surname
				 + "', '"
				 + Name
				 + "','"
				 + King
				 + "', null, null, null, null);";
		Connection con;
		Statement stmt;
		try
		{
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		con.close();
		stmt.close();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	
	public static Connection viewDB() throws ClassNotFoundException, SQLException
	{
		String url = "jdbc:sqlite:Olymp.sqlite";
		//String query = "SELECT * FROM 'athletes'";
		Connection con;
		//ResultSet rs;
		//Statement stmt;
		try
		{
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(url);
			//stmt = con.createStatement();
			//rs = stmt.executeQuery(query);
			//while(rs.next()){
				//System.out.println(rs.getString("Country"));
			//}
		//con.close();
		//stmt.close();
		return con;
		//rs.close();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
			return null;
		}
	}

	public void UpdateDB(String Country, String Surname, String Name, String type, int Result, String date, String Time)throws ClassNotFoundException//, SQLException
	{
		String url = "jdbc:sqlite:Olymp.sqlite";
		String query = "SELECT * FROM 'athletes'";
		Connection con;
		ResultSet rs;
		Statement stmt;
		try
		{
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			String a;
			//while(rs.next())
			//{
				a = "UPDATE 'athletes' SET 'type of competition'='"
						+ type
						+ "', date='"
						+ date
						+ "', Result = "
						+ Result
						+ ", Time='"
						+ Time
						+ "' WHERE Country='"
						+ Country 
						+"' OR Surname='"
						+ Surname
						+ "' OR Name='"
						+ Name
						+ "';";
				System.out.println(a);
				con.createStatement().executeUpdate(a);
			//}
		con.close();
		stmt.close();
		rs.close();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}

}

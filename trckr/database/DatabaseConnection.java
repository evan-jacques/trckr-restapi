package org.evan.jacques.trckr.database;

import java.sql.*;

public class DatabaseConnection 
{

	private String database;
	private String username;
	private String password;
	
	public DatabaseConnection()
	{
		
	}
	
	public DatabaseConnection(String database,String username,String password)
	{
		this.database = database;
		this.username = username;
		this.password = password;
	}
	
	public Connection connect()
	{
		try 
		{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/" + this.database,
					this.username,
					this.password);
			return myConn;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
}

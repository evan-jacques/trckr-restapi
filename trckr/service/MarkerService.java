package org.evan.jacques.trckr.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.evan.jacques.trckr.model.Marker;

public class MarkerService 
{
	
	String username = "";
	String password = "";
	
	public MarkerService()
	{
		
	}
	
	public List<Marker> getAllMarkers(String table)
	{
		List<Marker> list = new ArrayList<Marker>();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.9.96.2:3306/trckr",username,password);
			Statement stmt = conn.createStatement();
			ResultSet myRs = stmt.executeQuery("select * from " + table);
			while(myRs.next()){
				Marker mark = new Marker(	myRs.getString("address"),
											myRs.getInt("id"),
											myRs.getInt("size"),
											myRs.getString("contents"),
											myRs.getString("dropoff"),
											myRs.getInt("pickup"),
											myRs.getFloat("latitude"),
											myRs.getFloat("longitude"));
				list.add(mark);
			}
			conn.close();
			return list;
		} catch (Exception e)
		{
			e.printStackTrace();
			return list;
		}
	}
	
	public List<Marker> getMarkersToPickup( String table )
	{
		List<Marker> list = new ArrayList<Marker>();
		try 
		{	
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.9.96.2:3306/trckr",username,password);
			Statement stmt = conn.createStatement();
			ResultSet myRs = stmt.executeQuery("select * from " + table + " where pickup = 1");
			
			while(myRs.next())
			{
				Marker mark = new Marker(	myRs.getString("address"),
											myRs.getInt("id"),
											myRs.getInt("size"),
											myRs.getString("contents"),
											myRs.getString("dropoff"),
											myRs.getInt("pickup"),
											myRs.getFloat("latitude"),
											myRs.getFloat("longitude"));
				list.add(mark);
			}
			
			conn.close();
			return list;
			
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
			return list;
		}
	}
	
	public Marker addMarker(Marker marker, String table)
	{
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.9.96.2:3306/trckr",username,password);
			String query = "INSERT into " + table + " (address,id,size,contents,dropoff,pickup,latitude,longitude) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,marker.getAddress());
			stmt.setInt(2,marker.getId());
			stmt.setInt(3,marker.getSize());
			stmt.setString(4,marker.getContents());
			stmt.setString(5,marker.getDropoff());
			stmt.setInt(6,marker.getPickup());
			stmt.setDouble(7,marker.getLat());
			stmt.setDouble(8,marker.getLon());
			stmt.execute();
			conn.close();
			return marker;



		} 
		catch (Exception e) 
		{
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			marker.setContents(sw.toString());
			return marker;
		}
		
	
	}
	
	public Marker updateMarker(int id, Marker marker, String table)
	{
		String query = "";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.9.96.2:3306/trckr",username,password);
			query = 	"UPDATE " + table 
							+ " SET address='" + marker.getAddress() 
						 	+ "', size =" + marker.getSize() 
						 	+ ",contents='" + marker.getContents() 
						 	+ "',dropoff='" + marker.getDropoff() 
						 	+ "',pickup=" + marker.getPickup() 
						 	+ ",latitude=" + marker.getLat() 
						 	+ ", longitude=" + marker.getLon() 
						 	+ " WHERE id=" + id;
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.execute();
			conn.close();
			return marker;
		} 
		catch (Exception e) 
		{
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			marker.setContents(sw.toString());
			marker.setAddress(query);
			return marker;
		}
		
	}
	
	public void deleteMarker(int id, String table)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.9.96.2:3306/trckr",username,password);
			String query = "DELETE from " + table + " where id=" + id;
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.execute();
			conn.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
		
	public String connectToken(String token)
	{
		String table ="";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.9.96.2:3306/trckr",username,password);
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM tokens WHERE token = '" + token + "'";
			System.out.println(query);
			ResultSet myRs = stmt.executeQuery(query);
			
			while(myRs.next())
			{
				table = myRs.getString("data");
			}
			
			conn.close();
			return table;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return table;
		}	
		
	}
}

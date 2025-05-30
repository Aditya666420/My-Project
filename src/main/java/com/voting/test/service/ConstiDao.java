package com.voting.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.voting.test.connection.CP;
import com.voting.test.model.Constituency;



@Service
public class ConstiDao {
	static Connection c = CP.createCon();
	public boolean insertConsti(Constituency consti) {
		boolean f = false;
		try {
			String q = "insert into Constituency(constituency_id,constituency_name) values(?,?)";
			PreparedStatement p = c.prepareStatement(q);
			p.setInt(1, consti.getConstituency_id());
			p.setString(2, consti.getConstituency_name());
			
			int i=p.executeUpdate();
			if(i<0) {
				return f;
			}
			else {
			f=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f; 
	}
	public List<Constituency>  getAllCons(){
		List<Constituency> li = new ArrayList<Constituency>();
		try {
			String q = "select * from Constituency";
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(q);
			while(rs.next()) {
				
				int constituency_id = rs.getInt("constituency_id");
				
				String constituency_name = rs.getString("constituency_name");
				Constituency pt = new Constituency(constituency_id,constituency_name);
				li.add(pt);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	public boolean deleteById(int id) {
		boolean f = false;
		try {
			String q = "delete from Constituency where constituency_id = ?";
			PreparedStatement p = c.prepareStatement(q);
			p.setInt(1, id);
			p.executeUpdate();
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}
	public static boolean update(int id,String nname) {
		boolean f = false;
		try {
			String q = "UPDATE Constituency set constituency_name = ? where constituency_id = ? ";
			PreparedStatement p = c.prepareStatement(q);
			p.setString(1, nname);
			p.setInt(2, id);
			p.executeUpdate();
			f=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
	public static Constituency getById(int id) {
		Constituency con = new Constituency();
		try {
			String q = "select * from Constituency where constituency_id = ?";
			PreparedStatement p = c.prepareStatement(q);
			p.setInt(1, id);
			ResultSet rs=p.executeQuery();
			if(rs.next()) {
			
				con.setConstituency_id(rs.getInt("constituency_id"));
				con.setConstituency_name(rs.getString("constituency_name"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}

}


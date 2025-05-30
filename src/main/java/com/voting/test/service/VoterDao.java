package com.voting.test.service;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.voting.test.connection.CP;
import com.voting.test.model.Voters;

@Service
public class VoterDao {
	
	static Connection c = CP.createCon();
	public static boolean insert(Voters v) {
		boolean f = false;
		try {
		String q = "insert into Voters (voter_id, age, constituency_id, contactno, firstname, lastname) values (?,?,?,?,?,?)";
		PreparedStatement p = c.prepareStatement(q);
		p.setInt(1, v.getVoter_id());
		p.setInt(2, v.getAge());
		p.setInt(3, v.getConstituency_id());
		p.setInt(4, v.getContactno());
		p.setString(5, v.getFirstname());
		p.setString(6, v.getLastname());
		
		p.executeUpdate();
		f=true;
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		return f;
	}
	public List<Voters>  getAll(){
		List<Voters> li = new ArrayList<Voters>();
		try {
			String q ="select * from Voters";
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(q);
			
			while(r.next()) {
				int voter_id = r.getInt("voter_id");
				int age = r.getInt("age");
				int constituency_id = r.getInt("constituency_id");
				int contactno = r.getInt("contactno");
				String firstname = r.getString("firstname");
				String lastname = r.getString("lastname");
				Voters v = new Voters(voter_id,age,constituency_id,contactno,firstname,lastname);
				li.add(v);
				
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	public static boolean ageValidation(int age) {
		if(age>=18) {
			return true;
		}
		return false;
	}
	public static boolean deleteById(int id) {
		boolean f = false;
		try {
			String q = "delete from Voters where voter_id = ? ";
			PreparedStatement p = c.prepareStatement(q);
			p.setInt(1, id);
			p.executeUpdate();
			f= true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public static boolean update(int id,String nname) {
		boolean f = false;
		try {
			String q ="UPDATE Voters SET firstname = ? where voter_id = ? ";
			PreparedStatement p  = c.prepareStatement(q);
			p.setString(1, nname);
			p.setInt(2, id);
			
			
			p.executeUpdate();
			f=true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}
	public static Voters getById(int id) {
		Voters v = new Voters();
		try {
			String q = "select * from Voters where voter_id = ?";
			PreparedStatement p = c.prepareStatement(q);
			p.setInt(1, id);
			ResultSet s = p.executeQuery();
			if(s.next()) {
			v.setVoter_id(s.getInt("voter_id"));
			v.setAge(s.getInt("age"));
			v.setConstituency_id(s.getInt("constituency_id"));
			v.setContactno(s.getInt("contactno"));
			v.setFirstname(s.getString("firstname"));
			v.setLastname(s.getString("lastname"));
			}
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	
}

package com.voting.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.voting.test.connection.CP;
import com.voting.test.model.ElectionSchedule;
import com.voting.test.validation.Validation;

@Service
public class ElectionDao {
	static Connection con = CP.createCon();
	public static boolean isValidDate(String d) {
		String k[] = d.split("/");
		Validation v = new Validation();
		if(k.length==3) {
			if(v.isValid1(k[0]) && v.isValid2(k[1]) && v.isValid3(k[2])) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
					
					
	}
	public static boolean insertEs(ElectionSchedule e) {
		boolean f=false;
		try {
			String q = "insert into Election(election_id,date,constituency_id) values(?,?,?) ";
			PreparedStatement p = con.prepareStatement(q);
			p.setInt(1, e.getElection_id());
			p.setString(2, e.getDate());
			p.setInt(3, e.getConstituency_id());
			p.executeUpdate();
			f=true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}
	public static List<ElectionSchedule> getAllS(){
		List<ElectionSchedule> li = new ArrayList<ElectionSchedule>();
		try {
			String q = "select * from Election";
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery(q);
			while(r.next()) {
				int election_id = r.getInt("election_id");
				String date = r.getString("date");
				int const_id = r.getInt("constituency_id");
				ElectionSchedule e = new ElectionSchedule(election_id,date,const_id);
				li.add(e);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return li;
	}
	public static ElectionSchedule getEsById(int id) {
		ElectionSchedule e = new ElectionSchedule();
		try {
			String q = "select * from Election where election_id = ?";
			PreparedStatement p = con.prepareStatement(q);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			if(rs.next()) {
				e.setElection_id(rs.getInt("election_id"));
				e.setDate(rs.getString("date"));
				e.setConstituency_id(rs.getInt("constituency_id"));
				
			}
		}catch(Exception ex) {
				ex.printStackTrace();
			}
		return e;
	}
	public static boolean deleteID(int id) {
		boolean f = false;
		try {
			String q = "delete from Election where election_id = ?";
			PreparedStatement p = con.prepareStatement(q);
			p.setInt(1, id);
			p.executeUpdate();
			f=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public static boolean updateDate(int id ,String date) {
		boolean f = false;
		try {
			String q = "UPDATE Election set date = ? where election_id = ?";
			PreparedStatement p = con.prepareStatement(q);
			p.setString(1, date);
			p.setInt(2, id);
			p.executeUpdate();
			f=true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public static  int  getConstiByEId(int id) {
		int gid =0;
		try {
			String q = "select constituency_id from election where election_id=?";
			PreparedStatement p = con.prepareStatement(q);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				gid = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return gid;
	}
}
	



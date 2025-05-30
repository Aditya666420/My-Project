package com.voting.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.voting.test.connection.CP;
import com.voting.test.model.Parties;


@Service
public class PartyDao {
	static Connection c = CP.createCon();
	public boolean insertParty(Parties pa) {
		boolean f = false;
		try {
			String q = "insert into Parties(id,constituency_id,party_id,partyname) values(?,?,?,?)";
			PreparedStatement p = c.prepareStatement(q);
			p.setInt(1, pa.getId());
			p.setInt(2, pa.getConstituency_id());
			p.setInt(3, pa.getParty_id());
			p.setString(4, pa.getPartyname());
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
	public List<Parties>  getAllParty(){
		List<Parties> li = new ArrayList<Parties>();
		try {
			String q = "select * from Parties";
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(q);
			while(rs.next()) {
				int id = rs.getInt("id");
				int constituency_id = rs.getInt("constituency_id");
				int party_id=rs.getInt("party_id");
				String partyname = rs.getString("partyname");
				Parties pt = new Parties(id,constituency_id,party_id,partyname);
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
			String q = "delete from Parties where id = ?";
			PreparedStatement p = c.prepareStatement(q);
			p.setInt(1, id);
			f=p.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}
	public static boolean update(int id,String nname) {
		boolean f = false;
		try {
			String q = "UPDATE Parties SET partyname = ? where id =?";
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
	public static Parties getById(int id) {
		Parties pa = new Parties();
		try {
			String q = "select * from Parties where id = ?";
			PreparedStatement p = c.prepareStatement(q);
			p.setInt(1, id);
			ResultSet rs=p.executeQuery();
			if(rs.next()) {
				pa.setId(rs.getInt("id"));
				pa.setConstituency_id(rs.getInt("constituency_id"));
				pa.setParty_id(rs.getInt("party_id"));
				pa.setPartyname(rs.getString("partyname"));;
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pa;
		
	}
	public static  List<Integer> getPIDbyCid(int cid){
		List<Integer> li = new ArrayList<Integer>();
		try {
			String q = " select id from parties where constituency_id = ?";
			PreparedStatement p = c.prepareStatement(q);
			p.setInt(1, cid);
			ResultSet r = p.executeQuery();
			while(r.next()) {
				Integer k = r.getInt("id");
				li.add(k);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	
		
	

}

package com.voting.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Statement;

import com.voting.test.connection.CP;
import com.voting.test.model.Cast;
import com.voting.test.model.Count;
import com.voting.test.model.Parties;


public class Voting {
	static Connection con = CP.createCon();
	public static boolean addIn(int eid,int cid,int pid , int vid) {
		boolean f= false;
		try {
			String q = "INSERT into Cast (e_id,c_id,p_id,v_id) values (?,?,?,?)";
			PreparedStatement p = con.prepareStatement(q);
			p.setInt(1, eid);
			p.setInt(2, cid);
			p.setInt(3, pid);
			p.setInt(4, vid);
			p.executeUpdate();
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	public static List<Cast> getRes(){
		List<Cast> li = new ArrayList<Cast>();
		try {
			String q = "select * from cast";
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery(q);
			while(r.next()) {
				int c_id = r.getInt("c_id");
				int p_id= r.getInt("p_id");
				int v_id= r.getInt("v_id");
				Cast c = new Cast(c_id,p_id,v_id);
				li.add(c);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	public static List<Count> getCount(int eid){
		List<Count> li = new ArrayList<Count>();
		try {
			String q = " select p_id,count(v_id) from cast where e_id= ? group by p_id";
			PreparedStatement p = con.prepareStatement(q);
			p.setInt(1, eid);
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				int p_id = rs.getInt(1);
				int count = rs.getInt(2);
				Count c = new Count(p_id,count);
				li.add(c);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	public static List<Integer> getByEid(int eid){
		List<Integer> li = new ArrayList<Integer>();
		try {
			String q = "select v_id from cast where e_id=?";
			PreparedStatement p = con.prepareStatement(q);
			p.setInt(1, eid);
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				Integer v_id = rs.getInt("v_id");
				li.add(v_id);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	

}

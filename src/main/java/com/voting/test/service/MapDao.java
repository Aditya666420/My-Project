package com.voting.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.voting.test.connection.CP;
import com.voting.test.model.Map1;
import com.voting.test.model.Voters;
@Service
public class MapDao {
	static Connection c = CP.createCon();
	public static List<Map1> getVbyCid(int id) {
		List<Map1> li = new ArrayList<Map1>();
		try {
			String q = "select Voters.voter_id,Parties.partyname,Election.date from Election inner join Parties on Parties.constituency_id=Election.constituency_id inner join Voters on Voters.constituency_id=Parties.constituency_id where Voters.voter_id=?;";
			PreparedStatement s =    c.prepareStatement(q);
			s.setInt(1, id);
			ResultSet rs = s.executeQuery();
			while(rs.next()) {
				int vid = rs.getInt(1);
				String pname = rs.getString(2);
				String date = rs.getString(3);
				Map1 m = new Map1(vid,pname,date);
				li.add(m);
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return li;
	}
}

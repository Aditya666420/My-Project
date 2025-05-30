package com.voting.test.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voting.test.connection.CP;
import com.voting.test.model.Cast;
import com.voting.test.model.Count;
import com.voting.test.model.Parties;
import com.voting.test.model.Voters;

@Service
public class CastingDao {
	
	static Connection c = CP.createCon();
	public static boolean castVote(int eid,int vid,int pid) {
		List<Integer> co = Voting.getByEid(eid);
		for(Integer k :co) {
			if(k == vid) {
				return false;
			}
		}
		Voters v=VoterDao.getById(vid);
		if(v.getConstituency_id()!= ElectionDao.getConstiByEId(eid)) {
			return false;
		}
		if(v!=null) {
			System.out.print(v.getConstituency_id());
			List<Integer> li = PartyDao.getPIDbyCid(v.getConstituency_id());
			Integer i = Integer.valueOf(pid);
			System.out.print(li);
			if(li.contains(i)) {
				Voting.addIn(eid,v.getConstituency_id(),pid, vid);
				return true;
				
			}
			
		}
		return false;
	}
	public static String winnerByEid(int eid)
	{
		List<Count> c = Voting.getCount(eid);
		
		if(c.size()==0) {
			return "Invalid Election_id";
		}
		
		int max = c.get(0).getCount();
		int sec = Integer.MIN_VALUE;
		int mp=c.get(0).getP_id();
		int msec = c.get(0).getP_id();
		
		for(int i =1;i<c.size();i++) {
//			System.out.println(c.get(i).getP_id());
//			Parties po = PartyDao.getById(c.get(i).getP_id());
//			System.out.println(po.getPartyname());
			if(c.get(i).getCount()>max) {
				mp= c.get(i).getP_id();
				max = c.get(i).getCount();
				
			}
			else {
				if(c.get(i).getCount()>sec) {
					msec = c.get(i).getP_id();
					sec = c.get(i).getCount();
				}
			}
		}
		if(max>sec) {
			Parties p = PartyDao.getById(mp);
			return "Winner is "+p.getPartyname()+" with "+max+" votes.";
		}
		Parties m = PartyDao.getById(mp);
		Parties s = PartyDao.getById(msec);
		return "Its a draw between "+m.getPartyname()+" and "+s.getPartyname()+" with "+max+" votes ";
		
		
	}
}

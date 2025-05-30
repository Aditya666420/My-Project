package com.voting.test.model;

public class Map1 {
	
	int voter_id;
	String partyname;
	String date;
	public Map1() {
		super();
	}
	public Map1(int voter_id, String partyname, String date) {
		super();
		this.voter_id = voter_id;
		this.partyname = partyname;
		this.date = date;
	}
	public int getVoter_id() {
		return voter_id;
	}
	public void setVoter_id(int voter_id) {
		this.voter_id = voter_id;
	}
	public String getPartyname() {
		return partyname;
	}
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}
	
	

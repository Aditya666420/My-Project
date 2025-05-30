package com.voting.test.model;

public class Parties {
	int id;
	int constituency_id;
	int party_id;
	String partyname;
	public Parties(int id, int constituency_id, int party_id, String partyname) {
		super();
		this.id = id;
		this.constituency_id = constituency_id;
		this.party_id = party_id;
		this.partyname = partyname;
	}
	public Parties() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getConstituency_id() {
		return constituency_id;
	}
	public void setConstituency_id(int constituency_id) {
		this.constituency_id = constituency_id;
	}
	public int getParty_id() {
		return party_id;
	}
	public void setParty_id(int party_id) {
		this.party_id = party_id;
	}
	public String getPartyname() {
		return partyname;
	}
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
}

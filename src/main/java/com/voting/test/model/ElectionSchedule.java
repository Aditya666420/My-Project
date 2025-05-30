package com.voting.test.model;

public class ElectionSchedule {
	int election_id;
	String date;
	int constituency_id;
	public int getElection_id() {
		return election_id;
	}
	public void setElection_id(int election_id) {
		this.election_id = election_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getConstituency_id() {
		return constituency_id;
	}
	public void setConstituency_id(int constituency_id) {
		this.constituency_id = constituency_id;
	}
	public ElectionSchedule(int election_id, String date, int constituency_id) {
		super();
		this.election_id = election_id;
		this.date = date;
		this.constituency_id = constituency_id;
	}
	public ElectionSchedule() {
		// TODO Auto-generated constructor stub
	}
}

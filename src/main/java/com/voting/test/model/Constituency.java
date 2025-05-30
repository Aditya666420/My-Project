package com.voting.test.model;

public class Constituency {
	int constituency_id;
	String constituency_name;
	public Constituency() {
		super();
	}
	public int getConstituency_id() {
		return constituency_id;
	}
	public void setConstituency_id(int constituency_id) {
		this.constituency_id = constituency_id;
	}
	public String getConstituency_name() {
		return constituency_name;
	}
	public void setConstituency_name(String constituency_name) {
		this.constituency_name = constituency_name;
	}
	public Constituency(int constituency_id, String constituency_name) {
		super();
		this.constituency_id = constituency_id;
		this.constituency_name = constituency_name;
	}
	

}

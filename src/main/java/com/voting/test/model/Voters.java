package com.voting.test.model;

public class Voters {
	int voter_id;
	int age;
	int constituency_id;
	
	int contactno;
	String firstname;
	String lastname;
	public Voters(int voter_id, int age, int constituency_id, int contactno, String firstname, String lastname) {
		super();
		this.voter_id = voter_id;
		this.age = age;
		this.constituency_id = constituency_id;
		this.contactno = contactno;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public Voters() {
		// TODO Auto-generated constructor stub
	}
	public int getVoter_id() {
		return voter_id;
	}
	public void setVoter_id(int voter_id) {
		this.voter_id = voter_id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getConstituency_id() {
		return constituency_id;
	}
	public void setConstituency_id(int constituency_id) {
		this.constituency_id = constituency_id;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
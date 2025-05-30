package com.voting.test.model;

import java.beans.JavaBean;

import org.springframework.stereotype.Component;

@Component
public class Count {
	
	int p_id;
	int count;
	public Count() {
		super();
	}
	public Count(int p_id, int count) {
		super();
		this.p_id = p_id;
		this.count = count;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	

}

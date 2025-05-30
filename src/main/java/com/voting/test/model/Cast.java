package com.voting.test.model;

public class Cast {
	int cid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	int pid;
	int vid;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public Cast() {
		super();
	}
	public Cast(int cid,int pid, int vid) {
		super();
		this.cid=cid;
		this.pid = pid;
		this.vid = vid;
	}
	
}

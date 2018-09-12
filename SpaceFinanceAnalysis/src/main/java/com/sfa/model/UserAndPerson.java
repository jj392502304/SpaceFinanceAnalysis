package com.sfa.model;

public class UserAndPerson {
	public TPerson person;
	public TSysUser user;
	public TPerson getPerson() {
		return person;
	}
	public void setPerson(TPerson person) {
		this.person = person;
	}
	public TSysUser getUser() {
		return user;
	}
	public void setUser(TSysUser user) {
		this.user = user;
	}
}

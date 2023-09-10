package com.insurance.life;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PolicyUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long policy_id;
	
	private String name;
	
	private String contactNo;
	
	private int age;

	public PolicyUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PolicyUser(Long policy_id, String name, String contactNo, int age) {
		super();
		this.policy_id = policy_id;
		this.name = name;
		this.contactNo = contactNo;
		this.age = age;
	}
	

	public Long getPolicy_id() {
		return policy_id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
	
	
	
}
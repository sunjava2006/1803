package com.thzhima.eye025.bean;

public class Sysadmin {

	private int id;
	private String name;
	private String password;
	private String adminName ;
	private boolean superAdmin;
	
	public Sysadmin() {
		
	}

	public Sysadmin(int id, String name, String password, String adminName, boolean superAdmin) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.adminName = adminName;
		this.superAdmin = superAdmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public boolean isSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

	@Override
	public String toString() {
		return "Sysadmin [id=" + id + ", name=" + name + ", password=" + password + ", adminName=" + adminName
				+ ", superAdmin=" + superAdmin + "]";
	}
	
	
	
}

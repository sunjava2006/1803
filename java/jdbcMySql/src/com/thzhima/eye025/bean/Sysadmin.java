package com.thzhima.eye025.bean;

public class Sysadmin {
    private int id;
    private String name;
    private String adminName;
    private String password;
    private int superAdmin;
    
    public Sysadmin() {
    	
    }
    
    public Sysadmin(int id, String name, String adminName,String password, int superAdmin) {
    	this.id = id;
    	this.name = name;
    	this.adminName = adminName;
    	this.password = password;
    	this.superAdmin = superAdmin;
    }
    
    public int getId() {
    	return this.id;
    }
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSuperAdmin() {
		return superAdmin;
	}
	public void setSuperAdmin(int superAdmin) {
		this.superAdmin = superAdmin;
	}

	@Override
	public String toString() {
		return "Sysadmin [id=" + id + ", name=" + name + ", adminName=" + adminName + ", password=" + password
				+ ", superAdmin=" + superAdmin + "]";
	}
    
	
	
    
}

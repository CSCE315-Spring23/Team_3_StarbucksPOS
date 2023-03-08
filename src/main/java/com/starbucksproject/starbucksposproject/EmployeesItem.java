package com.starbucksproject.starbucksposproject;

public class EmployeesItem {
	private int employee_id;
	private String employee_name;
	private String employee_role;

	private Boolean access_mgmt;

	public EmployeesItem(int employee_id, String employee_name, String employee_role, Boolean access_mgmt) {
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_role = employee_role;
		this.access_mgmt = access_mgmt;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) { this.employee_name = employee_name; }

	public String getEmployee_role() {
		return employee_role;
	}

	public void setEmployee_role(String employee_role) { this.employee_role = employee_role; }

	public Boolean getAccess_mgmt(){
		return access_mgmt;
	}

	public void setAccess_mgmt(Boolean access_mgmt){
		this.access_mgmt = access_mgmt;
	}
}


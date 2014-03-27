package com.example.xmlpullparsing;
public class Employee {
	 private int id;
	 private String name;
	 private String salary;
 
    
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


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	@Override
    public String toString() {
        return " Id= "+id + "\n Name= " + name + "\n Salary= " + salary;
    }
}

package com.app.training;

public class Student {
	
	private int studentId;
	private String sName;
	private String sClass;
	private int sAge;
	private String sLocation;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsClass() {
		return sClass;
	}
	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	public int getsAge() {
		return sAge;
	}
	public void setsAge(int sAge) {
		this.sAge = sAge;
	}
	public String getsLocation() {
		return sLocation;
	}
	public void setsLocation(String sLocation) {
		this.sLocation = sLocation;
	}
	
	public Student()
	{
		super();
	}
	
	public Student(String sName, String sClass, int sAge, String sLocation) {
		super();
		this.sName = sName;
		this.sClass = sClass;
		this.sAge = sAge;
		this.sLocation = sLocation;
	}
	
	public Student(int studentId, String sName, String sClass, int sAge, String sLocation) {
		super();
		this.studentId = studentId;
		this.sName = sName;
		this.sClass = sClass;
		this.sAge = sAge;
		this.sLocation = sLocation;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", sName=" + sName + ", sClass=" + sClass + ", sAge=" + sAge
				+ ", sLocation=" + sLocation + "]";
	}
}

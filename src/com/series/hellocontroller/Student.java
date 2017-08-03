package com.series.hellocontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"studentSkills", "studentAddress"})
@JsonPropertyOrder({"studentDoB", "student_name", "studentMobile", "studentAddress", "studentHobby", "studentSkills"})
public class Student {
			//@NotNull check if value is not null
			//@NotEmpty check string if null 

	@Pattern(regexp="[^0-9]*") //does not accept numbers 0-9
	@JsonProperty("student_name")
	private String studentName;
	
	@Size(min=2, max=30) @IsValidHobby(listOfValidHobbies = "Music|Football|Cricket|Hockey") //min char 2 max char 30
	private String studentHobby; 
	
	@Max(2222) //number cannot exceed this number
				//@Min
	private Long studentMobile;
	 
			//@Future
	@Past //if value binded is falling in future results in binding error
	private Date studentDoB;
	private ArrayList<String> studentSkills;
	
	private Address studentAddress;
	
	
	
	
	
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentHobby() {
		return studentHobby;
	}
	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}
	public Long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public Date getStudentDoB() {
		return studentDoB;
	}
	public void setStudentDoB(Date studentDoB) {
		this.studentDoB = studentDoB;
	}
	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}
	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}
	
}

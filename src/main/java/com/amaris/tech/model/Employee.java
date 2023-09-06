package com.amaris.tech.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6788610399122287719L;

	private Integer identifier;

	private String name;

	private Integer salary;

	private Integer anualSalary;

	private Integer age;

	private Integer profileImagePath;

	@JsonCreator
	public Employee(@JsonProperty(value = "id") Integer identifier,
			@JsonProperty(value = "employee_name") String employeeName,
			@JsonProperty(value = "employee_salary") Integer employeeSalary,
			@JsonProperty(value = "employee_age") Integer employeeAge,
			@JsonProperty(value = "profile_image") Integer profileImagePath) {
		this.identifier = identifier;
		this.name = employeeName;
		this.salary = employeeSalary;
		this.anualSalary = employeeSalary * 12;
		this.age = employeeAge;
		this.profileImagePath = profileImagePath;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getAnualSalary() {
		return anualSalary;
	}

	public void setAnualSalary(Integer anualSalary) {
		this.anualSalary = anualSalary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getProfileImagePath() {
		return profileImagePath;
	}

	public void setProfileImagePath(Integer profileImagePath) {
		this.profileImagePath = profileImagePath;
	}

	@Override
	public String toString() {
		return "Employee [identifier=" + identifier + ", employeeName=" + name + ", employeeSalary=" + salary
				+ ", employeeAnualSalary=" + anualSalary + ", employeeAge=" + age + ", profileImagePath="
				+ profileImagePath + "]";
	}

}

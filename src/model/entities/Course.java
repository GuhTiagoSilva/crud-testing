package model.entities;

import java.sql.Connection;

public class Course {

	private Integer id;

	private String courseName;

	private String classDescription;

	private String period;

	private Integer year;

	private Connection conn;

	public Course() {

	}

	public Course(Integer id, String courseName, String classDescription, String period, Integer year) {
		this.id = id;
		this.courseName = courseName;
		this.classDescription = classDescription;
		this.period = period;
		this.year = year;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", " + " Course: " + courseName + ", " + " Class: " + classDescription + ", " + " Period: "
				+ period + ", " + " Year: " + year;
	}

}

package com.EffortLogger;
import java.sql.Timestamp;
/*
 * Created by Maguire Brady
 * For use in CSE360
 */
import java.util.Objects;

public class Employee {//implements Serializable{
	//private static final long serialVersionUID = 1L;
	String name, id, password;
	String role;
	String hours, defects;
	Timestamp passwordChange;
	public Employee(String name, String id, String password, String role, String ssn, String hours, String defects, Timestamp passwordChange) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.role = role;
		this.hours = hours;
		this.defects = defects;
		this.passwordChange = passwordChange;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getHours() {
		return hours;
	}
	
	public void setHours(String hours) {
		this.hours = hours;
	}
	
	public String getDefects() {
		return defects;
	}
	
	public void SetDefects(String defects) {
		this.defects = defects;
	}
	@Override
	public String toString() {
		return "name=" + name + ", id=" + id + ", password=" + password + ", rank=" + role
				+ ", passwordChange=" + passwordChange;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, password, role);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && role == other.role;
	}
	protected static Employee GetEmployee(String userID) {
		//fetch from db with user id
		return new Employee(null, userID,null, null, null, null, null, null);
	}
	public Timestamp getPasswordChange() {
		return passwordChange;
	}
	public void setPasswordChange(Timestamp passwordChange) {
		this.passwordChange = passwordChange;
	}
//	public static Employee deserialize(FileInputStream in) throws IOException, ClassNotFoundException {
//		ObjectInputStream instream = new ObjectInputStream(in);
//		Employee emp = (Employee) instream.readObject();
//		return emp;
//	}
}

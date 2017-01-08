package jpa_example.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String fName;
	private String lName;
	private int age;

	public Customer() {
	}

	public Customer(String fName, String lName, int age) {
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

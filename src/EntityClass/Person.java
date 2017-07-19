package EntityClass;

import java.sql.Date;

public class Person {
	private String firstName;
	private String lastName;
	private String Dob;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String houseNo;
	
	public Person()
        {
        }
	
	public Person(String firstName, String lastName, String dob, String street, String city, String state, String zip,
			String houseNo) {
		this.firstName = firstName;
		this.lastName = lastName;
		Dob = dob;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.houseNo = houseNo;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getDob() {
		return Dob;
	}
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	public String getHouseNo() {
		return houseNo;
	} 

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(String Dob) {
        this.Dob = Dob;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
	
	
	

}

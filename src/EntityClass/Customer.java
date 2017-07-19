package EntityClass;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {

    private String cusId;
    private String empid;
    
    private Employee employee;
    private List<Rent> rents;

    
    public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public Customer()
    {}
    
    public Customer(String cusId, Employee employee, String firstName, String lastName, String dob, String street, String city, String state, String zip, String houseNo) {
        super(firstName, lastName, dob, street, city, state, zip, houseNo);
        this.cusId = cusId;
        this.employee = employee;
        rents = new ArrayList<Rent>();

    }

    public void addRent(Rent r) {
        rents.add(r);
    }

    public Employee getEmployee() {
        return employee;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public String getCusId() {
        return cusId;
    }

}

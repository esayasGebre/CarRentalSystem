package EntityClass;

import java.util.Date;

public class Rent {
	private String rentId;
	private String rentDate;
	private String returnDate;
	private String isReturned;
	private String carId;
	private String custId;
	private String empId;
	private Customer customer;
	private Vehicle vehicle;
	private Employee employee;

	public Rent(String rentId, String rentDate, String returnDate, String isReturned, String carId, String custId,
			String empId, Customer customer, Vehicle vehicle, Employee employee) {
		this.rentId = rentId;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.isReturned = isReturned;
		this.carId = carId;
		this.custId = custId;
		this.empId = empId;
		this.customer = customer;
		this.vehicle = vehicle;
		this.employee = employee;
	}

	public Rent() {
		
	}

	public String getRentId() {
		return rentId;
	}

	public void setRentId(String rentId) {
		this.rentId = rentId;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getIsReturned() {
		return isReturned;
	}

	public void setIsReturned(String isReturned) {
		this.isReturned = isReturned;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}

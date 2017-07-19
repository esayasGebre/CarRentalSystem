package EntityClass;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Employee extends Person {

    private String empId;
    private String role;
    private String userName;
    private String password;
    private List<Customer> customers;
    private List<Rent> rents;

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee(String empId, String role, String userName, String password, String firstName, String lastName, String dob, String street, String city, String state, String zip, String houseNo) {
        super(firstName, lastName, dob, street, city, state, zip, houseNo);
        this.empId = empId;
        this.role = role;
        this.userName = userName;
        this.password = password;

        customers = new ArrayList<Customer>();
        rents = new ArrayList<Rent>();

    }
    public Employee()
    {
    super();
    
         customers = new ArrayList<Customer>();
        rents = new ArrayList<Rent>();

    }

    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public void addRent(Rent r) {
        rents.add(r);
    }

       public List<Customer> getCustomers() {
        return customers;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public String getEmpId() {
        return empId;
    }

    public String getRole() {
        return role;
    }

    public void updateCustomer(Customer c) {

    }

    public void deleteCustomer(Customer c) {

    }

    public Customer getCustomer(String customerId) {
        return null;
    }

    public void updatePassowrd(String oldPassword, String newpassword) {

    }

    public void updateRent(Rent r) {

    }

    public boolean deleteRent(Rent r) {
        return true;
    }

    public List<Vehicle> listofVehicleByCustomer(Customer c) {
        return null;
    }

    public Rent updateReternStatus() {
        return null;
    }

}

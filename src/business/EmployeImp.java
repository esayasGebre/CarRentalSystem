package business;

import EntityClass.Employee;
import databasepackage.CarRentDBmanagement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Henok B
 */
public class EmployeImp {

    CarRentDBmanagement dbm = new CarRentDBmanagement();
    Connection con = dbm.getConnection();

    public Employee saveEmployee(Employee emp) {

        try {
            //Connection con = getConnection();
            Statement st;
            PreparedStatement preparedStmt = con.prepareStatement("insert into employee (empID, firstName, lastName, userName, password, empRole, dob, street, city, state, zip, houseNo) values (?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStmt.setString(1, emp.getEmpId());
            preparedStmt.setString(2, emp.getFirstName());
            preparedStmt.setString(3, emp.getLastName());
            preparedStmt.setString(4, emp.getUserName());
            preparedStmt.setString(5, emp.getPassword());
            preparedStmt.setString(6, emp.getRole());
            preparedStmt.setString(7, emp.getDob());
            preparedStmt.setString(8, emp.getStreet());
            preparedStmt.setString(9, emp.getCity());
            preparedStmt.setString(10, emp.getState());
            preparedStmt.setString(11, emp.getZip());
            preparedStmt.setString(12, emp.getHouseNo());
            preparedStmt.execute();

            // execute the preparedstatement
            //preparedStmt.execute();
            //con.close();
            return emp;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public boolean deleteEmployee(Employee emp) {

        try {
            //Connection con = getConnection();
            Statement st;
            st = con.createStatement();
            PreparedStatement stmt = con.prepareStatement("delete from employee where empID = ?");
            stmt.setString(1, emp.getEmpId());
            stmt.execute();
            con.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public Employee updateEmployee(Employee emp) {
        //prepareStatement("update employee set firstName=?, lastName=?, department=?, emplDate=? , gender=? , email=?,userName=?,password=? where id = ?");

        try {
            Statement st;
            st = con.createStatement();

            //String query = "update rent set status = ? where carCarId = ? AND custormerCusId = ? AND rentDate = ?";
            PreparedStatement preparedStmt = con.prepareStatement("update employee set firstName = ?, lastName = ?, userName = ?, password = ?, empRole = ?, dob = ?, street = ?, city = ?, state = ?, zip = ?, houseNo  = ? where empID = ?");

            //for the set(put) value
            preparedStmt.setString(1, emp.getFirstName());
            preparedStmt.setString(2, emp.getLastName());
            preparedStmt.setString(3, emp.getUserName());
            preparedStmt.setString(4, emp.getPassword());
            preparedStmt.setString(5, emp.getRole());
            preparedStmt.setString(6, emp.getDob());
            preparedStmt.setString(7, emp.getStreet());
            preparedStmt.setString(8, emp.getCity());
            preparedStmt.setString(9, emp.getState());
            preparedStmt.setString(10, emp.getZip());
            preparedStmt.setString(11, emp.getHouseNo());

            preparedStmt.setString(12, emp.getEmpId());

            preparedStmt.execute();
            System.out.println(emp.getEmpId()+" ddd "+emp.getRole());
           // con.close();
            return emp;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public Employee getEmployeeById(String empId) {

        Employee emp = new Employee();

       
        try {
            // Connection connection = getConnection();

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            //PreparedStatement preparedStmt = con.prepareStatement("select empID, firstName, lastName, userName, password, empRole, dob, street, city, state, zip, houseNo from employee where empID = ?");
            PreparedStatement preparedStmt = con.prepareStatement("select * from employee where empID = ?");
            preparedStmt.setString(1, empId);
            rs = preparedStmt.executeQuery();

            //Employee emp;
            ArrayList<String> record;
             while (rs.next()) {
            //     record = new ArrayList<String>();

            emp.setEmpId(rs.getString(1));
            emp.setFirstName(rs.getString(2));
            emp.setLastName(rs.getString(3));
            emp.setUserName(rs.getString(4));
            emp.setPassword(rs.getString(5));
            emp.setRole(rs.getString(6));
            emp.setDob(rs.getString(7));
            emp.setStreet(rs.getString(8));
            emp.setCity(rs.getString(9));
            emp.setState(rs.getString(10));
            emp.setZip(rs.getString(11));
            emp.setHouseNo(rs.getString(12));

            //     data.add(record);
             }
            //con.close();
            return emp;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    public ArrayList<Employee> getAllEmployee() {

        //         public ArrayList<ArrayList<String>> SearchFromTable(String query, String fieldvalue, ArrayList<String> headTable) {
        //    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        ArrayList<Employee> data = new ArrayList<Employee>();
        try {
            // Connection connection = getConnection();

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement("select empID, firstName, lastName, userName, password, empRole, dob, street, city,state,zip, houseNo from employee ");
            //preparedStmt.setString(1, empId);
            rs = preparedStmt.executeQuery();

            //Employee emp;
            ArrayList<String> record;
            while (rs.next()) {
                Employee emp = new Employee();

                emp.setEmpId(rs.getString(1));
                emp.setFirstName(rs.getString(2));
                emp.setLastName(rs.getString(3));
                emp.setUserName(rs.getString(4));
                emp.setPassword(rs.getString(5));
                emp.setRole(rs.getString(6));
                emp.setDob(rs.getString(7));
                emp.setStreet(rs.getString(8));
                emp.setCity(rs.getString(9));
                emp.setState(rs.getString(10));
                emp.setZip(rs.getString(11));
                emp.setHouseNo(rs.getString(12));

                data.add(emp);
            }
            //con.close();
            return data;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    public Employee getEmployeeByUserName(String userName) {

        Employee emp = new Employee();

        //         public ArrayList<ArrayList<String>> SearchFromTable(String query, String fieldvalue, ArrayList<String> headTable) {
        //    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        try {
            // Connection connection = getConnection();

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement("select empID, firstName, lastName, userName, password, empRole, dob, street, city,state,zip,houseNo from employee where userName = ?");
            preparedStmt.setString(1, userName);
            rs = preparedStmt.executeQuery();

            //Employee emp;
            ArrayList<String> record;
             while (rs.next()) {
            //     record = new ArrayList<String>();

            emp.setEmpId(rs.getString(1));
            emp.setFirstName(rs.getString(2));
            emp.setLastName(rs.getString(3));
            emp.setUserName(rs.getString(4));
            emp.setPassword(rs.getString(5));
            emp.setRole(rs.getString(6));
            emp.setDob(rs.getString(7));
            emp.setStreet(rs.getString(8));
            emp.setCity(rs.getString(9));
            emp.setState(rs.getString(10));
            emp.setZip(rs.getString(11));
            emp.setHouseNo(rs.getString(12));

            //     data.add(record);
            }
            //con.close();
            return emp;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }
    public static void main(String[] args)

    {
    	EmployeImp emp = new EmployeImp();
    	System.out.println(emp.getEmployeeById("1234").getFirstName());
    }
}

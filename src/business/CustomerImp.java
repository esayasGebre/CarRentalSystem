/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import EntityClass.Customer;
import EntityClass.Employee;
import databasepackage.CarRentDBmanagement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Henok B
 */
public class CustomerImp {
       CarRentDBmanagement dbm = new CarRentDBmanagement();
    Connection con = dbm.getConnection();

    public Customer saveCustomer(Customer cust) {

        try {
            //Connection con = getConnection();
            Statement st;
            PreparedStatement preparedStmt = con.prepareStatement("insert into customer (custId, firstName, lastName, dob, street, city, state, zip, houseNo,empID) values(?,?,?,?,?,?,?,?,?,?)");
            preparedStmt.setString(1, cust.getCusId());
            preparedStmt.setString(2, cust.getFirstName());
            preparedStmt.setString(3, cust.getLastName());
                preparedStmt.setString(4, cust.getDob());
            preparedStmt.setString(5, cust.getStreet());
            preparedStmt.setString(6, cust.getCity());
            preparedStmt.setString(7, cust.getState());
            preparedStmt.setString(8, cust.getZip());
            preparedStmt.setString(9, cust.getHouseNo());
            preparedStmt.setString(10, cust.getEmpid());
            preparedStmt.execute();

            // execute the preparedstatement
            //preparedStmt.execute();
            //con.close();
            return cust;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public boolean deleteCustomer(Customer emp) {

        try {
            //Connection con = getConnection();
            Statement st;
            st = con.createStatement();
            PreparedStatement stmt = con.prepareStatement("delete from customer where custId = ?");
            stmt.setString(1, emp.getCusId());
            stmt.execute();
            //con.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public Customer updateCustomer(Customer cust) {
        //prepareStatement("update employee set firstName=?, lastName=?, department=?, emplDate=? , gender=? , email=?,userName=?,password=? where id = ?");

        try {
            Statement st;
            st = con.createStatement();

            //String query = "update rent set status = ? where carCarId = ? AND custormerCusId = ? AND rentDate = ?";
            PreparedStatement preparedStmt = con.prepareStatement("update customer set firstName = ?, lastName = ?, dob = ?, street = ?, city = ?, state = ?, zip = ?, houseNo  = ?, empID = ? where custId = ?");

            //for the set(put) value
            preparedStmt.setString(1, cust.getFirstName());
            preparedStmt.setString(2, cust.getLastName());
            preparedStmt.setString(3, cust.getDob());
            preparedStmt.setString(4, cust.getStreet());
            preparedStmt.setString(5, cust.getCity());
            preparedStmt.setString(6, cust.getState());
            preparedStmt.setString(7, cust.getZip());
            preparedStmt.setString(8, cust.getHouseNo());

            preparedStmt.setString(9, cust.getEmpid());
            preparedStmt.setString(10, cust.getCusId());
            preparedStmt.execute();

            //con.close();
            return cust;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public Customer getCustomerById(String custId) {

        Customer cust = new Customer();

        //         public ArrayList<ArrayList<String>> SearchFromTable(String query, String fieldvalue, ArrayList<String> headTable) {
        //    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        try {
            // Connection connection = getConnection();

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement("select custId, firstName, lastName, dob, street, city, state, zip, houseNo, empID from customer where custId = ?");
            preparedStmt.setString(1, custId);
            rs = preparedStmt.executeQuery();

            //Employee emp;
            ArrayList<String> record;
            while (rs.next()) {
            //     record = new ArrayList<String>();

            cust.setCusId(rs.getString(1));
            cust.setFirstName(rs.getString(2));
            cust.setLastName(rs.getString(3));
           
            cust.setDob(rs.getString(4));
            cust.setStreet(rs.getString(5));
            cust.setCity(rs.getString(6));
            cust.setState(rs.getString(7));
            cust.setZip(rs.getString(8));
            cust.setHouseNo(rs.getString(9));
            cust.setEmpid(rs.getString(10));

            //     data.add(record);
            }
            //con.close();
            return cust;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    public ArrayList<Customer> getAllCustomer() {

        //         public ArrayList<ArrayList<String>> SearchFromTable(String query, String fieldvalue, ArrayList<String> headTable) {
        //    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        ArrayList<Customer> data = new ArrayList<Customer>();
        try {
            // Connection connection = getConnection();

            Statement st;
            ResultSet rs;

            st = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement("select custId, firstName, lastName, dob, street, city, state, zip, houseNo, empID from customer");
            //preparedStmt.setString(1, empId);
            rs = preparedStmt.executeQuery();

            //Employee emp;
            ArrayList<String> record;
            while (rs.next()) {
                Customer cust = new Customer();

                cust.setCusId(rs.getString(1));
                cust.setFirstName(rs.getString(2));
                cust.setLastName(rs.getString(3));
                 cust.setDob(rs.getString(4));
                cust.setStreet(rs.getString(5));
                cust.setCity(rs.getString(6));
                cust.setState(rs.getString(7));
                cust.setZip(rs.getString(8));
                cust.setHouseNo(rs.getString(9));
                cust.setEmpid(rs.getString(10));

                data.add(cust);
            }
            //con.close();
            return data;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    
    
}

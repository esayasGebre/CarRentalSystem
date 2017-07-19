	
/**
 *
 * @author Group3
 */



package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import EntityClass.Rent;
import databasepackage.CarRentDBmanagement;

public class RentImp {
	CarRentDBmanagement dbm = new CarRentDBmanagement();
	Connection con = dbm.getConnection();

	public Rent saveRent(Rent rent) {

		try {
			// Connection con = getConnection();
			Statement st;
			PreparedStatement preparedStmt = con
					.prepareStatement("insert into rental (rentId, rentDate, returnDate, isReturned, carId,custId,empID) values(?,?,?,?,?,?,?)");
			preparedStmt.setString(1, rent.getRentId());
			preparedStmt.setString(2, rent.getRentDate());
			preparedStmt.setString(3, rent.getReturnDate());
			preparedStmt.setString(4, rent.getIsReturned());
			preparedStmt.setString(5, rent.getCarId());
			preparedStmt.setString(6, rent.getCustId());
			preparedStmt.setString(7, rent.getEmpId());
			preparedStmt.execute();

			// execute the preparedstatement
			// preparedStmt.execute();
			//con.close();
			return rent;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public boolean deleteRent(String rentId) {

		try {
			// Connection con = getConnection();
			Statement st;
			st = con.createStatement();
			PreparedStatement stmt = con.prepareStatement("delete from rental where rentId = ?");
			stmt.setString(1, rentId);
			stmt.execute();
			//con.close();
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public Rent updateRent(Rent rent) {

		try {
			Statement st;
			st = con.createStatement();

			// carId, model, , isAvailable, rentPerPrice
			PreparedStatement preparedStmt = con
					.prepareStatement("update rental set rentDate = ?, returnDate = ?, isReturned = ?, carId = ?, custId = ?, empID = ? where rentId = ?");

			// for the set(put) value
			preparedStmt.setString(1, rent.getRentDate());
			preparedStmt.setString(2, rent.getReturnDate());
			preparedStmt.setString(3, rent.getIsReturned());
			preparedStmt.setString(4, rent.getCarId());
			preparedStmt.setString(5, rent.getCustId());
			preparedStmt.setString(6, rent.getEmpId());
			preparedStmt.setString(7, rent.getRentId());
			preparedStmt.execute();

			//con.close();
			return rent;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public Rent getRentById(String rentId) {
		Rent rent = new Rent();
		try {

			Statement st;
			ResultSet rs;

			st = con.createStatement();
			PreparedStatement preparedStmt = con
					.prepareStatement("select rentId, rentDate, returnDate, isReturned, carId,custId,empID from rental where rentId = ?");
			preparedStmt.setString(1, rentId);
			rs = preparedStmt.executeQuery();

			// Employee emp;
			ArrayList<String> record;
			while (rs.next()) {
				// record = new ArrayList<String>();

				rent.setRentId(rs.getString(1));
				rent.setRentDate(rs.getString(2));
				rent.setReturnDate(rs.getString(3));
				rent.setIsReturned(rs.getString(4));
				rent.setCarId(rs.getString(5));
				rent.setCustId(rs.getString(6));
				rent.setEmpId(rs.getString(7));

				// data.add(record);
			}
			//con.close();
			return rent;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

	public ArrayList<Rent> getAllRents() {

		ArrayList<Rent> data = new ArrayList<Rent>();
		try {
			// Connection connection = getConnection();

			Statement st;
			ResultSet rs;

			st = con.createStatement();
			PreparedStatement preparedStmt = con
					.prepareStatement("select rentId, rentDate, returnDate, isReturned, carId,custId,empID from rental");
			// preparedStmt.setString(1, empId);
			rs = preparedStmt.executeQuery();

			// Employee emp;
			ArrayList<String> record;
			while (rs.next()) {
				Rent rent = new Rent();
				rent.setRentId(rs.getString(1));
				rent.setRentDate(rs.getString(2));
				rent.setReturnDate(rs.getString(3));
				rent.setIsReturned(rs.getString(4));
				rent.setCarId(rs.getString(5));
				rent.setCustId(rs.getString(6));
				rent.setEmpId(rs.getString(7));
				data.add(rent);
			}
			//con.close();
			return data;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

}

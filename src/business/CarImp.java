package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import EntityClass.Car;
import databasepackage.CarRentDBmanagement;

public class CarImp {
	CarRentDBmanagement dbm = new CarRentDBmanagement();
	Connection con = dbm.getConnection();

	public Car saveCar(Car car) {

		try {
			// Connection con = getConnection();
			Statement st;
			PreparedStatement preparedStmt = con
					.prepareStatement("insert into car (carId, model, noOfSeats, isAvailable, rentPerPrice) values(?,?,?,?,?)");
			preparedStmt.setString(1, car.getCarId());
			preparedStmt.setString(2, car.getModel());
			preparedStmt.setString(3, car.getNoOfSeat());
			preparedStmt.setString(4, car.getIsAvailable());
			preparedStmt.setString(5, car.getRentPricePerDay());
			preparedStmt.execute();

			// execute the preparedstatement
			// preparedStmt.execute();
			//con.close();
			return car;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public boolean deleteCar(Car car) {

		try {
			// Connection con = getConnection();
			Statement st;
			st = con.createStatement();
			PreparedStatement stmt = con.prepareStatement("delete from car where carId = ?");
			stmt.setString(1, car.getCarId());
			stmt.execute();
			//con.close();
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public Car updateCar(Car car) {
		
		try {
			Statement st;
			st = con.createStatement();

			// carId, model, , isAvailable, rentPerPrice
			PreparedStatement preparedStmt = con
					.prepareStatement("update car set model = ?, noOfSeats = ?, isAvailable = ?, rentPerPrice = ?  where carId = ?");

			// for the set(put) value
			preparedStmt.setString(1, car.getModel());
			preparedStmt.setString(2, car.getNoOfSeat());
			preparedStmt.setString(3, car.getIsAvailable());
			preparedStmt.setString(4, car.getRentPricePerDay());
			preparedStmt.setString(5, car.getCarId());
			preparedStmt.execute();

			//con.close();
			return car;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public Car getCarById(String carId) {

		Car car = new Car();

		try {

			Statement st;
			ResultSet rs;

			st = con.createStatement();
			PreparedStatement preparedStmt = con
					.prepareStatement("select carId, model, noOfSeats , isAvailable, rentPerPrice from car where carId = ?");
			preparedStmt.setString(1, carId);
			rs = preparedStmt.executeQuery();

			// Employee emp;
			ArrayList<String> record;
			while (rs.next()) {
				// record = new ArrayList<String>();

				car.setCarId(rs.getString(1));
				car.setModel(rs.getString(2));
				car.setNoOfSeat(rs.getString(3));
				car.setIsAvailable(rs.getString(4));
				car.setRentPricePerDay(rs.getString(5));

				// data.add(record);
			}
			//con.close();
			return car;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

	public ArrayList<Car> getAllCar() {

		ArrayList<Car> data = new ArrayList<Car>();
		try {
			// Connection connection = getConnection();

			Statement st;
			ResultSet rs;

			st = con.createStatement();
			PreparedStatement preparedStmt = con
					.prepareStatement("select carId, model,noOfSeats ,isAvailable,rentPerPrice from car");
			// preparedStmt.setString(1, empId);
			rs = preparedStmt.executeQuery();

			// Employee emp;
			ArrayList<String> record;
			while (rs.next()) {
				Car car = new Car();
				car.setCarId(rs.getString(1));
				car.setModel(rs.getString(2));
				car.setNoOfSeat(rs.getString(3));
				car.setIsAvailable(rs.getString(4));
				car.setRentPricePerDay(rs.getString(5));
				data.add(car);
			}
			//con.close();
			return data;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

}

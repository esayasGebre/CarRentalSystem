package EntityClass;

import java.util.ArrayList;
import java.util.List;

public class Car implements Vehicle {
	private String carId;
	private String model;
	private String noOfSeat;
	private String isAvailable;
	private String rentPricePerDay;
	private List<Rent> rents;

	public Car(String carId, String model, String noOfSeat, String isAvailable, String rentPricePerDay) {
		super();
		this.carId = carId;
		this.model = model;
		this.noOfSeat = noOfSeat;
		this.isAvailable = isAvailable;
		this.rentPricePerDay = rentPricePerDay;
		rents = new ArrayList<Rent>();
	}
	
	

	public Car() {
		rents = new ArrayList<Rent>();
	}

	public void addRent(Rent r) {
		rents.add(r);
	}

	public boolean isAvailable()
	{
		if(isAvailable.equals("yes"))
			return true;
		return false;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setNoOfSeat(String noOfSeat) {
		this.noOfSeat = noOfSeat;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setRentPricePerDay(String rentPricePerDay) {
		this.rentPricePerDay = rentPricePerDay;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

	public List<Rent> listOfRents() {
		return rents;
	}

	public String getCarId() {
		return carId;
	}

	public String getModel() {
		return model;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public String getNoOfSeat() {
		return noOfSeat;
	}


	public String getRentPricePerDay() {
		return rentPricePerDay;
	}

	public void setAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public void addVehicle(Vehicle v) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vehicle getVehicle(String vehicleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateVehicle(Vehicle v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteVehicle(String vehicleId) {
		// TODO Auto-generated method stub

	}

}

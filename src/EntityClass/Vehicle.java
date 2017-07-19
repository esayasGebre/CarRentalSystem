package EntityClass;

public interface Vehicle {
	public void addVehicle(Vehicle v);
	public Vehicle getVehicle(String vehicleId);
	public void updateVehicle(Vehicle v);
	public void deleteVehicle(String vehicleId);

}

package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import EntityClass.Car;
import business.CarImp;
import business.CarImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerCar implements Initializable {

	public void unlock_textfiel() {

		txtCarid.setEditable(true);
		txtModel.setEditable(true);
		txtNoofseates.setEditable(true);
		txtRentprice.setEditable(true);
		txtAvailability.setEditable(false);
	}

	public void lock_textfiel() {

		txtCarid.setEditable(false);
		txtModel.setEditable(false);
		txtNoofseates.setEditable(false);
		txtRentprice.setEditable(false);
		txtAvailability.setEditable(false);
	}

	public void clear_textfield() {
		txtCarid.clear();
		txtModel.clear();
		txtNoofseates.clear();
		txtRentprice.clear();
		txtAvailability.clear();
	}

	@FXML // need to put this in since it is private
	private TextField txtCarid;
	@FXML
	private TextField txtModel;
	@FXML
	private TextField txtNoofseates;
	@FXML
	private TextField txtRentprice;
	@FXML
	private TextField txtSearchcarid;

	@FXML
	private TextField txtAvailability;
	@FXML
	private Button addCar;
	@FXML
	private Button updateCar;
	@FXML
	private Button removeCar;
	@FXML
	private Button saveCar;
	@FXML
	private Button editCar;
	@FXML
	private Button cancelCar;
	@FXML
	private Button btnSearchcar;

	CarImp carImp = new CarImp();

	public void handleCar(ActionEvent event) {

		if (event.getSource() == addCar) {

			unlock_textfiel();
			clear_textfield();
			txtAvailability.setText("yes");

			updateCar.setDisable(true);
			btnSearchcar.setDisable(true);
			editCar.setDisable(true);
			addCar.setDisable(true);
			removeCar.setDisable(true);

			saveCar.setDisable(false);
			cancelCar.setDisable(false);

			System.out.println("add");
		} else if (event.getSource() == updateCar) {

			Car car = new Car();

			car.setCarId(txtCarid.getText().trim());
			car.setModel(txtModel.getText().trim());
			car.setNoOfSeat(txtNoofseates.getText().trim());
			car.setRentPricePerDay(txtRentprice.getText().trim());
			car.setAvailable(txtAvailability.getText().trim());
			carImp.updateCar(car);
			JOptionPane.showMessageDialog(null, "An Car successfuly Updated!");

			car = null;

			cancelCar.setDisable(false);
			btnSearchcar.setDisable(false);
			editCar.setDisable(false);
			addCar.setDisable(false);

			removeCar.setDisable(true);
			saveCar.setDisable(true);
			updateCar.setDisable(true);

			System.out.println("update");
		} else if (event.getSource() == removeCar) {

			Car car = new Car();
			car = carImp.getCarById(txtCarid.getText().trim());

			carImp.deleteCar(car);

			cancelCar.setDisable(false);
			btnSearchcar.setDisable(false);
			editCar.setDisable(true);
			addCar.setDisable(false);

			removeCar.setDisable(true);
			saveCar.setDisable(true);
			updateCar.setDisable(true);

			clear_textfield();
			lock_textfiel();
			JOptionPane.showMessageDialog(null, "An Car successfuly Removed!");
			System.out.println("remove");
		} else if (event.getSource() == saveCar) {

			Car car = new Car();

			car.setCarId(txtCarid.getText().trim());
			car.setModel(txtModel.getText().trim());
			car.setNoOfSeat(txtNoofseates.getText().trim());
			car.setRentPricePerDay(txtRentprice.getText().trim());
			car.setAvailable(txtAvailability.getText().trim());

			carImp.saveCar(car);
			car = null;

			clear_textfield();

			addCar.setDisable(false);
			removeCar.setDisable(true);
			saveCar.setDisable(true);
			btnSearchcar.setDisable(false);
			editCar.setDisable(true);
			updateCar.setDisable(true);
			cancelCar.setDisable(true);

			JOptionPane.showMessageDialog(null, "new Car successfuly added!");
			System.out.println("save");
		} else if (event.getSource() == cancelCar) {

			addCar.setDisable(false);
			removeCar.setDisable(true);
			saveCar.setDisable(true);
			btnSearchcar.setDisable(false);
			editCar.setDisable(true);
			updateCar.setDisable(true);
			cancelCar.setDisable(true);

			clear_textfield();
			lock_textfiel();
			System.out.println("cancel");

		} else if (event.getSource() == editCar) {

			addCar.setDisable(true);
			removeCar.setDisable(true);
			saveCar.setDisable(true);
			btnSearchcar.setDisable(false);
			editCar.setDisable(true);
			updateCar.setDisable(false);
			cancelCar.setDisable(false);

			unlock_textfiel();

			System.out.println("Edit");

		}

		else if (event.getSource() == btnSearchcar) {

			Car car;
			car = carImp.getCarById(txtSearchcarid.getText().trim());
			if (car.getCarId() == null) {
				JOptionPane.showMessageDialog(null, "Car is not found, pls! check the Car id");

			}
			// System.out.println("Car"+car.getCarId());

			txtCarid.setText(car.getCarId());
			txtModel.setText(car.getModel());
			txtNoofseates.setText(car.getNoOfSeat());
			txtRentprice.setText(car.getRentPricePerDay());
			txtAvailability.setText(car.getIsAvailable());

			lock_textfiel();

			cancelCar.setDisable(true);
			updateCar.setDisable(true);

			btnSearchcar.setDisable(false);
			editCar.setDisable(false);
			addCar.setDisable(false);
			removeCar.setDisable(false);
			saveCar.setDisable(true);

			System.out.println("Search");
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addCar.setDisable(false);
		removeCar.setDisable(true);
		saveCar.setDisable(true);
		btnSearchcar.setDisable(false);
		editCar.setDisable(true);
		updateCar.setDisable(true);
		cancelCar.setDisable(true);

	}

}
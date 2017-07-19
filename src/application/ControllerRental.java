package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TooManyListenersException;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import EntityClass.Car;
import EntityClass.Customer;
import EntityClass.Rent;
import business.CarImp;
import business.CustomerImp;
import business.RentImp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerRental implements Initializable {
	String activeEmpID = application.Controller.session;

	public void unlock_textfiel() {

		txtRentalid.setEditable(true);
		dpRentalDate.setEditable(true);
		dpReturnDate.setEditable(true);
		txtEmpid.setEditable(false);
	}

	public void lock_textfiel() {

		txtRentalid.setEditable(false);
		dpRentalDate.setEditable(false);
		dpReturnDate.setEditable(false);
		comboRstatus.setEditable(false);
		comboCar.setEditable(false);
		comboCus.setEditable(false);
		txtEmpid.setEditable(false);
		// txtSearchrentid.setDisable(false);

	}

	public void clear_textfield() {
		txtRentalid.clear();
		dpRentalDate.setValue(null);
		dpReturnDate.setValue(null);
		comboRstatus.setValue("");
		comboCar.setValue("");
		comboCus.setValue("");

		txtSearchrentid.clear();

		txtEmpid.clear();

	}

	public void comboCarlist() {

		
	//carid for cmbobox using stream------------------------
		CarImp carImp = new CarImp();
		List<Car> cartoberent = new ArrayList<Car>();
		cartoberent = carImp.getAllCar();
		List<String> carIds = cartoberent.stream().filter(car -> car.isAvailable()).map(car -> car.getCarId())
				.collect(Collectors.toList());

		ObservableList<String> data2 = FXCollections.observableArrayList();

		for (String id : carIds) {
			data2.add(id);

		}
		comboCar.setItems(null);
		comboCar.setItems(data2);

	}

	public void giridshow() {
		RentImp myrent = new RentImp();
		final ObservableList<Rent> data = FXCollections.observableArrayList(myrent.getAllRents());

		mytableview.refresh();
		mytableview.setItems(data);
		mytableview.setEditable(true);

		System.out.println("rent list" + data.size() + data.get(0).getCarId());
	}

	@FXML
	private TextField txtRentalid;
	@FXML
	private DatePicker dpRentalDate;
	@FXML
	private DatePicker dpReturnDate;
	@FXML
	private ComboBox comboCus;
	@FXML
	private ComboBox comboCar;
	@FXML
	private ComboBox comboRstatus;

	@FXML
	private TextField txtEmpid;
	@FXML
	private TextField txtSearchrentid;

	@FXML
	private Button addRent;
	@FXML
	private Button updateRent;
	@FXML
	private Button removeRent;
	@FXML
	private Button saveRent;
	@FXML
	private Button editRent;
	@FXML
	private Button cancelRent;
	@FXML
	private Button btnSearchRent;
	@FXML
	private TableView mytableview;
	@FXML
	private Button btnShowall;

	RentImp rentImp = new RentImp();

	public void handelRent(ActionEvent event) {

		if (event.getSource() == addRent) {
			unlock_textfiel();
			clear_textfield();

			txtEmpid.setText(Controller.session);
			// txtEmpid.setEditable(false);

			updateRent.setDisable(true);
			btnSearchRent.setDisable(true);
			editRent.setDisable(true);
			addRent.setDisable(true);
			removeRent.setDisable(true);

			saveRent.setDisable(false);
			cancelRent.setDisable(false);

			System.out.println("add");

		} else if (event.getSource() == updateRent) {

			// comboCarlist();

			txtEmpid.setText(Controller.session);
			// txtEmpid.setEditable(false);
			Rent rent = new Rent();

			rent.setRentId(txtRentalid.getText().trim());
			rent.setRentDate(dpRentalDate.getValue().toString().trim());
			rent.setReturnDate(dpReturnDate.getValue().toString().trim());
			rent.setIsReturned(comboRstatus.getValue().toString().trim());

			rent.setCarId(comboCar.getValue().toString().trim());
			rent.setCustId(comboCus.getValue().toString().trim());
			rent.setEmpId(activeEmpID);
			// rent.setRentId(txtSearchrentid.getText().trim());

			rentImp.updateRent(rent);

			// update the car availability ....

			CarImp carimp = new CarImp();
			Car mycar = carimp.getCarById(comboCar.getValue().toString().trim());
			if (rent.getIsReturned().equals("Return"))
				mycar.setIsAvailable("yes");
			else
				mycar.setIsAvailable("no");
			carimp.updateCar(mycar);

			JOptionPane.showMessageDialog(null, "An Rent successfuly Updated!");

			rent = null;

			cancelRent.setDisable(false);
			btnSearchRent.setDisable(false);
			editRent.setDisable(false);
			addRent.setDisable(false);

			removeRent.setDisable(true);
			saveRent.setDisable(true);
			updateRent.setDisable(true);

			giridshow();
			comboCarlist();
			System.out.println("update");
		}

		else if (event.getSource() == removeRent) {

			Rent rent = new Rent();
			rent = rentImp.getRentById(txtRentalid.getText().trim());

			rentImp.deleteRent(rent.getRentId());

			cancelRent.setDisable(false);
			btnSearchRent.setDisable(false);
			editRent.setDisable(true);
			addRent.setDisable(false);

			removeRent.setDisable(true);
			saveRent.setDisable(true);
			updateRent.setDisable(true);

			clear_textfield();
			lock_textfiel();
			giridshow();
			JOptionPane.showMessageDialog(null, "An Rent successfuly Removed!");
			System.out.println("remove");
		} else if (event.getSource() == saveRent) {

			CarImp carimp = new CarImp();
			Car mycar = carimp.getCarById(comboCar.getValue().toString().trim());
			mycar.setIsAvailable("no");
			carimp.updateCar(mycar);

			Rent rent = new Rent();

			rent.setRentId(txtRentalid.getText().trim());
			rent.setRentDate(dpRentalDate.getValue().toString().trim());
			rent.setReturnDate(dpReturnDate.getValue().toString().trim());
			rent.setIsReturned(comboRstatus.getValue().toString().trim());
			rent.setCarId(comboCar.getValue().toString().trim());
			rent.setCustId(comboCus.getValue().toString().trim());
			rent.setEmpId(activeEmpID);
			// rent.setRentId(txtSearchrentid.getText().trim());

			rentImp.saveRent(rent);
			rent = null;

			clear_textfield();

			addRent.setDisable(false);
			removeRent.setDisable(true);
			saveRent.setDisable(true);
			btnSearchRent.setDisable(false);
			editRent.setDisable(true);
			updateRent.setDisable(true);
			cancelRent.setDisable(true);

			comboCarlist();
			giridshow();

			JOptionPane.showMessageDialog(null, "new Rent successfuly added!");
			System.out.println("save");

		} else if (event.getSource() == cancelRent) {
			addRent.setDisable(false);
			removeRent.setDisable(true);
			saveRent.setDisable(true);
			btnSearchRent.setDisable(false);
			editRent.setDisable(true);
			updateRent.setDisable(true);
			cancelRent.setDisable(true);

			lock_textfiel();
			clear_textfield();
			System.out.println("cancel");

		} else if (event.getSource() == editRent) {

			addRent.setDisable(true);
			removeRent.setDisable(true);
			saveRent.setDisable(true);
			btnSearchRent.setDisable(false);
			editRent.setDisable(true);
			updateRent.setDisable(false);
			cancelRent.setDisable(false);

			unlock_textfiel();

			System.out.println("Edit");

			txtRentalid.setEditable(false);

		}

		else if (event.getSource() == btnSearchRent) {

			Rent rent;
			rent = rentImp.getRentById(txtSearchrentid.getText().trim());

			if (rent.getRentId() == null) {
				JOptionPane.showMessageDialog(null, "Rent is not found, pls! check the Rent id");

			}

			txtRentalid.setText(rent.getRentId());
			// dpdob.setValue(LocalDate.parse(emp.getDob()));
			dpRentalDate.setValue(LocalDate.parse(rent.getRentDate()));
			dpReturnDate.setValue(LocalDate.parse(rent.getReturnDate()));
			comboRstatus.setValue(rent.getIsReturned());
			comboCar.setValue(rent.getCarId());
			comboCus.setValue(rent.getCustId());
			txtEmpid.setText(rent.getEmpId());
			// txtSearchrentid.setText(rent.get.getZip());

			lock_textfiel();

			cancelRent.setDisable(true);
			updateRent.setDisable(true);

			btnSearchRent.setDisable(false);
			editRent.setDisable(false);
			addRent.setDisable(false);
			removeRent.setDisable(false);
			saveRent.setDisable(true);

			String se = application.Controller.session;
			System.out.println("Search  " + se);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		lock_textfiel();
		clear_textfield();
		/////////////////////////////////////

		TableColumn column1 = new TableColumn("empid");
		column1.setCellValueFactory(new PropertyValueFactory<>("empId"));

		TableColumn column2 = new TableColumn("custid");
		column2.setCellValueFactory(new PropertyValueFactory<>("custId"));

		TableColumn column3 = new TableColumn("carid");
		column3.setCellValueFactory(new PropertyValueFactory<>("carId"));

		TableColumn column4 = new TableColumn("rentdate");
		column4.setCellValueFactory(new PropertyValueFactory<>("rentDate"));

		TableColumn column5 = new TableColumn("returndate");
		column5.setCellValueFactory(new PropertyValueFactory<>("returnDate"));

		TableColumn column6 = new TableColumn("Status");
		column6.setCellValueFactory(new PropertyValueFactory<>("isReturned"));

		TableColumn column7 = new TableColumn("rentid");
		column7.setCellValueFactory(new PropertyValueFactory<>("rentId"));

		mytableview.getColumns().remove(0);
		mytableview.getColumns().remove(0);

		mytableview.getColumns().addAll(column7, column1, column2, column3, column4, column5, column6);

		///////////////////////////////////

		cancelRent.setDisable(true);
		updateRent.setDisable(true);

		btnSearchRent.setDisable(false);
		editRent.setDisable(true);
		addRent.setDisable(false);
		removeRent.setDisable(true);
		saveRent.setDisable(true);

		/////////////////////////////////////////////////////////////////////
		comboCarlist();

// ---------------------------------customer comboBox using stream:
		CustomerImp cusImp = new CustomerImp();
		List<Customer> customers = new ArrayList<Customer>();
		customers = cusImp.getAllCustomer();
		List<String> cusIds = customers.stream().map(cus -> cus.getCusId()).collect(Collectors.toList());

		ObservableList<String> data3 = FXCollections.observableArrayList();

		for (String idCus : cusIds) {
			data3.add(idCus);

		}
		comboCus.setItems(data3);

		// --------------------------------return status comboBox
		ObservableList<String> options = FXCollections.observableArrayList(

				"Not-Return", "Return");

		comboRstatus.setItems(options);
		comboRstatus.getSelectionModel().selectFirst();

		/////////////////////////////////////////////////////

		giridshow();

	}

}

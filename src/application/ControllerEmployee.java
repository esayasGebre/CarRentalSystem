package application;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import EntityClass.Employee;
import business.EmployeImp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;

public class ControllerEmployee implements Initializable {
	// main menu
	@FXML
	private Button btnEmployee;
	public Button btnCar;
	public Button btnCustomer;
	public Button btnRental;
	public Button lbllogout;
	@FXML
	private ComboBox comboRole;

	public DatePicker dpdob;
	// employee management
	public Button add;
	public Button update;
	public Button remove;
	public Button save;
	public Button cancel;

	public Button login;
	public Button exit;
	public Button btnexit;

	// public ComboBox cmbrole;

	@FXML // need to put this in since it is private
	private TextField txtEmpid;
	@FXML
	private TextField txtFname;
	@FXML
	private TextField txtLname;
	// @FXML
	// private TextField txtdob;
	@FXML
	private TextField txtStreet;

	@FXML
	private TextField txtState;
	@FXML
	private TextField txtZipno;
	@FXML
	private TextField txtHousno;

	@FXML
	private TextField txtPassword;
	@FXML
	private TextField txtUsername;
	// @FXML
	// private TextField txtRole;
	@FXML
	private TextField txtCity;
	@FXML
	private Button addEmp;
	@FXML
	private Button updateEmp;
	@FXML
	private Button removeEmp;
	@FXML
	private Button saveEmp;
	@FXML
	private Button editEmp;
	@FXML
	private Button cancelEmp;

	@FXML
	private TextField txtSearchid;
	@FXML
	private Button btnSearchemp;

	EmployeImp emplImp = new EmployeImp();

	public void unlock_textfiel() {

		txtEmpid.setEditable(true);
		//comboRole.setEditable(true);
		txtFname.setEditable(true);
		txtLname.setEditable(true);
		dpdob.setEditable(true);
		txtCity.setEditable(true);
		txtStreet.setEditable(true);
		txtState.setEditable(true);
		txtZipno.setEditable(true);
		txtHousno.setEditable(true);
		txtUsername.setEditable(true);
		txtPassword.setEditable(true);
	}

	public void lock_textfiel() {

		txtEmpid.setEditable(false);
		//comboRole.setEditable(false);
		txtFname.setEditable(false);
		txtLname.setEditable(false);
		dpdob.setEditable(false);
		txtCity.setEditable(false);
		txtStreet.setEditable(false);
		txtState.setEditable(false);
		txtZipno.setEditable(false);
		txtHousno.setEditable(false);
		txtUsername.setEditable(false);
		txtPassword.setEditable(false);
	}

	public void clear_textfield() {
		txtEmpid.clear();
		comboRole.setValue("");
		txtFname.clear();
		txtLname.clear();

		dpdob.setValue(null);

		txtCity.clear();
		txtStreet.clear();
		txtState.clear();
		txtZipno.clear();
		txtHousno.clear();
		txtUsername.clear();
		txtPassword.clear();
	}

	public void handleEmployee(ActionEvent event) {

		if (event.getSource() == addEmp) {
			unlock_textfiel();
			clear_textfield();

			updateEmp.setDisable(true);
			btnSearchemp.setDisable(true);
			editEmp.setDisable(true);
			addEmp.setDisable(true);
			removeEmp.setDisable(true);

			saveEmp.setDisable(false);
			cancelEmp.setDisable(false);

			System.out.println("add");
		} else if (event.getSource() == updateEmp) {

			Employee emp = new Employee();

			emp.setEmpId(txtEmpid.getText().trim());
			emp.setRole(comboRole.getValue().toString().trim());
			emp.setFirstName(txtFname.getText().trim());
			emp.setLastName(txtLname.getText().trim());
			emp.setDob(dpdob.getValue().toString().trim());

			emp.setCity(txtCity.getText().trim());
			emp.setStreet(txtStreet.getText().trim());
			emp.setState(txtState.getText().trim());
			emp.setZip(txtZipno.getText().trim());
			emp.setHouseNo(txtHousno.getText().trim());

			emp.setUserName(txtUsername.getText().trim());
			emp.setPassword(txtPassword.getText().trim());

			emplImp.updateEmployee(emp);
			JOptionPane.showMessageDialog(null, "An Employee successfuly Updated!");

			emp = null;

			cancelEmp.setDisable(false);
			btnSearchemp.setDisable(false);
			editEmp.setDisable(false);
			addEmp.setDisable(false);

			removeEmp.setDisable(true);
			saveEmp.setDisable(true);
			updateEmp.setDisable(true);

			System.out.println("update");
		} else if (event.getSource() == removeEmp) {

			Employee emp = new Employee();
			emp = emplImp.getEmployeeById(txtEmpid.getText().trim());

			emplImp.deleteEmployee(emp);

			cancelEmp.setDisable(false);
			btnSearchemp.setDisable(false);
			editEmp.setDisable(true);
			addEmp.setDisable(false);

			removeEmp.setDisable(true);
			saveEmp.setDisable(true);
			updateEmp.setDisable(true);

			clear_textfield();
			lock_textfiel();
			JOptionPane.showMessageDialog(null, "An Employee successfuly Removed!");
			System.out.println("remove");
		} else if (event.getSource() == saveEmp) {

			Employee emp = new Employee();

			emp.setEmpId(txtEmpid.getText().trim());
			emp.setRole(comboRole.getValue().toString().trim());
			emp.setFirstName(txtFname.getText().trim());
			emp.setLastName(txtLname.getText().trim());

			emp.setDob(dpdob.getValue().toString().trim());

			emp.setCity(txtCity.getText().trim());
			emp.setStreet(txtStreet.getText().trim());
			emp.setState(txtState.getText().trim());
			emp.setZip(txtZipno.getText().trim());
			emp.setHouseNo(txtHousno.getText().trim());

			emp.setUserName(txtUsername.getText().trim());
			emp.setPassword(txtPassword.getText().trim());

			emplImp.saveEmployee(emp);
			emp = null;

			clear_textfield();

			addEmp.setDisable(false);
			removeEmp.setDisable(true);
			saveEmp.setDisable(true);
			btnSearchemp.setDisable(false);
			editEmp.setDisable(true);
			updateEmp.setDisable(true);
			cancelEmp.setDisable(true);

			JOptionPane.showMessageDialog(null, "new Employee successfuly added!");
			System.out.println("save");
		} else if (event.getSource() == cancelEmp) {
			addEmp.setDisable(false);
			removeEmp.setDisable(true);
			saveEmp.setDisable(true);
			btnSearchemp.setDisable(false);
			editEmp.setDisable(true);
			updateEmp.setDisable(true);
			cancelEmp.setDisable(true);

			lock_textfiel();
			System.out.println("cancel");

		} else if (event.getSource() == editEmp) {

			addEmp.setDisable(true);
			removeEmp.setDisable(true);
			saveEmp.setDisable(true);
			btnSearchemp.setDisable(false);
			editEmp.setDisable(true);
			updateEmp.setDisable(false);
			cancelEmp.setDisable(false);

			unlock_textfiel();

			System.out.println("Edit");

		}

		else if (event.getSource() == btnSearchemp) {

			Employee emp;
			emp = emplImp.getEmployeeById(txtSearchid.getText().trim());

			if (emp.getEmpId() == null) {
				JOptionPane.showMessageDialog(null, "Employee is not found, pls! check the Employee id");

			}

			txtEmpid.setText(emp.getEmpId());
			comboRole.setValue(emp.getRole());
			txtFname.setText(emp.getFirstName());
			txtLname.setText(emp.getLastName());
			dpdob.setValue(LocalDate.parse(emp.getDob()));
			txtCity.setText(emp.getCity());
			txtStreet.setText(emp.getStreet());
			txtState.setText(emp.getState());
			txtZipno.setText(emp.getZip());
			txtHousno.setText(emp.getHouseNo());
			txtUsername.setText(emp.getUserName());
			txtPassword.setText(emp.getPassword());

			lock_textfiel();

			cancelEmp.setDisable(true);
			updateEmp.setDisable(true);

			btnSearchemp.setDisable(false);
			editEmp.setDisable(false);
			addEmp.setDisable(false);
			removeEmp.setDisable(false);
			saveEmp.setDisable(true);

			System.out.println("Search");
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// comboRole= new ComboBox();
		ObservableList<String> options = FXCollections.observableArrayList(

				"staff", "manager");

		comboRole.setItems(options);
		comboRole.getSelectionModel().selectFirst();

		cancelEmp.setDisable(true);
		updateEmp.setDisable(true);

		btnSearchemp.setDisable(false);
		editEmp.setDisable(true);
		addEmp.setDisable(false);
		removeEmp.setDisable(true);
		saveEmp.setDisable(true);

		// Date now = new Date();
		// dpdob.setValue( LocalDateTime);
	}

}

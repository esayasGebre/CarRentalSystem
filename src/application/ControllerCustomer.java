package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import EntityClass.Customer;
import business.CustomerImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ControllerCustomer implements Initializable {

	public void unlock_textfiel() {

		txtempid.setEditable(false);
		txtCustomerid.setEditable(true);
		txtFname.setEditable(true);
		txtLname.setEditable(true);
		dpdob.setEditable(true);
		txtCity.setEditable(true);
		txtStreet.setEditable(true);
		txtState.setEditable(true);
		txtZipno.setEditable(true);
		txtHousno.setEditable(true);
	}

	public void lock_textfiel() {
		txtempid.setEditable(false);
		txtCustomerid.setEditable(false);
		txtFname.setEditable(false);
		txtLname.setEditable(false);
		dpdob.setEditable(false);
		txtCity.setEditable(false);
		txtStreet.setEditable(false);
		txtState.setEditable(false);
		txtZipno.setEditable(false);
		txtHousno.setEditable(false);
	}

	public void clear_textfield() {
		txtempid.setText(Controller.session);
		txtCustomerid.clear();
		txtFname.clear();
		txtLname.clear();
		dpdob.setValue(null);
		txtCity.clear();
		txtStreet.clear();
		txtState.clear();
		txtZipno.clear();
		txtHousno.clear();
	}

	@FXML // need to put this in since it is private
	private TextField txtCustomerid;
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
	private TextField txtSearchid;
	@FXML
	private TextField txtempid;
	@FXML
	private DatePicker dpdob;

	@FXML
	private TextField txtCity;
	@FXML
	private Button addCus;
	@FXML
	private Button updateCus;
	@FXML
	private Button removeCus;
	@FXML
	private Button saveCus;
	@FXML
	private Button editCus;
	@FXML
	private Button cancelCus;
	@FXML
	private Button btnSearchCus;

	CustomerImp custImp = new CustomerImp();

	public void handleCustomer(ActionEvent event) {

		if (event.getSource() == addCus) {
			unlock_textfiel();
			clear_textfield();

			updateCus.setDisable(true);
			btnSearchCus.setDisable(true);
			editCus.setDisable(true);
			addCus.setDisable(true);
			removeCus.setDisable(true);

			saveCus.setDisable(false);
			cancelCus.setDisable(false);

			System.out.println("add");
		} else if (event.getSource() == updateCus) {

			Customer cus = new Customer();
			cus.setEmpid(txtempid.getText().trim());
			cus.setCusId(txtCustomerid.getText().trim());
			cus.setFirstName(txtFname.getText().trim());
			cus.setLastName(txtLname.getText().trim());
			cus.setDob(dpdob.getValue().toString().trim());
			cus.setCity(txtCity.getText().trim());
			cus.setStreet(txtStreet.getText().trim());
			cus.setState(txtState.getText().trim());
			cus.setZip(txtZipno.getText().trim());
			cus.setHouseNo(txtHousno.getText().trim());

			custImp.updateCustomer(cus);
			JOptionPane.showMessageDialog(null, "An Customer successfuly Updated!");

			cus = null;

			cancelCus.setDisable(false);
			btnSearchCus.setDisable(false);
			editCus.setDisable(false);
			addCus.setDisable(false);

			removeCus.setDisable(true);
			saveCus.setDisable(true);
			updateCus.setDisable(true);

			System.out.println("update");
		} else if (event.getSource() == removeCus) {

			Customer cus = new Customer();
			cus = custImp.getCustomerById(txtCustomerid.getText().trim());

			custImp.deleteCustomer(cus);

			cancelCus.setDisable(false);
			btnSearchCus.setDisable(false);
			editCus.setDisable(true);
			addCus.setDisable(false);

			removeCus.setDisable(true);
			saveCus.setDisable(true);
			updateCus.setDisable(true);

			clear_textfield();
			lock_textfiel();
			JOptionPane.showMessageDialog(null, "An Customer successfuly Removed!");
			System.out.println("remove");
		} else if (event.getSource() == saveCus) {

			Customer cus = new Customer();
			cus.setEmpid(txtempid.getText().trim());
			cus.setCusId(txtCustomerid.getText().trim());
			cus.setFirstName(txtFname.getText().trim());
			cus.setLastName(txtLname.getText().trim());
			cus.setDob(dpdob.getValue().toString().trim());
			cus.setCity(txtCity.getText().trim());
			cus.setStreet(txtStreet.getText().trim());
			cus.setState(txtState.getText().trim());
			cus.setZip(txtZipno.getText().trim());
			cus.setHouseNo(txtHousno.getText().trim());

			custImp.saveCustomer(cus);
			cus = null;

			clear_textfield();

			addCus.setDisable(false);
			removeCus.setDisable(true);
			saveCus.setDisable(true);
			btnSearchCus.setDisable(false);
			editCus.setDisable(true);
			updateCus.setDisable(true);
			cancelCus.setDisable(true);

			JOptionPane.showMessageDialog(null, "new Customer successfuly added!");
			System.out.println("save");
		} else if (event.getSource() == cancelCus) {
			addCus.setDisable(false);
			removeCus.setDisable(true);
			saveCus.setDisable(true);
			btnSearchCus.setDisable(false);
			editCus.setDisable(true);
			updateCus.setDisable(true);
			cancelCus.setDisable(true);

			clear_textfield();
			lock_textfiel();
			System.out.println("cancel");

		} else if (event.getSource() == editCus) {

			txtempid.setText(Controller.session);
			addCus.setDisable(true);
			removeCus.setDisable(true);
			saveCus.setDisable(true);
			btnSearchCus.setDisable(false);
			editCus.setDisable(true);
			updateCus.setDisable(false);
			cancelCus.setDisable(false);

			unlock_textfiel();

			System.out.println("Edit");

		}

		else if (event.getSource() == btnSearchCus) {

			Customer cus;
			cus = custImp.getCustomerById(txtSearchid.getText().trim());

			if (cus.getCusId() == null) {
				JOptionPane.showMessageDialog(null, "Customer is not found, pls! check the customer id");

			}

			txtCustomerid.setText(cus.getCusId());
			txtFname.setText(cus.getFirstName());
			txtLname.setText(cus.getLastName());

			txtempid.setText(cus.getEmpid());
			dpdob.setValue(LocalDate.parse(cus.getDob()));
			txtCity.setText(cus.getCity());
			txtStreet.setText(cus.getStreet());
			txtState.setText(cus.getState());
			txtZipno.setText(cus.getZip());
			txtHousno.setText(cus.getHouseNo());

			lock_textfiel();

			cancelCus.setDisable(true);
			updateCus.setDisable(true);

			btnSearchCus.setDisable(false);
			editCus.setDisable(false);
			addCus.setDisable(false);
			removeCus.setDisable(false);
			saveCus.setDisable(true);

			String se = application.Controller.session;
			System.out.println("Search  " + se);
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cancelCus.setDisable(true);
		updateCus.setDisable(true);

		btnSearchCus.setDisable(false);
		editCus.setDisable(true);
		addCus.setDisable(false);
		removeCus.setDisable(true);
		saveCus.setDisable(true);

	}

}

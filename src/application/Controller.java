package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import EntityClass.Employee;
import business.EmployeImp;

public class Controller implements Initializable {

	// login
	@FXML // need to put this in since it is private
	private TextField username;
	public PasswordField password;
	public Button logIn;
	public Label lstatus;
	public Button lbllogout;
	public Button login;
	public Button btnexit;

	static String session;
	public AnchorPane Mainmenu;

	public void login(ActionEvent ev1) throws Exception {

		EmployeImp emplo = new EmployeImp();
		Employee emp = new Employee();

		if (ev1.getSource() == login) {

			emp = emplo.getEmployeeByUserName(username.getText().trim());
			if (password.getText().trim().equals(emp.getPassword())) {

				if (emp.getRole().equals("manager")) {
					Stage mainmenuStage = new Stage();
					Parent root = FXMLLoader.load(getClass().getResource("/application/mainMenu.fxml"));
					Scene scene = new Scene(root);
					mainmenuStage.setScene(scene);
					mainmenuStage.setResizable(false);
					session = emp.getEmpId();
					mainmenuStage.setTitle("Main Menu-Manager");
					mainmenuStage.show();
					mainFormStage = mainmenuStage;
					Login.loginStage.close();
					if (afterLonout != null)
						afterLonout.close();
				} else {

					Stage mainmenuStage = new Stage();
					Parent root = FXMLLoader.load(getClass().getResource("/application/mainMenuEmp.fxml"));
					Scene scene = new Scene(root);
					mainmenuStage.setScene(scene);
					session = emp.getEmpId();
					mainmenuStage.setTitle("Main Menu-Employee");
					mainmenuStage.setResizable(false);
					mainmenuStage.show();
					mainFormStage = mainmenuStage;
					Login.loginStage.close();
					if (afterLonout != null)
						afterLonout.close();

					System.out.println("you are normal...");
				}

			} else
				lstatus.setText("Login Failed!");

		} else if (ev1.getSource() == btnexit) {
			Platform.exit();
		}
	}

	public static Stage mainFormStage;
	public static Stage afterLonout;

	public void logOut(ActionEvent ev1) throws Exception {
		Stage loginStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/logIn.fxml"));
		Scene scene = new Scene(root);
		loginStage.setScene(scene);
		loginStage.setTitle("Login");
		loginStage.setResizable(false);
		loginStage.show();
		afterLonout = loginStage;
		mainFormStage.close();
	}

	public void manageEmployee(ActionEvent ev11) throws Exception {

		Stage mainStage1 = new Stage();
		Parent root1 = FXMLLoader.load(getClass().getResource("/application/employeeManagement.fxml"));
		Scene scene1 = new Scene(root1);
		mainStage1.setScene(scene1);
		mainStage1.setTitle("Manage-Employee");
		// listOfRolesCombo();
		mainStage1.setResizable(false);
		mainStage1.show();
		// cmbrole.getItems().addAll("Manager","others");

	}

	public void manageCar(ActionEvent ev2) throws Exception {
		Stage mainStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/manageCar.fxml"));
		Scene scene = new Scene(root);
		mainStage.setScene(scene);
		mainStage.setTitle("Manage-Car");
		mainStage.setResizable(false);
		mainStage.show();
	}

	public void manageCustomer(ActionEvent ev3) throws Exception {
		Stage mainStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/manageCustomer.fxml"));
		Scene scene = new Scene(root);
		mainStage.setScene(scene);
		mainStage.setTitle("Manage-Coustomer");
		mainStage.setResizable(false);
		mainStage.show();
	}

	public void manageRental(ActionEvent ev4) throws Exception {
		Stage mainStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/manageRental.fxml"));
		Scene scene = new Scene(root);
		mainStage.setScene(scene);
		mainStage.setTitle("Manage-Rental");
		mainStage.setResizable(false);
		mainStage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}

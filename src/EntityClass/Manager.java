package EntityClass;

import business.EmployeImp;

public class Manager extends Employee{
EmployeImp emp;
	public void addEmployee(Employee emp1){
		emp = new EmployeImp();
		emp.saveEmployee(emp1);
	}
	
	public void updateEmployee(Employee emp1){
		emp = new EmployeImp();
		emp.updateEmployee(emp1);
	}
	public boolean deleteEmployee(Employee emp1){
		emp = new EmployeImp();
		return emp.deleteEmployee(emp1);
	}
	public Employee getEmployeeS(String empid){
		emp = new EmployeImp();
		return emp.getEmployeeById(empid);
	}
}

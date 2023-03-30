package Package;
public class Employee extends Person implements Payment{
    
String empId;
int startYear = ConstantValues.currentYear; 
double salary;

public Employee(String lname, String fname){
    super(lname, fname);
    this.empId = getEmployeeIdString() + getRandomId(2001, 3000);
   
}

public String getIdString() {
    return empId;
}

public int getStartYear() {
    return startYear;
}  


public void setstartYear(final int startYear){
    if(startYear<=ConstantValues.currentYear&& startYear > 2000){
        this.startYear = startYear;
    }
    }
    

public double getSalary() {
    return salary;
}


public void setSalary(double salary) {
    if(salary > 0.0){
        this.salary = salary;
    }
}

public double calculatePayment(){

    return 1.5*getSalary();     

}


String getEmployeeIdString(){

String temp = "OY_";

return temp;  
}




public String toString(){



   return "Employee id: "+ getIdString()+
   "\n"+"first name: "+getFirstName()+ "Last name: "+ getLastName()+
   "\n"+"Birthdate: "+ getBirthDate()+
   "\n"+ "Start Year: "+ getStartYear()+
   "\n"+ "Salary: "+ calculatePayment();


}
}

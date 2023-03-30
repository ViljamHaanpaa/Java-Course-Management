package Package;
import java.util.Random;
public abstract class  Person{
    
String firstName = ConstantValues.NO_NAME;
String lastName = ConstantValues.NO_NAME;
String birthDate = ConstantValues.NO_BIRTHDATE;


public Person(String lname, String fname){
setFirstName(fname); 
setLastName(lname);
}



//methodit//

public String getFirstName() {
    return firstName;
}


public void setFirstName(String firstName) {
    if(firstName != null)
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}
public void setLastName(String lastName) {
    this.lastName = lastName;
}
public String getBirthDate() {
    return birthDate;
}

public String setBirthDate(String personId) {
    
    PersonID person = new PersonID();
    if (person.setPersonId(personId) == "Ok") {
       this.birthDate = person.getBirthDate();
    }
   
    return "No change";
}
protected int getRandomId(final int min, final int max) {
    Random random = new Random();
    int randomNumber = random.nextInt((max - min) + 1) + min;
    return randomNumber;
}

public abstract String getIdString();




}
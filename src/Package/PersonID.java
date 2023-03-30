package Package;
public class PersonID{

String birthDate = ConstantValues.NO_BIRTHDATE;


String getBirthDate(){
    return birthDate;
} 


///////////ID///////////////


public String setPersonId(String personId) {
    if (personId == null) {
       return "invalid birthday!";
       
    }
    if (!checkPersonIDNumber(personId)) {
        System.out.println("idnumber");
        return "Invalid birthday!";
    }
    
   
    int dd = Integer.parseInt(personId.substring(0, 2));
    
    int mm = Integer.parseInt(personId.substring(2, 4));
    
    int year = Integer.parseInt(personId.substring(4, 6));
    
    char century = personId.charAt(6);
    
    
    switch (century) {
        case '+':
          year= year + 1800;
            break;
        case '-':
            year= year +1900;
            break;
        case 'A':
            year= year+ 2000;
            break;
        default:
            return "Invalid birthday!";
    }
    String temp = personId.substring(0, 7);
  

    
    if (!checkBirthdate(temp)) {
        

        return "Invalid birthday!";
    }

    if (!checkValidCharacter(personId)){
        System.out.println("Paska");
        return "invalid check mark";
    }
    
    
    this.birthDate = String.format("%02d.%02d.%d", dd, mm, year);
    
    
    return "Ok";
}





//////////////////////////////////////////////////////////

private boolean checkPersonIDNumber(final String id) {
    if (id.length() != 11) {
        return false;
    }
    char vuosi = id.charAt(6);

    if (vuosi != '+' && vuosi != '-' && vuosi != 'A') {
        return false;
    }

    return true;
}




private boolean checkBirthdate(final String date) {
    int pv, kk, v;
    if (date.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
        try{
        pv = Integer.parseInt(date.substring(0,2));
        kk = Integer.parseInt(date.substring(3,5));
        v = Integer.parseInt(date.substring(6,10));
    }
    catch(NumberFormatException kirjain){
    return false;
    }
    }

    
    else{
        try {
            pv = Integer.parseInt(date.substring(0,2));
            kk = Integer.parseInt(date.substring(2,4));
            v = Integer.parseInt(date.substring(4,6));
        }
         catch (NumberFormatException kirjain) {
            return false;
        }
}

   
    if (v < 0) {
        
        return false;
    }

    if (kk < 1 || kk > 12) {
        return false;
    }
 
    if (pv < 1 || pv > 31) {
        return false;
    }

   
    switch (kk) {
        case 2:
            if (pv > 29 || (pv == 29 && checkLeapYear(v)==false)) {
                return false;
            }
            break;
        case 4: 
        case 6: 
        case 9:
        case 11:
           if (pv > 30) {
                return false;
            }
            break;
    }


    return true;
}

///karkausvuosi/////
private boolean checkLeapYear(int year) {
    
    

    if (year % 4 == 0){
    if(year % 100 != 0 || year % 400 == 0) {
        return true;
    }
    }
        return false;
}

////////////////////
private boolean checkValidCharacter(final String personId) {
    if(personId.length() != 11){
        
        return false;
    }
    
    int checkValue = 0;
    String mahdtarkistusluvut = "0123456789ABCDEFHJKLMNPRSTUVWXY";
    String alku = personId.substring(0, 6);
    String loppu = personId.substring(7, 10);
    char tarkistusluku = personId.charAt(10);
    checkValue = Integer.parseInt(alku + loppu) % 31;
    if (Character.isUpperCase(tarkistusluku) && tarkistusluku == mahdtarkistusluvut.charAt(checkValue)) {
        return true;
    }   
    return false;
}
}
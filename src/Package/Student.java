package Package;
import java.util.Random;

public class Student {
   

    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private int id = 1;
    private int startYear = ConstantValues.currentYear;
    private int graduationYear;
    private int degreeCount = 3;
    private Degree[] degrees;
    private String birthDate = ConstantValues.NO_BIRTHDATE;
private double bachelorCredits;
private double masterCredits;
private String TitleOfMastersThesis = ConstantValues.NO_TITLE;
private String TitleOfBachelorThesis = ConstantValues.NO_TITLE;


public Student(){

    
    this.startYear = ConstantValues.currentYear;
    this.degrees= new Degree[3];
    for (int i = 0; i < degreeCount; i++) {
        this.degrees[i] = new Degree();
    }
    id = getRandomId();
                }

public Student(String lname, String fname){
setFirstName(fname);
setLastName(lname);
}

String getFirstName(){
return firstName;
}
public void setFirstName(String firstName) {
    
    this.firstName = firstName;

}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    if(lastName != null){
    this.lastName = lastName;
}
}


public void setId(final int id){
    if (id <= ConstantValues.MAX_ID){
        if (id>=ConstantValues.MIN_ID){
            this.id = id;
        }
    }
}

public int getId(){
    return id;
}

private int getRandomId() {
    Random random = new Random();
    int randomNumber = random.nextInt(100) + 1;
    return randomNumber;
}




public void setstartYear(final int startYear){
    if(startYear<=ConstantValues.currentYear&& startYear > 2000){
        this.startYear = startYear;
    }
    }
    

int getstartYear(){
    return startYear;
}


public int getGraduationYear(){
    return graduationYear;
}

public String setGraduationYear(final int graduationYear){
    if(graduationYear <= 2000 || graduationYear > (ConstantValues.currentYear +1)){
        return "Check graduation year";
    } 
    if(graduationYear< startYear){
        return "Check graduation year";
    }
    if(!canGraduate() ){
    return  "Check amount of required credits";       
}
this.graduationYear = graduationYear;
return "Ok";

}

public void setDegreeTitle(final int i, String dname){
if(i >= 0 && i < degreeCount && dname !=null){ 
degrees[i].setDegreeTitle(dname);
}
}


public boolean addCourse(final int i,StudentCourse course){
    if(i >= 0 && i < degreeCount && course !=null){
        return degrees[i].addStudentCourse(course);
}
return false;
}


int addCourses(final int i,StudentCourse[] courses){
    int num = 0;
    
    
        for (StudentCourse course : courses){
            if(course != null){
                if(degrees[i].addStudentCourse(course)){
                   num++;
                }
            }
        }
    

return num;
}


public void printCourses(){
    System.out.println("Courses");
    for (int i = 0; i < degreeCount; i++) {
        for (StudentCourse course : degrees[i].getCourses()) {
            if (course != null) {
                System.out.println(course.toString());
            }
        }
    }
}

public void printDegrees(){
    
for(Degree degree : degrees){

    
if(degree != null) {
    
    if(degree.getDegreeTitle() != ConstantValues.NO_TITLE){
    
    System.out.println("\nDegree [Title: " + degree.getDegreeTitle() + " (courses: "+degree.getcount()+")");
    System.out.println("Thesis title: " +degree.getTitleOfThesis());
    System.out.println(degree.toString()+"\n");
    }
}
}
}



public void setTitleOfThesis(final int i, String title){
if(i >= 0 && i < degreeCount && title !=null){
    degrees[i].setTitleOfThesis(title);
    
}
}
public String getBirthDate(){
    
    
    return birthDate;}


public String setBirthDate(String birthDate) {

    PersonID personID = new PersonID();
    if("Ok".equals(personID.setPersonId(birthDate))){
       this.birthDate =personID.getBirthDate();
        return this.birthDate;
    }
return "No change";
}


private boolean canGraduate(){
    if(getBachelorCredits() < ConstantValues.BACHELOR_CREDITS){
        return false;
    }
    if(getMasterCredits() < ConstantValues.MASTER_CREDITS){
        return false;
    }
    if(TitleOfMastersThesis == ConstantValues.NO_TITLE){
        return false;
    }
    if(TitleOfBachelorThesis == ConstantValues.NO_TITLE){
        return false;
    }
    return true;
}


    private boolean hasGraduated(){
        if(canGraduate()== true){
        if(graduationYear != 0){
        return true; }
        }
        return false;
        }

        public int getStudyYears(){

            if(!hasGraduated()){
            
            return ConstantValues.currentYear -startYear;

            }
             return  graduationYear - startYear;
            }


            public String status(){
   
                if(canGraduate()==true){
            
                    if(this.graduationYear != 0){
                        return "The student has graduated in "+graduationYear;
                    }   
                }
                return "The student has not graduated, yet";
            }

            public double getBachelorCredits() {
                bachelorCredits = 0;
                
                    for (StudentCourse studentcourse : degrees[0].getCourses()) {
                        if (studentcourse != null) {
                            if (degrees[0].Haspassed(studentcourse)) {
                            Course course = studentcourse.getCourse();
                            bachelorCredits+=course.getCredits();
                        
                        }
                    }  
                    }
                    return bachelorCredits;
                }
               
            public double getMasterCredits() {
                masterCredits = 0;
            
                for (StudentCourse studentcourse : degrees[1].getCourses()) {
                    if (studentcourse != null) {
                        if (degrees[1].Haspassed(studentcourse)) {
                            Course course = studentcourse.getCourse();
                            masterCredits += course.getCredits();
                        }
                    }
                }
                return masterCredits;
            }
           
          

public double getTotalcredits(){
    double totalcredits = 0;

    totalcredits = getMasterCredits() + getBachelorCredits();

    return totalcredits;
}

public String missingmastercredits(){
   double missingcredits= 0;
   if(getMasterCredits() < ConstantValues.MASTER_CREDITS){
    missingcredits = ConstantValues.MASTER_CREDITS - getMasterCredits();
        return "Missing masters's credits "+missingcredits+" ("+getMasterCredits()+"/"+ConstantValues.MASTER_CREDITS+")";
    }
    return "Total master credits completed ("+getMasterCredits()+"/"+ConstantValues.MASTER_CREDITS+")";
}
public String missingbachelorscredits(){
    double missingcredits= 0;
    if(getBachelorCredits() < ConstantValues.BACHELOR_CREDITS){
     missingcredits = ConstantValues.BACHELOR_CREDITS - getBachelorCredits();
         return "Missing bachelor's credits "+missingcredits+" ("+bachelorCredits+"/"+ConstantValues.BACHELOR_CREDITS+")";
     }
     return "Total bachelor credits completed ("+bachelorCredits+"/"+ConstantValues.BACHELOR_CREDITS+")";
 }






            public String toString() {

                return 
                "Student ID: " + this.id+
                "\nFirstName: " + this.firstName + ", Lastname: "+this.lastName+
                "\nDate of birth "+birthDate+
                "\nStatus: " + status()+
                "\nStartYear:" + this.startYear + " (Studies have lasted for "+ getStudyYears()  +" years)"+
                "\nTotal credits "+getTotalcredits()+
                "\nNumber of Bachelor credits: " + getBachelorCredits() +
                "\n"+missingbachelorscredits()+
                "\nTitle of BSc Thesis: " + degrees[0].titleOfThesis+
                "\nNumber of Master credits: "  + getMasterCredits()+
                "\n"+missingmastercredits()+
                "\nMasters thesis title: " + degrees[1].titleOfThesis+
                
                "\n\n";
            


             

            }

        }

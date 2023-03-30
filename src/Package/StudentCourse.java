package Package;
public class StudentCourse {
    

Course course;

int gradeNum;

int yearCompleted =0;

boolean numericGrade;

char courseBase;

int period;

String degreeTitle = ConstantValues.NO_TITLE;

char gradechar = 'o';


/////Construktorit
StudentCourse(){

}
StudentCourse(Course course, final int gradeNum, final int yearCompleted ){

    setCourse(course);
    setGrade(gradeNum);
    setYear(yearCompleted);
    
}

///////////////////

public Course getCourse() {
    return course;
}

public void setDegreeTitle(String degreeTitle) {
    if(degreeTitle != null){
    this.degreeTitle = degreeTitle;
}

}

public void setCourse(Course course) {
    this.course = course;
}

public int getGradeNum() {
    return gradeNum;
}

public String getgradeString(){

   
    if(gradeNum !=0){
        return  String.valueOf(gradeNum);
    }

    if(gradechar != 'o'){
return String.valueOf(gradechar);
    }

    return "Not graded";
}


public char getCourseBase() {
    return courseBase;
}

public int getPeriod() {
    return this.period;
}


protected void setGrade(int gradeNum){
   

if(checkGradeValidity(gradeNum)){
this.gradeNum = gradeNum;
    }


if(checkGradeValidity(gradeNum)){
this.gradeNum = (char) gradeNum;
}


if(yearCompleted == 0){
yearCompleted = ConstantValues.currentYear;
}
}


private boolean checkGradeValidity(final int gradeNum) {
    if (course.isNumericGrade()) {        return gradeNum >= 0 && gradeNum <= 5;
    } else {


        return (gradeNum == 65 || gradeNum == 97 || gradeNum == 102 || gradeNum == 70);
    }
}

public boolean isPassed(){

if(gradeNum == 0 || gradeNum == 'F'){
    return false;
}
return true;
}

int getYear(){

    return yearCompleted;
}

public boolean isNumericGrade() {
    return numericGrade;
}


void setYear(final int year){
if(year>2000 && year <= ConstantValues.currentYear){

    this.yearCompleted = year;}
}


public String gradeDisplay(){
String gradeDisplay = "";

            if (gradeNum == 0) {
                gradeDisplay = "Not graded";
            } else if (course.isNumericGrade()) {
                gradeDisplay = Integer.toString(gradeNum);
            } else {
                gradeDisplay = Character.toString((char) gradeNum);
            }
            return gradeDisplay;
        }



@Override
public String toString() {

return "["+course.courseCode+"("+course.credits+")"+","+" "+course.name+"."+ course.getCourseTypeString() + "period:"+course.getPeriod()+"]"+"Year:"+yearCompleted+","+"Grade:"+gradeNum;

}
}
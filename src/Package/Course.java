package Package;
public class Course{


String name;

String courseCode;

char courseBase;

int courseType;

double credits;

boolean numericGrade;

int period;

public Course(){
}

public Course(String name, int code, char courseBase, final int type, final int period, final double credits, boolean numericGrade){
    setName(name);
    setCourseCode(code, courseBase);
    setCourseType(type);
    setPeriod(period);
    setCredits(credits);
    setNumericGrade(numericGrade);
}



public Course(Course course){
    this.name = course.name;
    this.courseCode = course.courseCode;
    this.courseBase = course.courseBase;
    this.courseType = course.courseType;
    this.credits = course.credits;
    this.numericGrade = course.numericGrade;
    this.period = course.period;

}



String getName(){
return name;
}


void setName(String name){
if(name != null){

    this.name = name;
}

}

String getCourseTypeString(){

if(courseType == 1){
   return "mandatory";
}

return "Optional";
}


 int getCourseType() {
    return courseType;
}



void setCourseType(final int type){

 if(type==1||type == 0 ){

    this.courseType = type;

} 
}
public String getCourseCode() {
    return courseCode;
}

public void setCourseCode(final int  courseCode, char courseBase) {
    
if (0 <courseCode && courseCode <1000000){

if(courseBase == 'A' ||courseBase == 'P' || courseBase == 'S' ){



this.courseCode = Integer.toString(courseCode) + courseBase;

this.courseBase = courseBase;
}
}

}

public char getCourseBase() {
    return courseBase;
}

public void setPeriod(final int period){

if(period >= ConstantValues.MIN_PERIOD && period <= ConstantValues.MAX_PERIOD){

this.period = period;
}
else {
    System.out.println("Invalid period: " + period);
}

}



public int getPeriod() {
    return period;
}


public double getCredits() {
    return credits;
}

private void setCredits(final double credits) {

if(credits >= ConstantValues.MIN_CREDITS && credits <= ConstantValues.MAX_CREDITS){
    this.credits = credits;
}
}


public boolean isNumericGrade() {
    return numericGrade;
}
public void setNumericGrade(boolean numericGrade) {
    this.numericGrade = numericGrade;
}




@Override
public String toString() {
 
    return "["+courseCode+"("+credits+")"+","+" "+name+"."+ getCourseTypeString() + "period:"+getPeriod()+"]";
}

}
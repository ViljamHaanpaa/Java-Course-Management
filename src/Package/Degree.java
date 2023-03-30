

package Package;
import java.util.ArrayList;
import java.util.List;
public class Degree {

    static final int MAX_COURSES = 50;

    int count;

    String degreeTitle = ConstantValues.NO_TITLE;
    
    String titleOfThesis = ConstantValues.NO_TITLE;

     List <StudentCourse> myCourses;

///methods


public List<StudentCourse> getCourses() {
    return myCourses;
}



void addStudentCourses(List<StudentCourse> courses){

if(courses!=null){

    for(StudentCourse course: courses){

        addStudentCourse(course);

    }
    
}


}


boolean addStudentCourse(StudentCourse course){

if(course != null&& count < MAX_COURSES){
myCourses.add(course);
count++;
return true;
}

return false;

}

public String getDegreeTitle() {
    return degreeTitle;
}


public void setDegreeTitle(String degreeTitle) {
    if(degreeTitle != null){
    this.degreeTitle = degreeTitle;
}

}


public void setTitleOfThesis(String titleOfThesis) {
    if(degreeTitle != null){
    this.titleOfThesis = titleOfThesis;
}
}

public String getTitleOfThesis() {
    return titleOfThesis;
}




double getCreditsByBase(char base){
    double credits = 0;
    for (StudentCourse studentCourse : myCourses) {
        
if(studentCourse != null && isCourseCompleted(studentCourse)){
    Course course = studentCourse.getCourse();

    char courseBase = studentCourse.getCourseBase();
    if (courseBase == base) {      
   credits+=course.getCredits();
    }      
}
}
return credits;
}



double getCreditsByType(final int courseType){

double credits = 0;

for (StudentCourse studentCourse: myCourses){
if(studentCourse!= null && isCourseCompleted(studentCourse)){

    Course course = studentCourse.getCourse();
if( course.getCourseType() == courseType){

    credits +=course.getCredits();
}
}


}
return credits;
}



double getCredits(){

    double credits = 0;
for(StudentCourse studentCourse: myCourses){
    Course course = studentCourse.getCourse();
    if(isCourseCompleted(studentCourse)){


credits+= course.getCredits();
    }
}

return credits;
}

public int getcount(){

    return count;
}





private boolean isCourseCompleted(StudentCourse c) {
    if (c != null) {
        if (!c.isPassed()) {
            return false;
        }

        if (c.isNumericGrade()) {
            if (c.getGradeNum() > 0) {
                return true;
            } 
        }

        if (!c.isNumericGrade()) {
            if (c.getCourseBase() == 'A') {
                return true;
            } 
        }
    }
    return true;
}
public boolean Haspassed(StudentCourse c){
    return isCourseCompleted(c);

}


void printCourses() {
    for(StudentCourse studentCourse: myCourses) {
        if(studentCourse != null && isCourseCompleted(studentCourse)) {
            System.out.println(studentCourse.toString());
        }
    }
}


List<Double> getGPA(int type){

    double sum = 0.0;
    int count = 0;
    double average = 0.0;
    if (type == ConstantValues.MASTER_TYPE || type == ConstantValues.BACHELOR_TYPE || type== ConstantValues.ALL){
    for (StudentCourse course : myCourses) {
        
            if (course.isNumericGrade()) {
                sum += course.getGradeNum();
                count++;
            }
        }
    }

    if (count > 0) {
        average = sum / count;
    }

    List<Double> gpaInfo = new ArrayList<>();
    gpaInfo.add(sum);
    gpaInfo.add((double) count);
    gpaInfo.add(average);

}



public String toString(){

    String courseString = "";

    for (int i = 0; i < count; i++) {
        int numberOfcourse = i +1;
        if (myCourses[i] != null ) {
            courseString += String.format("\n%d. [%s (%.2f) %s, %s period: %d] Year: %d, Grade: %s",
        numberOfcourse, myCourses[i].getCourse().getCourseCode(), myCourses[i].getCourse().getCredits(),
        myCourses[i].getCourse().getName(), myCourses[i].getCourse().getCourseTypeString(),
        myCourses[i].getPeriod(), myCourses[i].getYear(), myCourses[i].gradeDisplay());
        }
    }

    return courseString;
}

}
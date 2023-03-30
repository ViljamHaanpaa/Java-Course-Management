package Package;

public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Mouse", "Mickey");
        employee1.setBirthDate("141200A2315");
        employee1.setSalary(756.85);
        System.out.println(employee1.toString());
    }

}
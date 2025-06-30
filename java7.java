University/Person.java: 
package university; 
public interface Person { 
    String getDetails(); 
    void printDetails();} 
University/Employee.java: 
package university; 
public abstract class Employee implements Person { 
    String name; 
    int age; 
    String designation; 
    double salary; 
    public Employee(String name, int age, String designation, double salary) { 
        this.name = name; 
        this.age = age; 
        this.designation = designation; 
        this.salary = salary;    } 
    public String getDetails() { 
        return "Name: " + name + ", Age: " + age + ", Designation: " + designation + ", Salary: $" + salary;} 
} 
University/Professor.java: 
package university; 
public class Professor extends Employee { 
    String department; 
    String researchArea; 
    public Professor(String name, int age, String designation, double salary, String department, String 
researchArea) { 
        super(name, age, designation, salary); 
        this.department = department; 
        this.researchArea = researchArea;    } 
    public String getDetails() { 
        return super.getDetails() + ", Department: " + department + ", Research Area: " + researchArea; } 
    public void printDetails() { 
        System.out.println("Professor Details: " + getDetails());    } 
} 
University/AdminStaff.java: 
package university; 
public class AdminStaff extends Employee { 
    String role; 
    int workingHours; 
    public AdminStaff(String name, int age, String designation, double salary, String role, int 
workingHours) { 
        super(name, age, designation, salary); 
        this.role = role; 
        this.workingHours = workingHours;    } 
public String getDetails() { 
return super.getDetails() + ", Role: " + role + ", Working Hours: " + workingHours;    } 
public void printDetails() {        
System.out.println("Admin Staff Details: " + getDetails());    } 
} 
Application/UniversityApp.java: 
package application; 
import university.*; 
public class UniversityApp { 
public static void main(String[] args) { 
Professor professor = new Professor("Dr. Smith", 45, "Professor", 80000, "Computer Science", 
"AI Research"); 
AdminStaff admin = new AdminStaff("John Doe", 35, "Admin Assistant", 40000, "HR", 40); 
professor.printDetails(); 
admin.printDetails(); 
} 
}
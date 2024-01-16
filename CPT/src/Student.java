import java.util.ArrayList; //allows the program to use array lists

/* public class Student 
 * By creating this class, is allows the system to store and retrieve the student's data without any hassle
 */
public class Student {
	
	private String name; //String that stores the name of the student
    private int id; //Integer that stores the variable "id"
    private ArrayList<Double> grades; // An arraylist of type Double that holds the grades of the student

    public Student(String name, int id) {
        this.name = name; //assigns the value of the "name" parameter to the "name" variable
        this.id = id; //assigns the value of the "id" parameter to the "id" variable
        this.grades = new ArrayList<>(); //assigns the value of the "name" parameter to an arraylist
    }

    public String getName() {
        return name; //returns the variable 'name'
    }

    public int getId() {
        return id; //returns the variable 'id'
    }

    public void addGrade(double grade) {
        grades.add(grade); //allows the user to add grades to the student's list storing it as one of the student's grades
    }

    public ArrayList<Double> getGrades() {
        return grades; //returns the variable 'grades'
    }
}


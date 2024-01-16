import java.util.ArrayList;
import java.util.Scanner;

public class GradeManagementSystem {
    private ArrayList<Student> students; //arraylist of type student that holds the list of students in the system
    private Scanner scanner; //used for reading input from the user

    public GradeManagementSystem() {
        students = new ArrayList<>(); //creates a new empty list to store the Student objects in the grade management system
        scanner = new Scanner(System.in); //reads user input when it is stated
    }

    public void login() {
        System.out.println("Please enter your username: "); //print statement
        String username = scanner.nextLine(); //reads a line of text input from the user and assigns it to the String variable 'username'
        System.out.println("Please enter your password: "); //print statement
        String password = scanner.nextLine(); //reads a line of text input from the user and assigns it to the String variable 'password'

        if (verifyLogin(username, password)) {
            System.out.println("Login successful."); //print statement
        } else {
            System.out.println("Invalid credentials. Please try again."); //print statement
            login(); //calls the login method
        }
    }

    private boolean verifyLogin(String username, String password) { //In this class I made sure tbat the username equals 'Cookie' and the password equals 'Monster'
        return username.equals("Cookie") && password.equals("Monster");
    }

    public void displayMenu() {
    	System.out.println("Welcome to the Student Grade Management Program!"); //print statement
        System.out.println("----- Student Grade Management System -----"); //print statement
        System.out.println("1. Add new student"); //print statement
        System.out.println("2. Enter grades"); //print statement
        System.out.println("3. Generate grade reports"); //print statement
        System.out.println("4. Exit"); //print statement
        System.out.println("------------------------------------------"); //print statement
    }

    public void addStudent() {
        System.out.println("Enter student name: "); //print statement
        String name = scanner.nextLine(); //reads a line of text input from the user and assigns it to the String variable 'name'
        System.out.println("Enter student ID: "); //print statement
        int id = inputInteger(); //reads an integer input from the user, the entered integer value is then assigned to the variable 'id'

        Student student = new Student(name, id); //creates a new statement of the student class with the variable 'name' and 'id'
        students.add(student); //adds the student object to the end of the ArrayList
        System.out.println("Student added successfully."); //print statement
    }

    public void enterGrades() {
        System.out.println("Enter student ID: "); //print statement
        int id = inputInteger(); //reads an integer input from the user, the entered integer value is then assigned to the variable 'id'

        Student student = findStudentById(id); //searches for a student with the specified 'id'
        if (student == null) { //used if no student with the given id was found
            System.out.println("Student not found."); //print statement
            return; //returns this statement
        }

        System.out.println("Enter grade for each assessment (press Q to quit): "); //print statement
        String input; //string assigned to the variable input
        while (true) {
            input = scanner.nextLine(); //reads a line of text input from the user and assigns it to the String variable 'input'.
            if (input.equals("Q") || input.equals("q")) {
                break; //breaks the loop
            }

            double grade = inputDouble(input); //converts input to double then assigns the resulting value to the grade variable
            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade. Please enter a grade between 0 and 100."); //print statement
            } else {
                student.addGrade(grade); //adds the student object to the grade variable
            }
        }

        System.out.println("Grades entered successfully."); //print statement
    }
    
    public void generateGradeReports() {
        System.out.println("Enter student ID: "); //print statement
        int id = inputInteger(); //reads an integer input from the user, the entered integer value is then assigned to the variable 'id'

        Student student = findStudentById(id); //searches for a student with the specified 'id'
        if (student == null) { //used if no student with the given id was found
            System.out.println("Student not found."); //print statement
            return;
        } //returns this statement

        ArrayList<Double> grades = student.getGrades(); //gets the list of grades for the Student variable and assigns it to the grades variable
        System.out.println("Grades for " + student.getName() + ":"); //prints the grades for the student
        for (int i = 0; i < grades.size(); i++) { //for loop that goes over the gradelist
            System.out.println("Assessment " + (i + 1) + ": " + grades.get(i)); //prints the assessments for the student
        }

        double finalGrade = calculateFinalGrade(grades); //stores the resulting final grade in the 'finalGrade' variable
        System.out.println("Final Grade: " + finalGrade); //prints the Final Grade for the student
    }

    private double calculateFinalGrade(ArrayList<Double> grades) {
        double assignmentTotal = 0;
        double quizTotal = 0;
        double examTotal = 0;

        for (int i = 0; i < grades.size(); i++) {
            double grade = grades.get(i);
            if (i < 3) { 
                assignmentTotal += grade;
            } else if (i < 6) { 
                quizTotal += grade;
            } else { 
                examTotal += grade;
            }
        }
        //How the grades are being calculated
        double assignmentAvg = assignmentTotal / 3;
        double quizAvg = quizTotal / 3;
        double examAvg = examTotal / 4;
        //Weight factors of each assessment
        double assignmentWeight = 0.3;
        double quizWeight = 0.2;
        double examWeight = 0.5;
        //calculation of the final grade
        double finalGrade = (assignmentAvg * assignmentWeight) +
                (quizAvg * quizWeight) +
                (examAvg * examWeight);

        return finalGrade; //returns the final grade
    }

    private Student findStudentById(int id) {
        int numStudents = students.size(); //finds the number in the students list and assigns it to the 'numStudents' variable
        for (int i = 0; i < numStudents; i++) {
            Student student = students.get(i); //gets the Student object from the students list and assigns it to the 'student' variable
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    
  //From the Utils Class
    public static int convertStringToInt(String number) {
    	int total = 0;
    	int value;
    	int placeValue = 1;
    	
    	for(int i = number.length()-1; 1>=0; i--) {
    		value = (char)number.charAt(i) - (char)'0';
    		total += value * placeValue;
    		placeValue = placeValue * 10;
    	}
    }
    
  //From the Utils Class
    private int inputInteger() {
    	while (true) {
    	String input = scanner.nextLine(); //reads a line of text input from the user and assigns it to the String variable 'input'.
    	if (isInteger(input)) {
    	return Integer.parseInt(input);
    	} else {
    	System.out.println("Invalid input. Please enter a valid integer.");
    	}
    }
}
    //From the Utils Class
	public static boolean isInteger(String stringToCheck) {
	    try {
		    Integer.parseInt(stringToCheck);
		    return true;
	    }
	
	    catch (NumberFormatException e) {
	    	return false; 
	    }
	}
    
	//From the Utils Class
	public static boolean isDouble(String stringToCheck) {
		try {
			Double.parseDouble(stringToCheck);
			return true; 
		}
		
		catch (NumberFormatException e) {
			return false; 
		}
	}
	
	//From the Utils Class
    public static double inputDouble(String message) {
	    Scanner userInput = new Scanner(System.in);
	    String result= ""; 
	     
	    do {
	    	System.out.print(message);
		    result = userInput.nextLine(); 
		
		    if (isDouble(result))
			    break; 
		    else
			    System.out.println("Please enter a valid decimal number!");
	    } while (true); 
	    
	    return Double.parseDouble(result); 
    }
    
    
    public void start() {
    	login(); //calls the login method

        int choice; //stores the user's menu choice
        while (true) {
            displayMenu(); //method which prints the menu options for the grade management system
            System.out.println("Enter your choice: "); //print statement
            choice = inputInteger(); //reads an integer input from the user and assigns it to the 'choice' variable

            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                enterGrades();
            } else if (choice == 3) {
                generateGradeReports();
            } else if (choice == 4) {
                System.out.println("Thank you for using the Grade Management System Program!"); //print statement
                return;
            } else {
                System.out.println("Invalid choice. Please try again."); //print statement
            }
        }
    }
}

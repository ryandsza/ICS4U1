/* public class: Main
* Student Name: Ryan D'Souza
* Course Code: ICS 4U1
* Project Start Date: May 27, 2023
* Project Completion Date: June 12, 2023
*/
//Provides methods for getting input from the user through the console
//This class contains the main method where the program execution begins.
//In this project, the purpose is to prompt the user to enter a specific answer for a username and password to proceed, then the user is presented with a menu to add a student to the gradebook, enter the grades for the student(s), generate grade reports for the student and to quit out of the program 

public class Main {
    public static void main(String[] args) {
        GradeManagementSystem grade = new GradeManagementSystem(); //assigns the variable "grade" and initializing the object to the "GradeManagementSystem" class
        grade.start(); //calls the method "start" from the class "GradeManagementSystem" and calls it in the main class to start the program
    }
}


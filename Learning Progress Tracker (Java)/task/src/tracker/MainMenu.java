package tracker;

import tracker.Exceptions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
    private static final Scanner s = new Scanner(System.in);
    public void printMenu() {

        System.out.println("Learning Progress Tracker");
        while(true) {
            String input = s.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.print("Bye");
                break;
            } else if (input.isEmpty() || input.isBlank()) System.out.print("No input");

                switch (input) {
                    case "back" -> System.out.println("Enter 'exit' to exit the program.");
                    case "add students" -> {
                        System.out.println("Enter student credentials or 'back' to return:");
                        while (true) {
                            String studentCredentials = s.nextLine();
                            if (studentCredentials.equalsIgnoreCase("back")) {
                                System.out.printf("Total %d students have been added.%n", AddStudents.getMapSize());
                                break;
                            } else if (!studentCredentials.contains("@") || studentCredentials.length() < 9) {
                                System.out.println("Incorrect credentials.");
                            } else {
                                try {
                                    Student student = new Student(studentCredentials);
                                    AddStudents.newStudent(student);
                                    System.out.println("The student has been added.");
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                } catch (NameException e) {
                                    System.out.println(e.getMessage());
                                } catch (LastNameException e) {
                                    System.out.println(e.getMessage());
                                } catch (EmailException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }
                    default -> System.out.println("Unknown command!");
            }
        }
    }
}

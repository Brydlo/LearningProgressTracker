package tracker;

import tracker.Exceptions.*;
import tracker.statistics.StatisticalCalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
    private static final Scanner s = new Scanner(System.in);
    private String name = "";
    private String lastName = "";
    private String mail = "";
    private final AddStudents addStudents = new AddStudents();
    private final AddPoints addPoints = new AddPoints();
    private final StatisticalCalculator statisticalCalculator = new StatisticalCalculator();
    private Map<Long, Student> studentMap = new HashMap<>();
    private final Map<Long, Points> pointsMap = new HashMap<>();

    public void printMenu() {

        System.out.println("Learning Progress Tracker");
        while (true) {
            String input = s.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.print("Bye");
                break;
            } else if (input.isEmpty() || input.isBlank()) System.out.print("No input");

            switch (input) {
                case "back" -> System.out.println("Enter 'exit' to exit the program.");
                case "add students" -> printAddStudent();
                case "list" -> printList();
                case "add points" -> printAddPoints();
                case "find" -> printFind();
                case "statistic" -> printStatisticMenu();
                default -> System.out.println("Unknown command!");
            }
        }
    }

    private static String[] splitString(String fullName) throws ValidateCredentials {
        String[] splitName = fullName.split(" ");
        StringBuilder lastName = new StringBuilder();
        for (int i = 1; i < splitName.length - 1; i++) {
            lastName.append(splitName[i]);
            if (i != splitName.length - 2) {
                lastName.append(" ");
            }
        }
        String[] result = new String[3];
        result[0] = splitName[0];
        result[1] = lastName.toString();
        result[2] = splitName[splitName.length - 1];
        return result;
    }

    private void checkResult(String fullName) {
        try {
            String[] splitName = splitString(fullName);
            name = splitName[0];
            lastName = splitName[1];
            mail = splitName[2];
        } catch (ValidateCredentials e) {
            System.out.println("Incorrect credentials.");
        }
    }

    private long[] splitNumbers(String[] splitInput) {
        long[] numbers = new long[splitInput.length];
        for (int i = 0; i < splitInput.length; i++) {
            numbers[i] = Long.parseLong(splitInput[i]);
        }
        return numbers;
    }

    private long checkId(String[] arrayOfPoints, AddStudents addStudents) throws ValidStudentId {
        StudentInputValidator.validStudentId(arrayOfPoints, addStudents);
        return Long.parseLong(arrayOfPoints[0]);
    }

    private long[] checkPoints(String[] arrayOfPoints) throws ValidPointsCredentials {
        StudentInputValidator.validStudentPoints(arrayOfPoints);
        return splitNumbers(arrayOfPoints);
    }

    private void printAddStudent() {
        System.out.println("Enter student credentials or 'back' to return:");
        while (true) {
            String studentCredentials = s.nextLine();
            checkResult(studentCredentials);
            if (studentCredentials.equalsIgnoreCase("back")) {
                System.out.printf("Total %d students have been added.%n", AddStudents.getMapSize());
                break;
            } else if (mail.isEmpty() || name.isEmpty() || lastName.isEmpty()) {
                System.out.println("Incorrect credentials.");
            } else {
                try {
                    Student student = new Student(name, lastName, mail);
                    AddStudents.newStudent(student);
                    studentMap = addStudents.getMapOfStudents();
                    System.out.println("The student has been added.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (NameException e) {
                    System.out.println(e.getMessage());
                } catch (LastNameException e) {
                    System.out.println(e.getMessage());
                } catch (EmailException e) {
                    System.out.println(e.getMessage());
                } catch (RepetitionEmailException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    private void printList() {
        if (AddStudents.getMapSize() == 0) System.out.println("No students found");
        else AddStudents.printMapOfStudents();
    }
    private void printAddPoints() {
        System.out.println("Enter an id and points or 'back' to return");
        while (true) {
            String decision = s.nextLine();
            String[] splitDecision = decision.split(" ");
            if (decision.equals("back")) break;
            else {
                try {
                    long id = checkId(splitDecision, addStudents);
                    long[] pointsArray = checkPoints(splitDecision);
                    statisticalCalculator.coursePopularity(pointsArray);
                    statisticalCalculator.courseActivity(pointsArray);
                    if (pointsMap.containsKey(id)) {
                        Points existingPoints = pointsMap.get(id);
                        existingPoints.setPoints(pointsArray);
                        statisticalCalculator.studentsRanking(id, pointsMap);
                        System.out.println("Points updated.");
                    } else {
                        Points points = new Points(pointsArray);
                        pointsMap.put(id, points);
                        statisticalCalculator.studentsRanking(id, pointsMap);
                        System.out.println("Points updated.");
                    }
                } catch (ValidStudentId | ValidPointsCredentials e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    private void printFind() {
        System.out.println("Enter an id or 'back' to return:");
        while (true) {
            String searchingNumber = s.nextLine();
            if (searchingNumber.equals("back")) break;
            else {
                long id;
                if (!searchingNumber.matches("\\d+")) {
                    System.out.println("No students found");
                } else {
                    id = Long.parseLong(searchingNumber);
                    if (studentMap.containsKey(id)) {
                        addPoints.printMapOfPoints(id, pointsMap);
                    } else System.out.printf("No student is found for id=%d", id);
                }
            }
        }
    }

    private void printStatisticMenu() {
        System.out.println("Type the name of a course to see details or 'back' to quit");
        while (true) {
            String input = s.nextLine();
            if (input.equals("back")) break;

        }







    }
}


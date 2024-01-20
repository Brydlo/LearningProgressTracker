package tracker;

import tracker.Exceptions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String name;
    private String lastName;
    private String email;

    private Pattern pattern;
    private Matcher matcher;



    public Student(String fullName) throws EmailException, NameException, LastNameException  {
        String[] splitName = splitMethod(fullName);
        if (splitName.length < 3) {
            throw new IllegalArgumentException("Invalid credentials.");
        }
        else {
            setName(splitName[0]);
            setLastName(splitName[1]);
            setEmail(splitName[2]);
        }
    }
    private static String[] splitMethod(String fullName) {
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
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setName(String name) throws NameException {
        StudentInputValidator.validateName(name);
        this.name = name;
    }



    public void setLastName(String lastName) throws LastNameException {
        StudentInputValidator.validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setEmail(String email) throws EmailException {
        StudentInputValidator.validateEmail(email);
        this.email = email;
    }
}

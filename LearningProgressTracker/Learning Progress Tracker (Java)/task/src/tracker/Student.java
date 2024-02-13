package tracker;

import tracker.Exceptions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String name;
    private String lastName;
    private String email;
    private long id;



    public Student() {
        this.id = -1;
        this.name = "";
        this.lastName = "";
        this.email = "";
    }
    public Student(String name, String lastName, String email) throws EmailException, NameException, LastNameException, RepetitionEmailException {
        setName(name);
        setLastName(lastName);
        setEmail(email);
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

    public void setEmail(String email) throws EmailException, RepetitionEmailException {
        StudentInputValidator.validateEmail(email);
        StudentInputValidator.emailRepetitionValidation(email);
        this.email = email;
    }
    public long getStudentId() {
        return id;
    }

    public void setStudentId(long id) {
        this.id = id;
    }
}

package tracker;

import tracker.Exceptions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StudentInputValidator {
    private static final String NAME_REGEX = "^(?!.*[-']$)(?!.$)[a-zA-Z]+([- '][a-zA-Z]+)*$";
    private static final String EMAIL_REGEX = "^[a-z0-9+_.-]+@[a-z0-9]+\\.[a-z0-9]+$";
    private static Set<String> emailRepetition = new HashSet<>();

    public static void validateName(String name) throws NameException {
        if (!name.matches(NAME_REGEX)) {
            throw new NameException("Incorrect first name.");
        }
    }


    public static void validStudentPoints(String[] arrayOfPoints) throws ValidPointsCredentials {
        if (arrayOfPoints.length != 5 || !Arrays.stream(arrayOfPoints)
                .skip(1)
                .allMatch(s -> s.matches("\\d+"))) {
            throw new ValidPointsCredentials("Incorrect points format.");
        }
    }
    public static void validStudentId(String[] arrayOfPoints, AddStudents addStudents) throws ValidStudentId {
        if (!arrayOfPoints[0].matches("\\d+"))
            throw new ValidStudentId("No student is found for id=" + arrayOfPoints[0]);
        long id = Long.parseLong(arrayOfPoints[0]);
        if (!addStudents.getMapOfStudents().containsKey(id))
            throw new ValidStudentId("No student is found for id=" + arrayOfPoints[0]);
    }
    public static void validateLastName(String lastName) throws LastNameException {
        if (!lastName.matches(NAME_REGEX)) {
            throw new LastNameException("Incorrect last name.");
        }
    }

    public static void validateEmail(String email) throws EmailException {
        if (!email.matches(EMAIL_REGEX)) {
            throw new EmailException("Incorrect email.");
        }
    }

    public static void emailRepetitionValidation(String email) throws RepetitionEmailException {
        if (emailRepetition.contains(email)) {
            throw new RepetitionEmailException("This email is already taken.");
        } else emailRepetition.add(email);
    }
}

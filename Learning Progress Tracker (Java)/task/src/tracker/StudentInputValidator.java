package tracker;

import tracker.Exceptions.*;

public class StudentInputValidator {
    private static final String NAME_REGEX = /*"^[A-Za-z]+[-' ]*[A-Za-z]*$";*/ "^[A-Za-z](?:([-' ])[a-zA-Z])+$";
    private static final String EMAIL_REGEX = "^[a-z0-9+_.-]+@[a-z0-9]+\\.[a-z0-9]+$";

    public static void validateName(String name) throws NameException {
        if (!name.matches(NAME_REGEX)) {
            throw new NameException("Incorrect first name.");
        }
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
}

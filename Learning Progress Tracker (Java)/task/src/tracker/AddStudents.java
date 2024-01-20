package tracker;

import java.util.HashMap;
import java.util.Map;

public class AddStudents {

    private static Map<Integer, Student> mapOfStudents = new HashMap<>();;

    public AddStudents() {
    }
    public static Map<Integer, Student> newStudent(Student student) {
        int id = mapOfStudents.size();
        mapOfStudents.put(id, student);
        return mapOfStudents;
    }

    public Student getStudentId(int id) {
        return mapOfStudents.get(id);
    }
    public static int getMapSize() {
        if (mapOfStudents == null || mapOfStudents.isEmpty()) return 0;
        return mapOfStudents.size();
    }
}

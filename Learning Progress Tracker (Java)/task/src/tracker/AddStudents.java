package tracker;

import java.util.LinkedHashMap;
import java.util.Map;

public class AddStudents {



    private static Map<Long, Student> mapOfStudents = new LinkedHashMap<>();;
    public AddStudents() {
    }
    public static Map<Long, Student> newStudent(Student student) {
        student.setStudentId(10000 + mapOfStudents.size());
        mapOfStudents.put(student.getStudentId(), student);
        return mapOfStudents;
    }
    public Map<Long, Student> getMapOfStudents() {
        return mapOfStudents;
    }
    public Student getStudentId(long id) {
        return mapOfStudents.get(id);
    }
    public static int getMapSize() {
        if (mapOfStudents == null || mapOfStudents.isEmpty()) return 0;
        return mapOfStudents.size();
    }
    public static void printMapOfStudents() {
        System.out.println("Students:");
        for (Map.Entry<Long, Student> entry : mapOfStudents.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}

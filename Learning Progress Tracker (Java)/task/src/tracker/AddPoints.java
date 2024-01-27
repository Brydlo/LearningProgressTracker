package tracker;

import tracker.statistics.StatisticalAnalysis;

import java.util.HashMap;
import java.util.Map;

public class AddPoints implements StatisticalAnalysis {

    private Points points;
    private AddStudents addStudents;
    private Long pointsId;
    private final Map<Long, Points> mapOfPoints = new HashMap<>();


    public AddPoints() {
    }

    public AddPoints(long[] pointsArray, AddStudents addStudents) {
        this.addStudents = addStudents;
        this.pointsId = pointsArray[0];
        this.points = new Points(pointsArray);
        addPointsMethod(pointsId, points);
    }

    public void addPointsMethod(Long id, Points points) {
        Map<Long, Student> mapOfStudents = addStudents.getMapOfStudents();
        if (mapOfStudents.containsKey(id)) {
            mapOfPoints.put(id, points);
            System.out.println("Points updated.");
        } else System.out.printf("No student is found for id=%d", id);
    }

    public Map<Long, Points> getMapOfPoints() {
        return this.mapOfPoints;
    }

    public void printMapOfPoints(long id, Map<Long, Points> map) {
        Points pointsForStudent = map.get(id);
        System.out.printf("%d points: Java: %d; DSA: %d; Databases: %d; Spring: %d%n",
                id,
                pointsForStudent.getJava(),
                pointsForStudent.getDSA(),
                pointsForStudent.getDatabases(),
                pointsForStudent.getSpring());
    }

    @Override
    public String averageCompletionPerStudent(long id, Map<Long, Points> pointsMap) {
        return null;
    }

    @Override
    public String coursePopularity(long[] arrayWithPoints) {
        return null;
    }

    @Override
    public String courseActivity(long[] arrayWithPoints) {
        return null;
    }

    @Override
    public long StudentsRanking(Map<Long, Points> pointsMap) {
        return 0;
    }
}

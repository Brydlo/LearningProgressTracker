package tracker.statistics;

import tracker.Points;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticalCalculator implements StatisticalAnalysis {
    private Map<String, Long> coursePopularityMap = new HashMap<>();
    private static final double JAVA_POINTS_TO_COMPLETE = 600.0;
    private static final double DSA_POINTS_TO_COMPLETE = 400.0;
    private static final double DB_POINTS_TO_COMPLETE = 480.0;
    private static final double SPRING_POINTS_TO_COMPLETE = 550.0;
    private Map<Long, Map<String, Double>> averageMap = new HashMap<>();

    public StatisticalCalculator() {
        setCoursePopularityMap();
    }

    @Override
    public Map<Long, Map<String, Double>> averageCompletionPerStudent(long id, Map<Long, Points> pointsMap) {
        Points studentPoints = pointsMap.get(id);
        Map<String, Double> studentAverageMap = new HashMap<>();

        if (studentPoints != null) {
            System.out.println();
        }

        return averageMap;
    }

    @Override
    public Map<String, Long> coursePopularity(long id, Map<Long, Points> pointsMap, Points points) {
        if (!pointsMap.containsKey(id)) {
            if (points.getJava() != 0) coursePopularityMap.put("Java", coursePopularityMap.get("Java") + 1);
            if (points.getDSA() != 0) coursePopularityMap.put("DSA", coursePopularityMap.get("DSA") + 1);
            if (points.getDatabases() != 0)
                coursePopularityMap.put("Databases", coursePopularityMap.get("Databases") + 1);
            if (points.getSpring() != 0) coursePopularityMap.put("Spring", coursePopularityMap.get("Spring") + 1);
        }
        return coursePopularityMap;
    }

    @Override
    public String courseActivity(long[] arrayWithPoints) {
        return null;
    }

    @Override
    public long StudentsRanking(Map<Long, Points> pointsMap) {
        return 0;
    }

    private void setCoursePopularityMap() {
        this.coursePopularityMap.put("Java", 0L);
        this.coursePopularityMap.put("DSA", 0L);
        this.coursePopularityMap.put("Databases", 0L);
        this.coursePopularityMap.put("Spring", 0L);
    }
    public void printPopularityMap() {
        long minValue = Long.MAX_VALUE;
        long maxValue = Long.MIN_VALUE;

        for (Long value : coursePopularityMap.values()) {
            if (value < minValue) minValue = value;
            if (value > maxValue) maxValue = value;
        }

        List<String> minKeys = new ArrayList<>();
        List<String> maxKeys = new ArrayList<>();
        for (Map.Entry<String, Long> entry : coursePopularityMap.entrySet()) {
            if (entry.getValue() == minValue) {
                minKeys.add(entry.getKey());
            }
            if (entry.getValue() == maxValue) {
                maxKeys.add(entry.getKey());
            }
        }
        System.out.printf("Most popular: %s%nLeast popular: %s", String.join(", ", maxKeys),
                String.join(", ", minKeys));
    }
}

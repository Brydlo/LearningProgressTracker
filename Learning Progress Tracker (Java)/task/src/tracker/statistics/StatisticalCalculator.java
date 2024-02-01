package tracker.statistics;

import tracker.Points;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticalCalculator implements StatisticalAnalysis {

    String popularity = "";
    String leastPopular = "";
    Map<String, Integer> coursePopularityMap = new HashMap<>();

    public StatisticalCalculator() {
        coursePopularityMap.put("Java", 0);
        coursePopularityMap.put("DSA", 0);
        coursePopularityMap.put("Databases", 0);
        coursePopularityMap.put("Spring", 0);
    }

    @Override
    public Map<String, Integer> averageCompletionPerStudent(long id, Map<Long, Points> pointsMap, Points points) {
        return coursePopularityMap;
    }

    @Override
    public Map<String, Integer> coursePopularity(long id, Map<Long, Points> pointsMap, Points points) {
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

    public void printPopularityMap() {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (Integer value : coursePopularityMap.values()) {
            if (value < minValue) minValue = value;
            if (value > maxValue) maxValue = value;
        }

        List<String> minKeys = new ArrayList<>();
        List<String> maxKeys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : coursePopularityMap.entrySet()) {
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

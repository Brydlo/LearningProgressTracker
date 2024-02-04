package tracker.statistics;

import tracker.Points;

import java.util.*;

public class StatisticalCalculator implements StatisticalAnalysis {

    Set<Long> setOfIDs = new HashSet<>();
    private static final double JAVA_POINTS_TO_COMPLETE = 600.0;
    private static final double DSA_POINTS_TO_COMPLETE = 400.0;
    private static final double DB_POINTS_TO_COMPLETE = 480.0;
    private static final double SPRING_POINTS_TO_COMPLETE = 550.0;
    private Map<Long, Map<String, Double>> averageMap = new HashMap<>();
    private Map<String, Double> courseProgressMap = new HashMap<>();
    private Map<String, Long> courseActivityMap = new HashMap<>();
    private Map<String, Long> coursePopularityPoints = new HashMap<>();

    /*
    * Constructor
    **/
    public StatisticalCalculator() {
        setCourseActivityPoints();
        setCoursePopularityPoints();
    }


    /* public Method which use privet method to set the most and the least popular course
    * which mean how many students start this course.
    * */

    @Override
    public void coursePopularity(long[] arrayWithPoints) {
        setCoursePopularity(arrayWithPoints);
    }


    /*
    * public method which use privet method to set the highest and the lowest activity on the course
    * which mean how many times students earn points during whole sessions
    * */
    @Override
    public void courseActivity(long[] arrayWithPoints) {
        setCourseActivityMap(arrayWithPoints);
    }


    /*
    * this public method use private method to set and check 3 things
    *       first the students id
    *       second counts all the points scored by the student
    *       third it divides students points by one of the constant variables and then multiply it by 100. we get %
    * */
    @Override
    public void studentsRanking(long id, Map<Long, Points> pointsMap) {
        setAverageMap(id, pointsMap);
    }

    /*
    * this method prints ranking which is in the averageMap variable(this is a Map of Long and Map.
    * this map looks like this -> Map<Long, Map<String, Double>
    * It prints smth like this:
    * Java
    * id     points completed
    * 125684 423    70.5%
    * 200751 420    70.0%
    * 130400 405    67.5%
    * */
    public void printStudentRanking(String courseName, Map<Long, Points> pointsMap) {
        printRanking(courseName, pointsMap);
    }


    /*
    * I use this method to print only two lines:
    * Most popular:
    * Least popular:
    * the score is in the Map coursePopularityPoints
    * the printer use Min and Max values to set the most and the least popular courses.
    * */
    public void printPopularity() {
        printPopularityMethod();
    }


    /*
    * this two methods below are responsible for setting the initial popularity and activity values
    * */
    private void setCoursePopularityPoints() {
        this.coursePopularityPoints.put("Java", 0L);
        this.coursePopularityPoints.put("DSA", 0L);
        this.coursePopularityPoints.put("Databases", 0L);
        this.coursePopularityPoints.put("Spring", 0L);
    }
    private void setCourseActivityPoints() {
        this.courseActivityMap.put("Java", 0L);
        this.courseActivityMap.put("DSA", 0L);
        this.courseActivityMap.put("Databases", 0L);
        this.courseActivityMap.put("Spring", 0L);
    }


    private void setAverageMap(long id, Map<Long, Points> pointsMap) {
        Points studentPoints = pointsMap.get(id);
        Map<String, Double> studentCourseProgress = averageMap.getOrDefault(id, new HashMap<>());

        double currentJava = studentCourseProgress.getOrDefault("Java", 0.0)
                + ((studentPoints.getJava() / JAVA_POINTS_TO_COMPLETE) * 100);
        studentCourseProgress.put("Java", currentJava);

        double currentDSA = studentCourseProgress.getOrDefault("DSA", 0.0)
                + ((studentPoints.getDSA() / DSA_POINTS_TO_COMPLETE) * 100);
        studentCourseProgress.put("DSA", currentDSA);

        double currentDB = studentCourseProgress.getOrDefault("Databases", 0.0)
                + ((studentPoints.getDatabases() / DB_POINTS_TO_COMPLETE) * 100);
        studentCourseProgress.put("Databases", currentDB);

        double currentSpring = studentCourseProgress.getOrDefault("Spring", 0.0)
                + ((studentPoints.getSpring() / SPRING_POINTS_TO_COMPLETE) * 100);
        studentCourseProgress.put("Spring", currentSpring);

        averageMap.put(id, studentCourseProgress);

    }

    private void setCoursePopularity(long[] arrayWithPoints) {
        String[] namesArray = {"Java", "DSA", "Database", "Spring"};
        if (!setOfIDs.contains(arrayWithPoints[0])) {
            setOfIDs.add(arrayWithPoints[0]);
            for (int i = 1; i < arrayWithPoints.length; i++) {
                if (arrayWithPoints[i] > 0) coursePopularityPoints.put(namesArray[i - 1],
                        coursePopularityPoints
                                .getOrDefault(namesArray[i - 1], 0L) + 1);
            }
        }
    }

    private void setCourseActivityMap(long[] arrayWithPoints) {
        String[] courseNames = {"Java", "DSA", "Database", "Spring"};
        for (int i = 1; i < arrayWithPoints.length; i++) {
            if (arrayWithPoints[i] > 0) {
                courseActivityMap.put(courseNames[i - 1],courseActivityMap
                        .getOrDefault(courseNames[i - 1], 0L) + 1);
            }
            ++i;
        }
    }

    private void printPopularityMethod() {
        long minValue = Long.MAX_VALUE;
        long maxValue = Long.MIN_VALUE;

        for (Long value : coursePopularityPoints.values()) {
            if (value < minValue) minValue = value;
            if (value > maxValue) maxValue = value;
        }
        List<String> minKeys = new ArrayList<>();
        List<String> maxKeys = new ArrayList<>();
        for (Map.Entry<String, Long> entry : coursePopularityPoints.entrySet()) {
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

    private void printRanking(String name, Map<Long, Points> pointsMap) {
        List<Map.Entry<Long, Map<String, Double>>> list = new ArrayList<>(averageMap.entrySet());
        list.sort((entry1, entry2) -> {
           Points points1 = pointsMap.get(entry1.getKey());
           Points points2 = pointsMap.get(entry2.getKey());
           int courseComparison = switch (name) {
                case "Java" -> Long.compare(points2.getJava(), points1.getJava());
                case "DSA" -> Long.compare(points2.getDSA(), points1.getDSA());
                case "Databases" -> Long.compare(points2.getDatabases(), points1.getDatabases());
                case "Spring" -> Long.compare(points2.getSpring(), points1.getSpring());
                default -> throw new IllegalArgumentException("Unknown course");
            };
            return (courseComparison == 0)
                    ? Long.compare(entry1.getKey(), entry2.getKey())
                    : courseComparison;
        });
        System.out.printf("%s%nid\tpoints\tcompleted%n", name);

        for (Map.Entry<Long, Map<String, Double>> entry : list) {
            Long studentId = entry.getKey();
            Points pointsFromMap = pointsMap.get(studentId);
            Map<String, Double> courseProgress = entry.getValue();

            if (courseProgress.containsKey(name)) {
                long points = switch (name) {
                    case "Java" -> pointsFromMap.getJava();
                    case "DSA" -> pointsFromMap.getDSA();
                    case "Databases" -> pointsFromMap.getDatabases();
                    case "Spring" -> pointsFromMap.getSpring();
                    default -> throw new IllegalArgumentException("Invalid course name: " + name);
                };
                System.out.printf("%d\t%d\t%.2f%%n", studentId, points, courseProgress.get(name));
            }
        }
    }
}

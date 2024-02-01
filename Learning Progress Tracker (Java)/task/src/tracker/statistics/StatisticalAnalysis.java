package tracker.statistics;

import tracker.Points;

import java.util.Map;


/**
 * Interface for computing statistics related to a map of points.
 */
public interface StatisticalAnalysis {


    /**
     * Computes the average completion for a specific student based on the given map of points.
     *
     * @param id the ID of the student
     * @param pointsMap the map of points, where each key is an ID of the student and the associated Points object represents the student's points.
     * @return the string representation of the average completion per student.
     */
    Map<String, Integer> averageCompletionPerStudent(long id, Map<Long, Points> pointsMap, Points points);

    /**
     * Computes the popularity of the courses based on the given array of points.
     *
     * @param arrayWithPoints the array of points
     * @return the string representation of the course popularity
     */

    Map<String, Integer> coursePopularity(long id, Map<Long, Points> pointsMap, Points points);


    /**
     * Computes the activity of the courses based on the given array of points.
     *
     * @param arrayWithPoints the array of points
     * @return the string representation of the course activity
     */
    String courseActivity(long[] arrayWithPoints);


    /**
     * Computes the students' ranking based on the given map of points.
     *
     * @param pointsMap the map of points, where each key is an ID of the student and the associated Points object represents the student's points.
     * @return the long representation of the students' ranking
     */
    long StudentsRanking(Map<Long, Points> pointsMap);


}

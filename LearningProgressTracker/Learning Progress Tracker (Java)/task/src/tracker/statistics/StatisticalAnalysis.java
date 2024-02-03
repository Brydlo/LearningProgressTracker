package tracker.statistics;

import tracker.Points;

import java.util.Map;


/**
 * Interface for computing statistics related to a map of points.
 */
public interface StatisticalAnalysis {


    /**
     * Computes the popularity of the courses based on the given array of points.
     */
    void coursePopularity(long[] arrayWithPoint);


    /**
     * Computes the activity of the courses based on the given array of points.
     *
     * @param arrayWithPoints the array of points
     * @return the string representation of the course activity
     */
    void courseActivity(long[] arrayWithPoints);


    /**
     * Computes the students' ranking based on the given map of points.
     *
     * @param pointsMap the map of points,
     *                  where each key is an ID of the student and the associated Points object represents the student's points.
     */
    void StudentsRanking(long id, Map<Long, Points> pointsMap);


}

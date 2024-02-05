package tracker.statistics;

import tracker.Points;

import java.util.Map;


/**
 * Interface for computing statistics related to a map of points.
 */
public interface StatisticalAnalysis {

    void coursePopularity(long[] arrayWithPoint);

    void courseActivityAndDifficulty(long[] arrayWithPoints);

    void studentsRanking(long id, Map<Long, Points> pointsMap);


}

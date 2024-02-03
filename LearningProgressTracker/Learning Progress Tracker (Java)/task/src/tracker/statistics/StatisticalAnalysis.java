package tracker.statistics;

import tracker.Points;

import java.util.Map;


/**
 * Interface for computing statistics related to a map of points.
 */
public interface StatisticalAnalysis {

    void coursePopularity(long[] arrayWithPoint);

    void courseActivity(long[] arrayWithPoints);

    void StudentsRanking(long id, Map<Long, Points> pointsMap);


}

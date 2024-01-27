package tracker.statistics;

import tracker.Points;

public interface StatisticInterface {
    double averageCompletion(long id, Points points);
    String popularity(Points points);

}

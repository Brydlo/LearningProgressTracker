package tracker;

import tracker.statistics.StatisticalAnalysis;

import java.util.Map;

public class Points implements StatisticalAnalysis {

    private long java = 0;
    private long DSA = 0;
    private long databases = 0;
    private long spring = 0;

    public Points(long[] points) {
        setPoints(points);
    }

    public void setPoints(long[] points) {
        this.java += points[1];
        this.DSA += points[2];
        this.databases += points[3];
        this.spring += points[4];
    }
    public long getJava() {
        return java;
    }

    public long getDSA() {
        return DSA;
    }


    public long getDatabases() {
        return databases;
    }

    public long getSpring() {
        return spring;
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
//points: Java=12; DSA=13; Databases=14; Spring=15
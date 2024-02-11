package tracker;


public class Points {

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

}
//points: Java=12; DSA=13; Databases=14; Spring=15
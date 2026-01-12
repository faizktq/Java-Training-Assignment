package miniProject3;

public class Student {
    private int eno;
    private String name;
    private String branch;
    private int sem;
    private double percentage;

    public Student(int eno, String name, String branch, int sem, double percentage) {
        this.eno = eno;
        this.name = name;
        this.branch = branch;
        this.sem = sem;
        this.percentage = percentage;
    }

    public int getEno() { return eno; }
    public String getName() { return name; }
    public String getBranch() { return branch; }
    public int getSem() { return sem; }
    public double getPercentage() { return percentage; }
}

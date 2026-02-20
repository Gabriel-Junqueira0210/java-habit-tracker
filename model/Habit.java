package model;

public class Habit {
    //Atributes
    private int id;
    private String name;
    private int monthlyGoal;
    private int completedCount;

    //Constructor
    public Habit (String name, int monthlyGoal) {
        this.name = name;
        this.monthlyGoal = monthlyGoal;
        this.completedCount = 0;
    }

    //Methods
    //Getters
    public int getId() {return this.id;}

    public String getName() {return this.name;}

    public int getMonthlyGoal() {return this.monthlyGoal;}

    public int getCompletedCount() {return this.completedCount;}

    //Setters
    public void setId(int id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setMonthlyGoal(int weeklyGoal) {this.monthlyGoal = weeklyGoal;}

    public void setCompletedCount(int completedCount) {this.completedCount = completedCount;}
}
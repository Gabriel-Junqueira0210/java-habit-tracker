package com.gabriel.habittracker.model;

public class Habit {
    //Atributes
    private long id;
    private String name;
    private int monthlyGoal;
    private int completedCount;

    //Constructor
    public Habit (long id, String name, int monthlyGoal) {
        this.id = id;
        this.name = name;
        this.monthlyGoal = monthlyGoal;
        this.completedCount = 0;
    }

    //Methods
    //Getters
    public long getId() {return this.id;}

    public String getName() {return this.name;}

    public int getMonthlyGoal() {return this.monthlyGoal;}

    public int getCompletedCount() {return this.completedCount;}

    //Setters
    public void setId(int id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setMonthlyGoal(int weeklyGoal) {this.monthlyGoal = weeklyGoal;}

    public void setCompletedCount(int completedCount) {this.completedCount = completedCount;}

    public void incrementCompletedDays() {
        if (completedCount >= monthlyGoal){
            throw new IllegalStateException("A meta já foi atingida.");
        }
        this.completedCount++;
    }

    @Override
    public String toString() {
        return "Nome: " + this.name +
        "\nID: " + this.id +
        "\nDias completos: " + this.completedCount + "/" + this.monthlyGoal;
    }
}
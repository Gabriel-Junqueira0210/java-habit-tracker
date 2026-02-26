package com.gabriel.habittracker.repository;

import com.gabriel.habittracker.model.Habit;
import java.util.ArrayList;
import java.util.List;

public class HabitRepository {
    private List<Habit> habitList;

    public void loadFile() {
    }

    public void addHabit(Habit habit){
        habitList.add(habit);
    }

    public List<Habit> findAll() {
        return new ArrayList<>(habitList);
    }

    public Habit findById(long id) {
        for (Habit habit : habitList) {
            if (habit.getId() == id){
                return habit;
            }
        }
        return null;
    }

    public void removeHabit(Habit habit) { habitList.remove(habit); }


}
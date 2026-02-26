package com.gabriel.habittracker.repository;

import com.gabriel.habittracker.persistence.HabitFileManager;
import com.gabriel.habittracker.model.Habit;
import java.util.ArrayList;
import java.util.List;

public class HabitRepository {
    private List<Habit> habitList;
    private final HabitFileManager fileManager;

    public HabitRepository () {
        this.fileManager = new HabitFileManager();

        this.habitList = new ArrayList<>();
        loadFile();
    }
    public void loadFile() {this.habitList = fileManager.loadFromFile();}

    public void addHabit(Habit habit){
        habitList.add(habit);
    }

    public List<Habit> findAll() {return new ArrayList<>(habitList);}

    public Habit findById(long id) {
        for (Habit habit : habitList) {
            if (habit.getId() == id){
                return habit;
            }
        }
        return null;
    }

    public void removeHabit(Habit habit) { habitList.remove(habit); }

    public void saveAll() {
        fileManager.saveFile(habitList);
    }


}
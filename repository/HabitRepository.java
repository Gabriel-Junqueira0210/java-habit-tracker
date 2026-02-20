package repository;
import model.Habit;

import java.util.ArrayList;
import java.util.List;

public class HabitRepository {
    private List<Habit> habitList = new ArrayList<>();

    public void addHabit(Habit habit){
        habitList.add(habit);
    }
}
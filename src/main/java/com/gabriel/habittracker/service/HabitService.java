package com.gabriel.habittracker.service;

import com.gabriel.habittracker.model.Habit;
import com.gabriel.habittracker.repository.HabitRepository;

import java.util.List;

public class HabitService {
    private final HabitRepository repository;
    private long nextId;

    public HabitService (HabitRepository repository) {
        this.repository = repository;
        initializeNextId();
    }

    private void initializeNextId(){
        long maxId = 0;

        for(Habit habit : repository.findAll()) {
            if (habit.getId() > maxId){maxId = habit.getId();}
        }
        this.nextId = maxId + 1;
    }

    private void validateHabit(String name, int montlhyGoal) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Nome inválido.");
        }
        if (montlhyGoal <= 0) {
            throw new IllegalArgumentException("Meta deve ser maior que zero.");
        }
    }

    private Habit validateExistance(long id) {
        Habit habit = repository.findById(id);

        if (habit == null) {
            throw new IllegalArgumentException("Hábito não encontrado.");
        }

        return habit;
    }

    public void createHabit(String name, int monthlyGoal) {
        validateHabit(name, monthlyGoal);
        Habit habit = new Habit(nextId++, name, monthlyGoal);

        repository.addHabit(habit);
    }

    public List<Habit> listHabits() {
        List<Habit> habits = repository.findAll();

        if (habits.isEmpty()){
            throw new IllegalArgumentException("A lista está vazia.");
        }

        return habits;
    }

    public void incrementProgress(long id) {
        Habit habit = validateExistance(id);

        habit.incrementCompletedDays();
    }

    public Habit findHabit(long id) {
        return validateExistance(id);
    }

    public void removeHabit(long id) {
        Habit habit = validateExistance(id);

        repository.removeHabit(habit);
    }

    public void saveFile() {repository.saveAll();}
}
package com.gabriel.habittracker.persistence;

import com.gabriel.habittracker.model.Habit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HabitFileManager {
    private static final String FILE_PATH = "Habits.txt";

    private String toFileFormat(Habit habit) {
        return habit.getId() + ";" + habit.getName() + ";" + habit.getMonthlyGoal() + ";" + habit.getCompletedCount();
    }

    public void saveFile (List<Habit> habits) {
        try(FileWriter writer = new FileWriter(FILE_PATH);) {

                for(Habit habit : habits) {
                    writer.write(toFileFormat(habit));
                    writer.write(System.lineSeparator());
                }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar arquivo." + e.getMessage());
        }
    }

    public List<Habit> loadFromFile() {
        List<Habit> habits = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) return habits;

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                if(line.trim().isEmpty()) continue;

                try {
                    String[] parts = line.split(";");

                    if (parts.length < 4) continue;

                    long id = Long.parseLong(parts[0]);
                    String name = parts[1];
                    int monthlyGoal = Integer.parseInt(parts[2]);
                    int completedCount = Integer.parseInt(parts[3]);

                    habits.add(new Habit(id, name, monthlyGoal, completedCount));

                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("O arquivo não foi encontrado.", e);
        }

        return habits;
    }
}

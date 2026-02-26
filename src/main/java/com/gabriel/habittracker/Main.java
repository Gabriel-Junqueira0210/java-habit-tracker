package com.gabriel.habittracker;

import com.gabriel.habittracker.menu.Menu;
import com.gabriel.habittracker.persistence.HabitFileManager;
import com.gabriel.habittracker.repository.HabitRepository;
import com.gabriel.habittracker.service.HabitService;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        HabitFileManager fileManager = new HabitFileManager();

        HabitRepository repository = new HabitRepository(fileManager);

        HabitService service = new HabitService(repository);

        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu(service, scanner);

        menu.start();
    }
}
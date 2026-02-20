package com.gabriel.habittracker;

import com.gabriel.habittracker.menu.Menu;
import com.gabriel.habittracker.repository.HabitRepository;
import com.gabriel.habittracker.service.HabitService;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        HabitService service = new HabitService();
        HabitRepository repository = new HabitRepository();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(service, scanner);

        menu.start();
    }
}
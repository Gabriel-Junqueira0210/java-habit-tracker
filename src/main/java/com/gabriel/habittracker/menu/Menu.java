package com.gabriel.habittracker.menu;

import com.gabriel.habittracker.model.Habit;
import com.gabriel.habittracker.service.HabitService;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final HabitService service;
    private final Scanner scanner;

    public Menu(HabitService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void showMenu() {
        final String menu = """
                    ===== HABIT TRACKER =====
                    -------------------------
                    1 - Inserir novo hábito
                    2 - Atualizar hábito
                    3 - Ver lista de hábitos
                    4 - Buscar hábito por id
                    5 - Excluir hábito
                    0 - Sair
                    -------------------------
                    """;
        System.out.println(menu);
    }
    public void showHabits() {
        List<Habit> habits = service.listHabits();

        if(habits.isEmpty()) {
            System.out.println("Nenhum hábito foi cadastrado.\n");
            return;
        }

        for(Habit habit : habits){
            System.out.println(habit + "\n");
        }
    }

    private String readName() {
        while (true) {
            System.out.println("Insira o nome do hábito: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()){
                System.out.println("Entrada inválida, o nome não pode estar vazio.\n");
            }else
                return name;
        }
    }

    private int readMontlhyGoal() {
        while (true) {
            System.out.println("Insira a meta mensal: ");
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);

                if(value <= 0) {
                    System.out.println("A meta mensal deve ser maior do que 0.\n");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, Digite apenas números.\n");
            }
        }
    }

    private long readId() {
        while (true) {
            System.out.println("Insira o ID do hábito desejado: ");
            String input = scanner.nextLine().trim();

            try {
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, Digite apenas números.\n");
            }
        }
    }

    private void showHabit(long id) {
        Habit habit = service.findHabit(id);
        System.out.println(habit + "\n");
    }

    public boolean handleOption(int option){
        switch (option) {
            case 1: {
                try {
                    String name = readName();
                    int goal = readMontlhyGoal();

                    service.createHabit(name, goal);

                    System.out.println("Hábito criado com sucesso!\n");

                }catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                return true;
            }
            case 2: {
                try {
                    long id = readId();

                    service.incrementProgress(id);

                    System.out.println("Número de dias concluídos atualizado com sucesso!\n");

                }catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
                return true;
            }
            case 3: {
                showHabits();
                return true;
            }
            case 4: {
                long id = readId();
                showHabit(id);
                return true;
            }
            case 5: {
                try {
                    long id = readId();

                    service.removeHabit(id);

                    System.out.println("Hábito removido com sucesso!\n");
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
                return true;
            }
            case 0: {
                return false;
            }
            default:
                System.out.println("Opção iválida!\n");
                return true;
        }
    }

    public void start() {
        boolean running = true;

        while (running) {
            showMenu();

            try {
                int option = readOption();
                running = handleOption(option);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Salvando seus dados e encerrando sistema...\n");
        service.saveFile();
    }

    public int readOption() {
    System.out.println("Escolha uma opção: \n");
        try {
            int option = scanner.nextInt();
            scanner.nextLine();
            return option;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new IllegalArgumentException("Entrada inválida! Digite apenas números.\n");
        }
    }
}

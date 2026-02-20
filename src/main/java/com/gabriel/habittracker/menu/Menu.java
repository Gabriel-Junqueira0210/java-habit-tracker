package com.gabriel.habittracker.menu;
import com.gabriel.habittracker.service.HabitService;
import java.util.InputMismatchException;
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

    public boolean handleOption(int option){
        switch (option) {
            case 1:
                System.out.println("Opção 1");
                return true;
            case 2:
                System.out.println("Opção 2");
                return true;
            case 3:
                System.out.println("Opção 3");
                return true;
            case 4:
                System.out.println("Opção 4");
                return true;
            case 5:
                System.out.println("Opção 5");
                return true;
            case 0:
                return false;
            default:
                System.out.println("Opção iválida!");
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

        System.out.println("Encerrando sistema...");
    }

    public int readOption() {
    System.out.println("Escolha uma opção: ");
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

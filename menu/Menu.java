package menu;
import repository.HabitRepository;
import service.HabitService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private HabitService service = new HabitService();
    private final Scanner scanner;

    public Menu() {
        this.service = service;
        this.scanner = new Scanner(System.in);
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

    public void start() {
        while (true) {
            showMenu();
            int option = readOption();
        }
    }

    public int readOption() {
    System.out.println("Escolha uma opção: ");
        try {
            int option = scanner.nextInt();
            scanner.nextLine();
            return option;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new IllegalArgumentException("Entrada inválida! Digite apenas números.");
        }
    }
}

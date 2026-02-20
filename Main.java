import menu.Menu;
import repository.HabitRepository;
import service.HabitService;

public class Main{
    public static void main(String[] args) {
        HabitService service = new HabitService();
        HabitRepository repository = new HabitRepository();
        Menu menu = new Menu();

        menu.start();
    }
}
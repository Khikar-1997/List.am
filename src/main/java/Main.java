import database.Database;
import menu.Menu;

public class Main {
    public static void main(String[] args) {
        Database.databaseInitializer();
        Menu.ListAmMenu();
    }
}

package menu;

import controller.ProductController;
import controller.UserController;

import java.util.Scanner;

public class Menu {
    private static Menu instance = new Menu();

    private Menu() {
    }

    public static void ListAmMenu() {
        int num;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("___________________________");
            System.out.println("            Menu           ");
            System.out.println("Press 1 for user CRUD      ");
            System.out.println("Press 2 for product CRUD   ");
            System.out.println("Press 3 for search product ");
            System.out.println("Press 4 for exit           ");
            System.out.println("___________________________");
            num = scanner.nextInt();
            String test = scanner.nextLine();
            switch (num) {
                case 1:
                    UserController.userMenu();
                    break;
                case 2:
                    ProductController.productMenu();
                    break;
                case 3:
                    ProductController.seach();
                    break;
                case 4:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Plese write valid order");
            }
        } while (num != 4);
    }
}

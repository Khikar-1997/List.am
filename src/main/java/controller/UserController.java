package controller;

import service.UserService;
import user.User;

import java.util.Scanner;

public class UserController {
    private static UserController instance = new UserController();
    private UserService userService = UserService.instance;
    private Scanner scanner = new Scanner(System.in);

    private UserController() {
    }

    private void create() {
        System.out.println("Please write user name");
        String name = scanner.nextLine();
        System.out.println("Please write user surname");
        String surname = scanner.nextLine();
        System.out.println("Please write user age");
        int age = scanner.nextInt();
        String test = scanner.nextLine();
        System.out.println("Please write user username");
        String username = scanner.nextLine();
        System.out.println("Please write user password");
        String password = scanner.nextLine();
        userService.create(new User(name, surname, age, username, password));
    }

    private void selectAllUsers() {
        for (User user : userService.findAllUsers()) {
            System.out.println("name :" + user.getName() + " ," +
                    "surname :" + user.getSurname() + " ," +
                    "age :" + user.getAge() + " ," + "username :"
                    + user.getUsername() + " ," + "password :" +
                    user.getPassword());
        }
    }

    private void findUserById() {
        System.out.println("Please write user id");
        int id = scanner.nextInt();
        System.out.println(userService.findUserById(id));
    }

    private void update() {
        System.out.println("Please write user id");
        int id = scanner.nextInt();
        System.out.println("Please write user name");
        String name = scanner.nextLine();
        System.out.println("Please write user surname");
        String surname = scanner.nextLine();
        System.out.println("Please write user age");
        int age = scanner.nextInt();
        String test = scanner.nextLine();
        System.out.println("Please write user username");
        String username = scanner.nextLine();
        System.out.println("Please write user password");
        String password = scanner.nextLine();
        userService.update(id, new User(name, surname, age, username, password));
    }

    private void delete() {
        System.out.println("Please write user id");
        int id = scanner.nextInt();
        userService.delete(id);
    }

    private void login() {
        System.out.println("Please write user username");
        String username = scanner.nextLine();
        System.out.println("Please write user password");
        String password = scanner.nextLine();
        if (userService.login(username, password)) {
            System.out.println("You are login");
            System.out.println("________________________________________");
            System.out.println("     Save or not save password          ");
            System.out.println();
            System.out.println("   Press 1 save your password        ");
            System.out.println("   Press 2 unsaved your password     ");
            System.out.println("   Press 3 only this turn            ");
            System.out.println("________________________________________");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Your password is saved");
                    break;
                case 2:
                    System.out.println("Yoru password is not saved");
                    break;
                case 3:
                    System.out.println("Your password is saved");
                    break;
                default:
                    System.out.println("Unvalid order!!!!!!!!!!");
                    break;
            }

        } else {
            System.out.println("Unvalid password or username");
        }
    }

    public static void userMenu() {
        int num;
        Scanner scanner = new Scanner(System.in);
        UserController userController = UserController.instance;
        do {
            System.out.println("_______________________________");
            System.out.println("             Users             ");
            System.out.println("   Press 1 to create user      ");
            System.out.println("   Press 2 to select all users ");
            System.out.println("   Press 3 to select user      ");
            System.out.println("   Press 4 to update user      ");
            System.out.println("   Press 5 to delete user      ");
            System.out.println("   Press 6 to login user       ");
            System.out.println("   Press 7 to return menu      ");
            System.out.println("_______________________________");
            num = scanner.nextInt();
            String test = scanner.nextLine();
            switch (num) {
                case 1:
                    userController.create();
                    break;
                case 2:
                    userController.selectAllUsers();
                    break;
                case 3:
                    userController.findUserById();
                    break;
                case 4:
                    userController.update();
                    break;
                case 5:
                    userController.delete();
                    break;
                case 6:
                    userController.login();
                    break;
                case 7:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Plese write valid order");
            }
        } while (num != 7);
    }
}
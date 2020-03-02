package controller;

import product.Product;
import service.ProductService;

import java.util.Scanner;

public class ProductController {
    private static ProductController instance = new ProductController();
    private ProductService productService = ProductService.instance;
    private Scanner scanner = new Scanner(System.in);

    private ProductController() {
    }

    private void create() {
        System.out.println("Please write product name");
        String name = scanner.nextLine();
        System.out.println("Please write product prise");
        double prise = scanner.nextDouble();
        String test = scanner.nextLine();
        System.out.println("Please write product type");
        String type = scanner.nextLine();
        Product product = new Product();
        productService.create(new Product(name, prise, type, product.getUuid()));
    }

    private void selectAllProducts() {
        for (Product product : productService.selectAllProducts()) {
            System.out.println("name :" + product.getName() + " ," + "prise :" + product.getPrise() +
                    " ," + "type :" + product.getType() + " ," + "uuid :" +
                    product.getUuid());
        }
    }

    private void findProductById() {
        System.out.println("Please write Product id");
        int id = scanner.nextInt();
        System.out.println(productService.findProductById(id));
    }

    private void update() {
        System.out.println("Please write Product id");
        int id = scanner.nextInt();
        String test = scanner.nextLine();
        System.out.println("Please write product name");
        String name = scanner.nextLine();
        System.out.println("Please write product prise");
        double prise = scanner.nextDouble();
        test = scanner.nextLine();
        System.out.println("Please write product type");
        String type = scanner.nextLine();
        Product product = new Product();
        productService.update(id, new Product(name, prise, type, product.getUuid()));
    }

    private void delete() {
        System.out.println("Please write Product id");
        int id = scanner.nextInt();
        productService.delete(id);
    }

    public static void seach() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write what product are you searching");
        String serchText = scanner.nextLine();
        for (Product product : ProductService.serch(serchText)) {
            System.out.println(product.getName());
        }
    }

    public static void productMenu() {
        int num;
        Scanner scanner = new Scanner(System.in);
        ProductController productController = ProductController.instance;
        do {
            System.out.println("__________________________________");
            System.out.println("             Products             ");
            System.out.println("   Press 1 to create product      ");
            System.out.println("   Press 2 to select all products ");
            System.out.println("   Press 3 to select product      ");
            System.out.println("   Press 4 to update product      ");
            System.out.println("   Press 5 to delete product      ");
            System.out.println("   Press 6 to return menu         ");
            System.out.println("__________________________________");
            num = scanner.nextInt();
            String test = scanner.nextLine();
            switch (num) {
                case 1:
                    productController.create();
                    break;
                case 2:
                    productController.selectAllProducts();
                    break;
                case 3:
                    productController.findProductById();
                    break;
                case 4:
                    productController.update();
                    break;
                case 5:
                    productController.delete();
                    break;
                case 6:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Plese write valid order");
            }
        } while (num != 6);
    }
}

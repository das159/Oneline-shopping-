package onlineshopping.main;

import onlineshopping.model.Product;
import onlineshopping.model.CartItem;
import onlineshopping.service.ShoppingService;

import java.util.Scanner;

public class ShoppingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingService service = new ShoppingService();

        while (true) {
            System.out.println("\n=== Online Shopping ===");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (Product p : service.getAllProducts()) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    if (service.addToCart(id, qty)) {
                        System.out.println("Added to cart.");
                    } else {
                        System.out.println("Invalid product ID.");
                    }
                    break;

                case 3:
                    for (CartItem item : service.getCartItems()) {
                        System.out.println(item);
                    }
                    break;

                case 4:
                    double total = service.checkout();
                    System.out.println("Total amount: $" + total);
                    System.out.println("Thank you for shopping!");
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

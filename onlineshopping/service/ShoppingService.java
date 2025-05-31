package onlineshopping.service;

import onlineshopping.model.Product;
import onlineshopping.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingService {
    private List<Product> products;
    private List<CartItem> cart;

    public ShoppingService() {
        products = new ArrayList<>();
        cart = new ArrayList<>();
        loadProducts();
    }

    private void loadProducts() {
        products.add(new Product(1, "Laptop", 850.00));
        products.add(new Product(2, "Smartphone", 499.99));
        products.add(new Product(3, "Headphones", 99.99));
        products.add(new Product(4, "Mouse", 25.50));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public boolean addToCart(int productId, int quantity) {
        for (Product p : products) {
            if (p.getId() == productId) {
                cart.add(new CartItem(p, quantity));
                return true;
            }
        }
        return false;
    }

    public List<CartItem> getCartItems() {
        return cart;
    }

    public double checkout() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getTotalPrice();
        }
        cart.clear(); // Clear cart after checkout
        return total;
    }
}

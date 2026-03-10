import java.util.*;

public class Sale_inventory {

    HashMap<String, Integer> stock = new HashMap<>();
    Queue<Integer> waitingList = new LinkedList<>();

    void addProduct(String productId, int quantity) {
        stock.put(productId, quantity);
    }

    synchronized void purchase(String productId, int userId) {

        int current = stock.getOrDefault(productId, 0);

        if (current > 0) {
            stock.put(productId, current - 1);
            System.out.println("User " + userId + " purchased item");
        } else {
            waitingList.add(userId);
            System.out.println("User " + userId + " added to waiting list");
        }
    }

    public static void main(String[] args) {

        Sale_inventory system = new Sale_inventory();

        system.addProduct("IPHONE15", 2);

        system.purchase("IPHONE15", 1);
        system.purchase("IPHONE15", 2);
        system.purchase("IPHONE15", 3);
    }
}
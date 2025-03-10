package models;

public class Order {
    private String itemName;
    private int quantity;
    private double pricePerUnit;
    private double totalPrice;

    public Order(String itemName, int quantity, double pricePerUnit) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTotalPrice() {
        double total = quantity * pricePerUnit;
        total = applyDiscount(total);
        return total;
    }

    private double applyDiscount(double total) {
        if (quantity > 5) {
            return total * 0.85; // 15% discount for bulk orders
        }
        return total;
    }

    public String getOrderSummary() {
        return "Item: " + itemName + ", Quantity: " + quantity + ", Total Price: " + totalPrice;
    }

    public boolean isBulkOrder() {
        return quantity > 10;
    }
}
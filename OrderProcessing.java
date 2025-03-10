import java.util.ArrayList;
import java.util.List;

import models.Order;
import models.User;
import utils.*;

public class OrderProcessing {
    private List<String> orderHistory = new ArrayList<>();

    public void processOrder(User user, Order order) {
        orderHistory.add(order.getOrderSummary());
        printOrderConfirmation(user, order);
        notifyUser(user, order);
    }

    private void printOrderConfirmation(User user, Order order) {
        System.out.println("Order Placed Successfully!");
        System.out.println("User: " + user.getName() + " | " + order.getOrderSummary());
        if (order.isBulkOrder()) {
            System.out.println("Bulk Order Alert!");
        }
    }

    private void notifyUser(User user, Order order) {
        EmailService.sendEmail(user.getEmail(),
                "Your order for " + order.getOrderSummary() + " has been placed successfully.");
    }
}

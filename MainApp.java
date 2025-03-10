import models.Order;
import models.User;

public class MainApp {
    public static void main(String[] args) {
        User user = new User("John Doe", "john.doe@example.com");
        Order order = new Order("Laptop", 3, 700);
        OrderProcessing orderService = new OrderProcessing();
        orderService.processOrder(user, order);
    }
}
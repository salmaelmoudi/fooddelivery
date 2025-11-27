package ma.emsi.orderservice.service;

import ma.emsi.orderservice.client.MenuItemDto;
import ma.emsi.orderservice.client.RestaurantClient;
import ma.emsi.orderservice.model.Order;
import ma.emsi.orderservice.model.OrderItem;
import ma.emsi.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantClient restaurantClient;

    public Order createOrder(Order order) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            MenuItemDto menuItem = restaurantClient.getItem(item.getMenuItemId());
            if (menuItem == null || !menuItem.getAvailable()) {
                throw new RuntimeException("Item not available: " + item.getMenuItemId());
            }
            item.setPrice(menuItem.getPrice());
            item.setOrder(order);
            total += item.getPrice() * item.getQuantity();
        }
        order.setTotalAmount(total);
        order.setStatus("PENDING");
        return orderRepository.save(order);
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}

package ma.emsi.deliveryservice.controller;

import ma.emsi.deliveryservice.model.Delivery;
import ma.emsi.deliveryservice.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/assign/{orderId}")
    public Delivery assignDelivery(@PathVariable Long orderId) {
        return deliveryService.assignDelivery(orderId);
    }

    @PatchMapping("/{id}/status")
    public Delivery updateStatus(@PathVariable Long id, @RequestParam String status) {
        return deliveryService.updateStatus(id, status);
    }

    @GetMapping("/route")
    public String getRoute(@RequestParam String origin, @RequestParam String destination) {
        return deliveryService.getOptimalRoute(origin, destination);
    }
}

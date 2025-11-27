package ma.emsi.deliveryservice.service;

import ma.emsi.deliveryservice.model.Courier;
import ma.emsi.deliveryservice.model.Delivery;
import ma.emsi.deliveryservice.repository.CourierRepository;
import ma.emsi.deliveryservice.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private CourierRepository courierRepository;

    public Delivery assignDelivery(Long orderId) {
        // Simple round-robin or random assignment for now
        List<Courier> couriers = courierRepository.findAll();
        if (couriers.isEmpty()) {
            throw new RuntimeException("No couriers available");
        }
        Courier courier = couriers.get(new Random().nextInt(couriers.size()));

        Delivery delivery = new Delivery();
        delivery.setOrderId(orderId);
        delivery.setCourierId(courier.getId());
        delivery.setStatus("ASSIGNED");
        delivery.setCurrentPosition("0,0"); // Initial position

        return deliveryRepository.save(delivery);
    }

    public Delivery updateStatus(Long deliveryId, String status) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
        delivery.setStatus(status);
        return deliveryRepository.save(delivery);
    }

    public String getOptimalRoute(String origin, String destination) {
        // Mock Google Maps API
        return "Route from " + origin + " to " + destination + ": 15 mins, 5 km";
    }
}

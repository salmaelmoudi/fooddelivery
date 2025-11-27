package ma.emsi.deliveryservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private Long courierId;
    private String status; // ASSIGNED, EN_ROUTE, DELIVERED
    private String currentPosition; // Mock coordinates "lat,lon"
}

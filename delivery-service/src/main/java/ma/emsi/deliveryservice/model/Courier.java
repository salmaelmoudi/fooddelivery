package ma.emsi.deliveryservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private Boolean available;
}

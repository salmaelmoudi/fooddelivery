package ma.emsi.noteservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    private Long targetId; // Restaurant ID or Courier ID
    private String type; // RESTAURANT, COURIER
    private Integer score; // 1-5
    private String comment;
}

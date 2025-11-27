package ma.emsi.restaurantservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String photoUrl;
    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}

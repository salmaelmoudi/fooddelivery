package ma.emsi.orderservice.client;

import lombok.Data;

@Data
public class MenuItemDto {
    private Long id;
    private String name;
    private Double price;
    private Boolean available;
}

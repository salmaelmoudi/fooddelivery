package ma.emsi.restaurantservice.repository;

import ma.emsi.restaurantservice.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "restaurants")
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}

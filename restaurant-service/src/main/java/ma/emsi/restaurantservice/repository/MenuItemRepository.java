package ma.emsi.restaurantservice.repository;

import ma.emsi.restaurantservice.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "items")
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}

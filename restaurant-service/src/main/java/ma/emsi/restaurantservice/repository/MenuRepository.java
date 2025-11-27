package ma.emsi.restaurantservice.repository;

import ma.emsi.restaurantservice.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "menus")
public interface MenuRepository extends JpaRepository<Menu, Long> {
}

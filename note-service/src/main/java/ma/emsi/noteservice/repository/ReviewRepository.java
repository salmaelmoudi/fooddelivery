package ma.emsi.noteservice.repository;

import ma.emsi.noteservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByTargetIdAndType(Long targetId, String type);
}

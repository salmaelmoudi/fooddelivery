package ma.emsi.noteservice.controller;

import ma.emsi.noteservice.model.Review;
import ma.emsi.noteservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        // Basic spam prevention: check if user already reviewed this order (not
        // implemented here as we don't track orderId in Review entity yet, but could be
        // added)
        return reviewRepository.save(review);
    }

    @GetMapping
    public List<Review> getReviews(@RequestParam Long targetId, @RequestParam String type) {
        return reviewRepository.findByTargetIdAndType(targetId, type);
    }

    @GetMapping("/average")
    public Double getAverageRating(@RequestParam Long targetId, @RequestParam String type) {
        List<Review> reviews = reviewRepository.findByTargetIdAndType(targetId, type);
        if (reviews.isEmpty()) {
            return 0.0;
        }
        return reviews.stream().mapToInt(Review::getScore).average().orElse(0.0);
    }
}

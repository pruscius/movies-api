package dev.andresfrank.movies.controller;

import dev.andresfrank.movies.dto.ReviewPostDTO;
import dev.andresfrank.movies.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    public ResponseEntity<ReviewPostDTO> createReview(@RequestBody ReviewPostDTO reviewPostDTO) {
        return new ResponseEntity<ReviewPostDTO>(reviewService.createReview(reviewPostDTO), HttpStatus.OK);
    }
}

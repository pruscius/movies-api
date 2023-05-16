package dev.andresfrank.movies.service;

import dev.andresfrank.movies.dto.ReviewPostDTO;
import dev.andresfrank.movies.model.Movie;
import dev.andresfrank.movies.model.Review;
import dev.andresfrank.movies.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements IReviewService {
    ModelMapper modelMapper = new ModelMapper();
    ReviewRepository reviewRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public ReviewPostDTO createReview(ReviewPostDTO reviewPostDTO) {
        Review review = reviewRepository.insert(new Review(reviewPostDTO.getReviewBody()));

        System.out.println(reviewPostDTO.toString());
        /* Update list of reviews in specific movie
        * But what happens if no movie imdbId mathes the one provided? */
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(reviewPostDTO.getImdbId()))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return reviewPostDTO;
    }
}

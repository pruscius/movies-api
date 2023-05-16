package dev.andresfrank.movies.service;

import dev.andresfrank.movies.dto.ReviewPostDTO;

public interface IReviewService {
    public ReviewPostDTO createReview(ReviewPostDTO reviewPostDTO);
}

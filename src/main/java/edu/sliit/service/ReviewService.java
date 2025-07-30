package edu.sliit.service;

import edu.sliit.dto.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAll();

    void addReview(Review review);

    void deleteReviewById(Integer id);

    Review searchReviewById(Integer id);

    void updateReviewById(Review review);
}

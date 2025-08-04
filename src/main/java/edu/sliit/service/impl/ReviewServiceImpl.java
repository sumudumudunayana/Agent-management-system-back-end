package edu.sliit.service.impl;

import edu.sliit.dto.Review;
import edu.sliit.entity.ReviewEntity;
import edu.sliit.repository.ReviewRepository;
import edu.sliit.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Review> getAll() {
        List<Review> reviewArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            reviewArrayList.add(mapper.map(entity, Review.class));
        });
        return reviewArrayList;
    }

    @Override
    public void addReview(Review review) {
        System.out.println(review);
        repository.save(mapper.map(review, ReviewEntity.class));
    }

    @Override
    public void deleteReviewById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Review searchReviewById(Integer id) {
        return mapper.map(repository.findById(id),Review.class);


    }

    @Override
    public void updateReviewById(Review review) {
        repository.save(mapper.map(review, ReviewEntity.class));
    }
}

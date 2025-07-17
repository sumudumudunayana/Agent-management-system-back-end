package edu.sliit.controller;

import edu.sliit.dto.Review;
import edu.sliit.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class ReviewController {
    @Autowired
    final ReviewService service;

    @GetMapping("/get-all")
    public List<Review> getReview(){
        return service.getAll();
    }

    @PostMapping("/add-review")
    public void addReview(@RequestBody Review review){
        log.info("updated-> {}",review);
        service.addReview(review);
    }

    @GetMapping("/search-by-id/{id}")
    public Review getReviewById(@PathVariable Integer id){
        return service.searchReviewById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteReviewById(@PathVariable Integer id){
        service.deleteReviewById(id);
    }
    @PutMapping("/update-review")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProperty(@RequestBody Review review){
        service.updateReviewById(review);
    }
}

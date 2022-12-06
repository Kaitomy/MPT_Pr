package com.example.Proj.Repository;

import com.example.Proj.Models.Feedback;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends CrudRepository<Feedback,Long> {
}

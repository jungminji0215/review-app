package com.example.reviewapp.controller;

import com.example.reviewapp.common.ResponseResult;
import com.example.reviewapp.dto.review.request.ReviewReplyRequest;
import com.example.reviewapp.service.ReviewAdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews/reply")
class ReviewAdminController(
    private val reviewAdminService: ReviewAdminService
) {
    @PostMapping("/{reviewId}")
    fun create(@PathVariable reviewId: Long, @RequestBody input: ReviewReplyRequest)
    = ResponseEntity.ok().body(ResponseResult(reviewAdminService.create(reviewId, input)))

}

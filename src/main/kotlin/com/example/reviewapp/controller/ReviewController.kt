package com.example.reviewapp.controller

import com.example.reviewapp.common.ResponseResult
import com.example.reviewapp.dto.review.request.ReviewRequest
import com.example.reviewapp.service.ReviewService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/reviews/{bookId}") // http://localhost:8080/reviews/bookId
class ReviewController(
    private val reviewService: ReviewService,
) {
    @GetMapping("/test")
    fun test(): String{
        return "테스트 요청"
    }

    @PostMapping
    fun create(@PathVariable bookId: Long, @RequestBody input: ReviewRequest)
    = ResponseEntity.ok().body(ResponseResult(reviewService.create(bookId, input)))

    @DeleteMapping("/{reviewId}")
    fun delete(@PathVariable bookId: Long, @PathVariable reviewId: Long)
    = ResponseEntity.ok().body(ResponseResult(reviewService.delete(bookId, reviewId)))

    @GetMapping("/{reviewId}")
    fun get(@PathVariable reviewId: Long)
            = ResponseEntity.ok().body(ResponseResult(reviewService.get(reviewId)))
}
package com.example.reviewapp.controller

import com.example.reviewapp.common.ResponseResult
import com.example.reviewapp.dto.review.request.ReviewInput
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
    fun create(@PathVariable bookId: Long, @RequestBody input: ReviewInput)
    = ResponseEntity.ok().body(ResponseResult(reviewService.create(bookId, input)))
}
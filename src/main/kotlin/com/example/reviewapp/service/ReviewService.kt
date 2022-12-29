package com.example.reviewapp.service

import com.example.reviewapp.domain.review.ReviewRepository
import com.example.reviewapp.domain.review.review
import com.example.reviewapp.dto.review.request.ReviewInput
import com.example.reviewapp.dto.review.response.ReviewResult
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface ReviewService {
    fun create(bookId: Long, input: ReviewInput): ReviewResult
}

@Service
class ReviewServiceImpl(
    private val reviewRepository: ReviewRepository,
) : ReviewService {

    @Transactional
    override fun create(bookId: Long, input: ReviewInput): ReviewResult {
        val reviewEntity = review(input, bookId)
        return reviewRepository.save(reviewEntity).result()
    }
}
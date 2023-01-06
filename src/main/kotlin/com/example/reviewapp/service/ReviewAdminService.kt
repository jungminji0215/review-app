package com.example.reviewapp.service

import com.example.reviewapp.domain.review.ReviewReply
import com.example.reviewapp.domain.review.ReviewReplyRepository
import com.example.reviewapp.domain.review.ReviewRepository
import com.example.reviewapp.dto.review.request.ReviewReplyRequest
import com.example.reviewapp.dto.review.response.ReviewReplyResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface ReviewAdminService {
    fun create(reviewId: Long, input: ReviewReplyRequest): ReviewReplyResponse
}

@Service
class ReviewAdminServiceImpl(
    private val reviewRepository: ReviewRepository,
    private val reviewReplyRepository: ReviewReplyRepository
) : ReviewAdminService {

    @Transactional
    override fun create(reviewId: Long, input: ReviewReplyRequest): ReviewReplyResponse {
        val review = reviewRepository.findById(reviewId).get()

        val reviewReply = ReviewReply(
            review,
            input.contents
        )

        return reviewReplyRepository.save(review.addReply(reviewReply)).response()
    }
}
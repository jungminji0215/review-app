package com.example.reviewapp.service

import com.example.reviewapp.domain.review.ReviewAverage
import com.example.reviewapp.domain.review.ReviewAverageRepository
import com.example.reviewapp.domain.review.ReviewRepository
import com.example.reviewapp.dto.review.request.ReviewRequest
import com.example.reviewapp.dto.review.response.ReviewResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface ReviewService {
    fun create(bookId: Long, input: ReviewRequest): ReviewResponse

    fun delete(bookId: Long, reviewId: Long) : ReviewResponse

    fun get(bookId: Long) : List<ReviewResponse>
}

@Service
class ReviewServiceImpl(
    private val reviewRepository: ReviewRepository,
    private val reviewAverageRepository: ReviewAverageRepository
) : ReviewService {
    override fun get(bookId: Long): List<ReviewResponse> {
        return reviewRepository.findAllByBookId(bookId).map { it.response() }
    }

    @Transactional
    override fun create(bookId: Long, input: ReviewRequest): ReviewResponse {
        val reviewEntity = input.toEntity(bookId)

        // todo 리펙토링
        val reviewAverage = reviewAverageRepository.findByBookId(bookId) ?: ReviewAverage(
            bookId = bookId,
            count = 0,
            totalScore = 0
        )
        reviewAverage.saveScore(bookId, input)
        reviewAverageRepository.save(reviewAverage)

        return reviewRepository.save(reviewEntity).response()
    }

//    private fun saveScore(bookId: Long, input: ReviewRequest) {
//        val rviewAverage = reviewAverageRepository.findByBookId(bookId) ?: ReviewAverage(
//            bookId = bookId,
//            count = 0,
//            totalScore = 0
//        )
//        rviewAverage.saveScore(bookId, input)
//        reviewAverageRepository.save(rviewAverage)
//    }

    @Transactional
    override fun delete(bookId: Long, reviewId: Long): ReviewResponse {
        val review = reviewRepository.findById(reviewId).orElseThrow{throw IllegalArgumentException("리뷰가 존재하지 않습니다.")}
        review.delete()
        return review.response()
    }
}
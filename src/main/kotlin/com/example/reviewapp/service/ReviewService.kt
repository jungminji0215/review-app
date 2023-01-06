package com.example.reviewapp.service

import com.example.reviewapp.domain.point.ReviewPointRepository
import com.example.reviewapp.domain.review.ReviewRepository
import com.example.reviewapp.dto.review.request.ReviewRequest
import com.example.reviewapp.dto.review.response.ReviewResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.IllegalArgumentException

interface ReviewService {
    fun create(bookId: Long, input: ReviewRequest): ReviewResponse

    fun delete(bookId: Long, reviewId: Long) : ReviewResponse
}

@Service
class ReviewServiceImpl(
    private val reviewRepository: ReviewRepository,
    private val pointPointRepository: ReviewPointRepository
) : ReviewService {

    @Transactional
    override fun create(bookId: Long, input: ReviewRequest): ReviewResponse {
        val reviewEntity = input.toEntity(bookId)

        // todo 별점 저장

        givePoint(input.userId)

        return reviewRepository.save(reviewEntity).response()
    }
    @Transactional
    override fun delete(bookId: Long, reviewId: Long): ReviewResponse {
        val review = reviewRepository.findById(reviewId).orElseThrow{throw IllegalArgumentException("리뷰가 존재하지 않습니다.")}
        review.delete()
        return review.response()
    }

    fun givePoint(userId: Long){
        // todo 디비에 데이터 없을 경우 처리
        // 포인트 테이블에 유저가 있다고 가정
        val userPoint = pointPointRepository.findByUserId(userId).orElseThrow()

        userPoint.givePoint()
    }
}
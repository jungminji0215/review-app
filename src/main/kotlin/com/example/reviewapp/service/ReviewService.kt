package com.example.reviewapp.service

import com.example.reviewapp.domain.point.ReviewPointRepository
import com.example.reviewapp.domain.review.ReviewRepository
import com.example.reviewapp.dto.review.request.ReviewInput
import com.example.reviewapp.dto.review.response.ReviewResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface ReviewService {
    fun create(bookId: Long, input: ReviewInput): ReviewResponse
}

@Service
class ReviewServiceImpl(
    private val reviewRepository: ReviewRepository,
    private val pointPointRepository: ReviewPointRepository
) : ReviewService {

    @Transactional
    override fun create(bookId: Long, input: ReviewInput): ReviewResponse {
        val reviewEntity = input.toEntity(bookId)

        // todo 별점 저장

        // todo 포인트 주는 로직 추가
        givePoint(input.userId)

        return reviewRepository.save(reviewEntity).result()
    }

    fun givePoint(userId: Long){
        // todo 디비에 데이터 없을 경우 처리
        // 포인트 테이블에 유저가 있다고 가정
        val userPoint = pointPointRepository.findByUserId(userId).orElseThrow()

        // 이렇게만 해주었는데 DB에 반영이 되는 이유는..?
        userPoint.givePoint()
    }
}
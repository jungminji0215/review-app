package com.example.reviewapp.service

import com.example.reviewapp.domain.review.ReviewAverageRepository
import com.example.reviewapp.domain.review.ReviewRepository
import com.example.reviewapp.dto.review.request.ReviewRequest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@Suppress("NonAsciiCharacters")
@SpringBootTest
class ReviewServiceTest(
    @Autowired private val reviewService: ReviewService,
    @Autowired private val reviewRepository: ReviewRepository,
    @Autowired private val reviewAverageRepository: ReviewAverageRepository,
) {

    @AfterEach
    fun clean() {
        reviewRepository.deleteAll()
        reviewAverageRepository.deleteAll()
    }

    @Test
    fun `리뷰가 정상적으로 등록된다`() {
        // given
        val bookId = 1L

        val createReview = ReviewRequest(
            userId = 1L,
            star = 5,
            contents = "교훈을 주는 책이예요."
        )

        // when
        val result = reviewService.create(bookId, createReview)

        // then
        result.userId shouldBeEqualTo 1L
        result.star shouldBeEqualTo 5
        result.contents shouldBeEqualTo "교훈을 주는 책이예요."
    }
}
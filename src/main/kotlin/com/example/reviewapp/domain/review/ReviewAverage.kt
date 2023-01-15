package com.example.reviewapp.domain.review

import com.example.reviewapp.dto.review.request.ReviewRequest
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class ReviewAverage(
    var bookId: Long,

    var count: Int, // 리뷰 갯수

    var totalScore: Int, // 리뷰 총 합

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
){
    fun saveScore(bookId: Long, input: ReviewRequest) {
        this.bookId = bookId
        this.count = this.count + 1
        this.totalScore = this.totalScore + input.star
    }
}

interface ReviewAverageRepository : JpaRepository<ReviewAverage, Long>{
    fun findByBookId(bookId: Long) : ReviewAverage?
}
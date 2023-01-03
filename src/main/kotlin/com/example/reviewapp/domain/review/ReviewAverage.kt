package com.example.reviewapp.domain.review

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class ReviewAverage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var bookId: Long,

    var totalScore: Int, // 리뷰 총 합

    var count: Int, // 리뷰 갯수
) {
}

interface ReviewAverageRepository : JpaRepository<ReviewAverage, Long>
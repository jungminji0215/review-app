package com.example.reviewapp.domain.review

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
class ReviewReply(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "reviewId")
    val review: Review,

    val contents: String,
) {
}

interface ReviewReplyRepository : JpaRepository<ReviewReply, Long>
package com.example.reviewapp.domain.review

import com.example.reviewapp.dto.review.response.ReviewReplyResponse
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
class ReviewReply(
    @ManyToOne
    @JoinColumn(name = "review_id")
    var review: Review,

    var contents: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var active: Boolean = true,
) {

    fun response(): ReviewReplyResponse {
        return ReviewReplyResponse(
            id = this.id!!,
            reviewId = review.id!!,
            contents = this.contents,
            active = this.active
        )
    }
    fun addReview(review: Review){
        this.review = review
    }
}

interface ReviewReplyRepository : JpaRepository<ReviewReply, Long>
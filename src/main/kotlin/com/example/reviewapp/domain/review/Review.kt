package com.example.reviewapp.domain.review

import com.example.reviewapp.dto.review.request.ReviewRequest
import com.example.reviewapp.dto.review.response.ReviewResponse
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
class Review(
    val userId: Long,

    val bookId: Long,

    var star: Int,

    var contents: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    val reviewReply: MutableList<ReviewReply> = mutableListOf(),

    var active:Boolean = false,

    // todo 작성일, 수정일은 Mapped Superclass 사용
) {
    fun delete(){
        this.active = false
    }

    fun response(): ReviewResponse {
        return ReviewResponse(
            id = this.id!!,
            userId = this.userId,
            bookId = this.bookId,
            star = this.star,
            contents = this.contents,
            active = this.active,
//            reviewReply = this.reviewReply
        )
    }

    fun addReply(reviewReply: ReviewReply): ReviewReply{
        this.reviewReply.add(reviewReply)
        reviewReply.addReview(this)

        return reviewReply
    }
}

// todo 사용 안하면 삭제
fun review(input: ReviewRequest, bookId: Long) =
    Review(
        bookId = bookId,
        userId = input.userId,
        star = input.star,
        contents = input.contents,
    )

interface ReviewRepository : JpaRepository<Review, Long>{
    fun findAllByBookId(bookId: Long): List<Review>
}
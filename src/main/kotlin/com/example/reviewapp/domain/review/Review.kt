package com.example.reviewapp.domain.review

import com.example.reviewapp.dto.review.request.ReviewInput
import com.example.reviewapp.dto.review.response.ReviewResponse
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val userId: Long,

    val bookId: Long,

    var star: Int,

    var contents: String,

    var isDeleted:Boolean = false,

    // todo 작성일, 수정일
) {
    fun isDeleted(){
        this.isDeleted = true
    }

    fun result(): ReviewResponse {
        return ReviewResponse(
            id = this.id!!,
            userId = this.userId,
            bookId = this.bookId,
            contents = this.contents,
            isDeleted = this.isDeleted
        )
    }
}

// todo 사용 안하면 삭제
fun review(input: ReviewInput, bookId: Long) =
    Review(
        bookId = bookId,
        userId = input.userId,
        star = input.star,
        contents = input.contents,
    )

interface ReviewRepository : JpaRepository<Review, Long>{
}
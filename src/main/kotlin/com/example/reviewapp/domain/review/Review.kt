package com.example.reviewapp.domain.review

import com.example.reviewapp.dto.review.request.ReviewInput
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

    var contents: String,

    var isDeleted:Boolean = false,

    // todo 작성일, 수정일
) {
    fun isDeleted(){
        this.isDeleted = true
    }

    fun result(): ReviewResult{
        return ReviewResult(
            id = this.id!!,
            userId = this.userId,
            bookId = this.bookId,
            contents = this.contents,
            isDeleted = this.isDeleted
        )
    }
}

fun review(input: ReviewInput, bookId: Long) =
    Review(
        bookId = bookId,
        userId = input.userId,
        contents = input.contents,
    )

interface ReviewRepository : JpaRepository<Review, Long>
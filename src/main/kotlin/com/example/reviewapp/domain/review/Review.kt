package com.example.reviewapp.domain.review

import com.example.reviewapp.dto.review.request.ReviewRequest
import com.example.reviewapp.dto.review.response.ReviewResponse
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val userId: Long,

    val bookId: Long,

    var star: Int,

    var contents: String,

    // 나는 review에 의해서 관리가 돼!!
    // 조회하는것은 되는데, 값을 변경하지는 못한다.
    @OneToMany(mappedBy = "review") // ReviewReply에 있는 변수랑 연결
    val reviewReply: MutableList<ReviewReply> = mutableListOf(),

    var active:Boolean = false,

    // todo 작성일, 수정일
) {
    fun delete(){
        this.active = false
    }

    fun response(): ReviewResponse {
        return ReviewResponse(
            id = this.id!!,
            userId = this.userId,
            bookId = this.bookId,
            contents = this.contents,
            active = this.active
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
}
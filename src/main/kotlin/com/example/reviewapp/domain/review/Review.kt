package com.example.reviewapp.domain.review

import org.springframework.data.jpa.repository.JpaRepository
import java.time.ZonedDateTime
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
}

interface ReviewRepository : JpaRepository<Review, Long>
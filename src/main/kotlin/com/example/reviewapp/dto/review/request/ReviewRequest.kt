package com.example.reviewapp.dto.review.request

import com.example.reviewapp.domain.review.Review

data class ReviewRequest(
    val userId: Long,
    val star: Int,
    val contents: String,
) {
    fun toEntity(bookId: Long): Review{
        return Review(
            userId = this.userId,
            bookId = bookId,
            star = this.star,
            contents = this.contents,
            active = true
        )
    }
}
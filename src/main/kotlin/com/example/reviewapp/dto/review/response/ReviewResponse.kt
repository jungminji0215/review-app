package com.example.reviewapp.dto.review.response

data class ReviewResponse(
    val id: Long,
    val userId: Long,
    val bookId: Long,
    val contents: String,
    val active: Boolean
)
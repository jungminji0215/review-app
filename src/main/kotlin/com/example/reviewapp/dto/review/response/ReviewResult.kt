package com.example.reviewapp.dto.review.response

data class ReviewResult(
    val id: Long,
    val userId: Long,
    val bookId: Long,
    val contents: String,
    val isDeleted: Boolean
)
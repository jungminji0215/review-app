package com.example.reviewapp.dto.review.request

data class ReviewInput(
    val userId: Long,
    val star: Int,
    val contents: String,
)
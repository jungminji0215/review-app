package com.example.reviewapp.dto.review.response

data class ReviewReplyResponse(
    val id: Long,
    val reviewId: Long,
    val contents: String,
    val active: Boolean
){
    // entity -> dto
}
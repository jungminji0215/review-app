package com.example.reviewapp.dto.review.response

data class ReviewResponse(
    val id: Long,
    val userId: Long,
    val bookId: Long,
    val star: Int,
    val contents: String,
    val active: Boolean
    // todo 답변 추가
){
    // entity -> dto

}
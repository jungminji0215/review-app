package com.example.reviewapp.common

import org.springframework.http.HttpStatus

class ResponseResult<T>(
    val status: HttpStatus,
    val data: T
)
{
    constructor(data: T) : this(
        HttpStatus.OK, data
    )
}
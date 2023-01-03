package com.example.reviewapp.domain.point

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

// todo 이벤트 리뷰, 일반 리뷰 구분
@Entity
class ReviewPoint(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val userId: Long,

    var total: Int = 0,
) {
    fun givePoint(){
        this.total += 100
    }
}

interface ReviewPointRepository : JpaRepository<ReviewPoint, Long>{
    // todo optional 로 반환하지 않으면?
    fun findByUserId(userId: Long): Optional<ReviewPoint>
}
package com.example.reviewapp

import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JunitTest {

    @BeforeAll
    fun beforeAllTest(){
        println("beforeAll 테스트")
    }

    @AfterAll
    fun afterAllTest(){
        println("beforeAll 테스트")
    }

    @BeforeEach
    fun beforeEachTest(){
        println("---------- BeforeEach 테스트 ----------")
    }

    @AfterEach
    fun afterEachTest(){
        println("----------- AfterEach 테스트 ----------")
    }

    @Test
    fun testA(){
        println("테스트 A")
    }

    @Test
    fun testB(){
        println("테스트 B")
    }

}
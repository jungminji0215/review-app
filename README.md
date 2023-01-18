# 목차
- [사용 기술](#사용-기술)
- [프로젝트 설명](#프로젝트-설명)
- [설계](#설계)
- [트러블 슈팅](#트러블슈팅)

<br>

## 사용 기술

<a><img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=SpringBoot&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=Kotlin&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=Hibernate&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=Gradle&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/></a>

<br>

## 프로젝트 설명
주제 : 도서 리뷰 API 

API 개발 공부 목적으로 진행하고있는 프로젝트입니다. 리뷰 등록 API, 관리자 리뷰 API 개발하고있습니다. <br>
테스트코드도 작성하고있습니다. <br>

리뷰 등록 : POST         review/{bookId} <br>
리뷰 조회 : GET          review/{bookId} <br>
리뷰 삭제 : DELETE       review/{bookId}/{reviewId} <br>
리뷰 수정 : PUT          review/{bookId}/{reviewId}

<br>

### 💁🏻‍♀️ 요구 사항

[사용자 기능] 
  - 사용자는 리뷰를 등록, 조회, 수정, 삭제할 수 있다.
  - 리뷰 등록 시, 사용자에게 포인트를 지급한다.
      - 리뷰를 최초 등록 시에 포인트 추가 지급
      - 사진 등록 시 포인트 추가 지급
      - 리뷰 이벤트를 하는 기간에는 포인트 추가 지급

[관리자 기능]
  - 관리자는 사용자가 등록한 리뷰에 답변을 달 수 있다.

<br>

### 👩🏻‍💻 개발 기능
- 엔티티 및 테이블 설계 
- 리뷰 등록 API 개발 
- 리뷰 삭제 API 개발
- 리뷰 답변 등록 API 개발
  
  추가중

<br>

## 설계

<img width="486" alt="스크린샷 2023-01-16 오후 1 14 06" src="https://user-images.githubusercontent.com/83000829/212597343-c7352d9a-cabe-4f35-b58f-ef44466bc956.png">

[ERD]

- 수정전

<img width="450" alt="스크린샷 2022-12-29 오후 1 01 29" src="https://user-images.githubusercontent.com/83000829/209903914-a21b805a-6a3f-4036-8149-82f4bb2ae4ab.png">

- 수정후

<img width="574" alt="스크린샷 2023-01-16 오후 1 12 50" src="https://user-images.githubusercontent.com/83000829/212597227-fec8f903-8371-41c5-a144-2c9b6f5f285e.png">

- 엔티티


<br>

## 트러블슈팅
[고민 거리]

리뷰 점수를 관리를 어떻게 해야 하는지에 대해 생각보다 고민해야 할 것이 많은 것 같다. 
책이 등록될 때 리뷰 별점 엔티티를 만들어야 하는 것인지 리뷰가 등록될 때, 그때 리뷰 별점 엔티티를 만들어야 하는지?
책 등록 기능을 안 만들어서 일단 리뷰가 등록될 때, 리뷰 엔티티가 없으면 새로 만드는 방식으로 구현되어 있다. 
도서 등록 기능을 만들면, 등록과 동시에 리뷰 별점 엔티티가 생성되도록 수정해 봐야겠다. 
커머스 서비스를 운영하고 있는 기업들은 리뷰 기능을 어떻게 설계하고, 어떻게 관리하는지 정말 궁금하다...

<br>

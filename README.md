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

사용자가 리뷰 API, 관리자 리뷰 API 개발.

[추가] 
- 리뷰 등록시 포인트 지급 조건도 추가
- 리뷰 종류 추가(리뷰 이벤트는 포인트 추가 지급)


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
  - [ ] 엔티티 및 테이블 설계
  - [ ] 사용자 리뷰 등록 API 개발
  - [ ] 사용자 리뷰 삭제 API 개발
  
  추가중

<br>

## 설계

- ERD

<img width="450" alt="스크린샷 2022-12-29 오후 1 01 29" src="https://user-images.githubusercontent.com/83000829/209903914-a21b805a-6a3f-4036-8149-82f4bb2ae4ab.png">

-> ERD 업데이트 중

- 엔티티


<br>

## 트러블슈팅
프로젝트를 진행하면서 고민했던 부분
- 리뷰 종류에 따른 엔티티 설계에 대한 고민

<br>

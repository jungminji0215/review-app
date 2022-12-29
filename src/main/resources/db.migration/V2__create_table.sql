use review;

create table review
(
    id                       bigint        not null auto_increment primary key,
    user_id     bigint                     not null       comment '회원 ID',
    book_id     bigint                     not null       comment '도서 ID',
    contents                 blob          not null       comment '리뷰 내용',
    is_deleted               tinyint(1)    not null       comment '삭제 여부'
) comment '도서 리뷰';

create table review_reply
(
    id          bigint                     not null auto_increment primary key,
    review_id   bigint                     not null       comment '리뷰 ID',
    contents    blob                       not null       comment '답변 내용'
) comment '도서 리뷰 답변';

create table review_average
(
    id          bigint                     not null auto_increment primary key,
    book_id     bigint                     not null comment '도서 ID',
    total       Int                        not null comment '리뷰 총점',
    count       bigint                     not null comment '리뷰 수'
) comment '도서 리뷰 평점';

create table review_point
(
    id          bigint                     not null auto_increment primary key,
    user_id     bigint                     not null comment '회원 ID',
    total       Int                        not null comment '포인트'
) comment '도서 리뷰 평점';


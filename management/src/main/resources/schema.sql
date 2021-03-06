
drop table if exists book;
drop table if exists category;
drop table if exists status;

create table if not exists category(
    id   varchar(10),
    name varchar(10) not null
);

create table if not exists status(
    status varchar(5)
);

create table if not exists book (
    book_Id      VARCHAR(30),
    name        VARCHAR(20),
    publish_Date DATE,
    company     VARCHAR(20),
    writer      VARCHAR(20),
    status      VARCHAR(5),
    quantity    INT,
    category    VARCHAR(50)
);




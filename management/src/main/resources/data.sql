
INSERT INTO book (book_Id, name, publish_Date, company, writer, status, quantity, category)
          VALUES ('컴퓨터_1_1', 'DOMAIN DRIVEN DESIGN', NOW(), '위키북스', '에릭에반스', '최초등록', 5, '컴퓨터');
INSERT INTO book (book_Id, name, publish_Date, company, writer, status, quantity, category)
         VALUES ('인문_1_1', '슬기로운KEP생활', NOW(), 'KEP', 'andrew', '최초등록', 5, '인문');
INSERT INTO book (book_Id, name, publish_Date, company, writer, status, quantity, category)
         VALUES ('만화_1_1', '클라우드정복', NOW(), 'KiC', '언이', '최초등록', 5, '만화');

insert into category (id, name) values (1, '컴퓨터' );
insert into category (id, name) values (2, '과학' );
insert into category (id, name) values (3, '인문' );
insert into category (id, name) values (4, '만화' );
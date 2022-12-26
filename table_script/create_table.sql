CREATE TABLE SPRING_SESSION (
	PRIMARY_ID CHAR(36) NOT NULL,
	SESSION_ID CHAR(36) NOT NULL,
	CREATION_TIME BIGINT NOT NULL,
	LAST_ACCESS_TIME BIGINT NOT NULL,
	MAX_INACTIVE_INTERVAL INT NOT NULL,
	EXPIRY_TIME BIGINT NOT NULL,
	PRINCIPAL_NAME VARCHAR(100),
	CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC;

CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);

CREATE TABLE SPRING_SESSION_ATTRIBUTES (
	SESSION_PRIMARY_ID CHAR(36) NOT NULL,
	ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
	ATTRIBUTE_BYTES BLOB NOT NULL,
	CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
	CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC;


drop table if exists member;
drop table if exists orders;

create table member (
	member_id bigint not null auto_increment,
	created_date datetime(6),
	modified_date datetime(6),
	email varchar(255),
	gender varchar(255),
	name varchar(255) not null,
	nick_name varchar(255) not null,
	password varchar(1000) not null,
	tell varchar(255),
	role varchar(255) not null,
	primary key (member_id)
) engine=InnoDB

create table orders (
	id bigint not null auto_increment,
	created_date datetime(6),
	modified_date datetime(6),
	item_name varchar(100) not null,
	order_num varchar(12) not null,
	member_id bigint,
	primary key (id)
) engine=InnoDB

alter table orders add constraint FKmgorkx4kfna7pnnqgkqikb6ed foreign key (member_id) references member (member_id)

alter table orders character set = utf8mb4, collate = utf8mb4_unicode_ci;

insert into member (name, nick_name, password, email, tell, role) values ('test1', 'test1', 'test1', 'test1@naver.com', '01011111111', 'ADMIN');
insert into member (name, nick_name, password, email, tell, role) values ('test2', 'test2', 'test2', 'test2@naver.com', '01011111111', 'USER');
insert into member (name, nick_name, password, email, tell, role) values ('test3', 'test3', 'test3', 'test3@naver.com', '01011111111', 'USER');

insert into orders (item_name, order_num, member_id, created_date) values ('item1', '111111111ABC', (select member_id from member where name = 'test1'), '2022-08-08 10:07:20.357');
insert into orders (item_name, order_num, member_id, created_date) values ('item2', '222222222ABC', (select member_id from member where name = 'test1'), '2022-08-09 10:07:20.357');
insert into orders (item_name, order_num, member_id, created_date) values ('item3', '333333333ABC', (select member_id from member where name = 'test1'), '2022-08-10 10:07:20.357');
insert into orders (item_name, order_num, member_id, created_date) values ('item4', '444444444ABC', (select member_id from member where name = 'test1'), '2022-08-11 10:07:20.357');

insert into orders (item_name, order_num, member_id, created_date) values ('item5', '555555555ABC', (select member_id from member where name = 'test2'), '2022-08-12 10:07:20.357');
insert into orders (item_name, order_num, member_id, created_date) values ('item6', '666666666ABC', (select member_id from member where name = 'test2'), '2022-08-13 10:07:20.357');
insert into orders (item_name, order_num, member_id, created_date) values ('item7', '777777777ABC', (select member_id from member where name = 'test2'), '2022-08-14 10:07:20.357');
insert into orders (item_name, order_num, member_id, created_date) values ('item8', '888888888ABC', (select member_id from member where name = 'test2'), '2022-08-15 10:07:20.357');

insert into orders (item_name, order_num, member_id, created_date) values ('item9', '999999999ABC', (select member_id from member where name = 'test3'), '2022-08-16 10:07:20.357');
insert into orders (item_name, order_num, member_id, created_date) values ('item10', '112211221ABC', (select member_id from member where name = 'test3'), '2022-08-17 10:07:20.357');
insert into orders (item_name, order_num, member_id, created_date) values ('item11', '343434343ABC', (select member_id from member where name = 'test3'), '2022-08-18 10:07:20.357');
insert into orders (item_name, order_num, member_id, created_date) values ('item12', '565656565ABC', (select member_id from member where name = 'test3'), '2022-08-19 10:07:20.357');


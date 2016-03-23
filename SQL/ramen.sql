/***************************
 * らーめんデータベース　　①商品情報　②購入履歴　③カート
 **************************/

create database if not exists ramen;

use ramen;

drop table if exists ramen_items;
create table ramen_items (

item_id int primary key not null auto_increment,

item_name varchar(100) not null,

explanation varchar(100) not null,

category enum('ramen','topping') not null,

price int not null,

item_stock int not null,

img_path varchar(100) not null
);


insert into ramen_items values(1,'しょうゆラーメン','醤油ベースのラーメン','ramen',500,1000,'img/しょうゆラーメン.jpg');
insert into ramen_items values(2,'塩ラーメン','塩ベースのラーメン','ramen',600,10,'img/とんこつラーメン.jpg');
insert into ramen_items values(3,'とんこつラーメン','とんこつベースのラーメン','ramen',700,10,'img/塩ラーメン.jpg');
insert into ramen_items values(4,'味噌ラーメン','味噌ベースのラーメン','ramen',400,20,'img/味噌ラーメン.jpg');



drop table if exists history;
create table history(

sales_id int primary key not null auto_increment,

id int not null,

item_name varchar(100),

number_of_items int not null,

purchase_date datetime not null,

postal_code varchar(8),

address varchar(100)
);
insert into history values
(1,1,"しょうゆラーメン",1,"2016-03-14 01:00:00","1111111","東京都文京区湯島1-1-1"),
(2,1,"塩ラーメン",2,"2016-03-15 01:00:00","1111111","東京都文京区湯島1-1-1"),
(3,3,"しょうゆラーメン",3,"2016-03-16 01:00:00","1111113","東京都文京区湯島1-1-3"),
(4,3,"塩ラーメン",2,"2016-03-16 01:00:00","1111113","東京都文京区湯島1-1-3"),
(5,6,"とんこつラーメン",1,"2016-03-17 01:00:00","1111116","東京都文京区湯島1-1-6"),
(6,6,"味噌ラーメン",1,"2016-03-17 01:00:00","1111116","東京都文京区湯島1-1-6");


drop table if exists cart;
create table cart(

cart_id int primary key not null auto_increment,

id int not null,

item_id int not null,

number_of_items int not null

);

drop table if exists temp;
create table temp(
temp_id int primary key auto_increment,
user_name varchar(255),
password varchar(255),
email varchar(100) unique,
cell_number varchar(15) unique,
postal_code varchar(8),
address varchar(100),
card_number varchar(50),
card_holder varchar(255),
expiration_date varchar(20),
security_code varchar(4),
oauth_id varchar(50),
oauth_name varchar(50),
registration_date datetime
);

insert into temp value
	(1,'テスト','test','test@gmail.com','09012345678','1234567','テスト県テスト市0-000-0','','','','','','',now()),
	(2,'テスト2','test2','test2@gmail.com','09087654321','7654321','テスト県テスト市2-222-2','','','','','','',now());

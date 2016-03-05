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
insert into ramen_items value
(1,"しょうゆラーメン","しょうゆラーメンです","ramen",500,1,"aaa"),
(2,"しょうゆラーメン","しょうゆラーメンです","ramen",500,20,"aaa"),
(3,"しょうゆラーメンしょうゆラーメン","しょうゆラーメンです","ramen",500,30,"aaa"),
(4,"しょうゆラーメンしょうゆラーメン","しょうゆラーメンです","ramen",500,40,"aaa"),
(5,"しょうゆラーメンしょうゆラーメン","しょうゆラーメンです","ramen",500,50,"aaa"),
(6,"しょうゆラーメンしょうゆラーメン","しょうゆラーメンです","ramen",500,50,"aaa"),
(7,"しょうゆラーメンしょうゆラーメン","しょうゆラーメンです","ramen",500,60,"aaa"),
(8,"しょうゆラーメンしょうゆラーメン","しょうゆラーメンです","ramen",500,70,"aaa"),
(9,"しょうゆラーメンしょうゆラーメン","しょうゆラーメンです","ramen",500,80,"aaa"),
(10,"しょうゆラーメンしょうゆラーメン","しょうゆラーメンです","ramen",500,10,"aaa"),
(11,"しょうゆラーメンしょうゆラーメン","しょうゆラーメンです","ramen",500,20,"aaa"),
(12,"しょうゆラーメンしょうゆラーメン","しょうゆラーメンです","ramen",500,20,"aaa"),
(13,"しょうゆラーメンしょうゆラーメン","しょうゆラーメンです","ramen",500,20,"aaa"),
(14,"しょうゆラーメンしょうゆラーメンしょうゆラーメン","しょうゆラーメンです","ramen",500,50,"aaa");

drop table if exists history;
create table history(

sales_id int primary key not null auto_increment,

user_id int not null,

item_name varchar(100),

number_of_items int not null,

purchase_date datetime not null,

postal_code varchar(8),

addless varchar(100)
);
insert into history value
(1,1,"しょうゆラーメン",2,"2016-01-28 22:00:00","222-2222","カリフォルニア"),
(2,1,"みそラーメン",2,"2016-01-28 22:00:00","222-2222","カリフォルニア"),
(3,1,"みそラーメン",2,"2016-01-27 22:00:00","222-2222","カリフォルニア"),
(4,2,"しおラーメン",2,"2016-01-27 22:00:00","222-2222","カリフォルニア"),
(5,5,"しおラーメン",2,"2016-01-25 22:00:00","222-2222","カリフォルニア"),
(6,2,"しょうゆラーメン",2,"2016-01-25 22:00:00","222-2222","カリフォルニア"),
(7,1,"しょうゆラーメン",2,"2016-01-28 22:00:00","222-2222","カリフォルニア");


drop table if exists cart;
create table cart(

cart_id int primary key not null auto_increment,

user_id int not null,

item_id int not null,

number_of_items int not null

);




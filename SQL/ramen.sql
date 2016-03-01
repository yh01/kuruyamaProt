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
(1,1,"ラーメン",2,"2016-01-28 22:00:00","222-2222","カリフォルニア");


drop table if exists cart;
create table cart(

cart_id int primary key not null auto_increment,

user_id int not null,

item_id int not null,

number_of_items int not null

);




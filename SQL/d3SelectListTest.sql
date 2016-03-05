create database if not exists d3SelectListTest;
use d3SelectListTest;

drop table if exists d3select;
create table d3select(
	id int not null primary key auto_increment,
	itemName varchar(100) not null,
	salesAmount int not null default'0'
	);
insert into d3select(itemName,salesAmount)values("しょうゆラーメン",30);
insert into d3select(itemName,salesAmount)values("とんこつラーメン",50);
insert into d3select(itemName,salesAmount)values("みそラーメン",20);
insert into d3select(itemName,salesAmount)values("しおラーメン",10);
insert into d3select(itemName,salesAmount)values("test5",40);
insert into d3select(itemName,salesAmount)values("test6",44);
insert into d3select(itemName,salesAmount)values("test7",46);
insert into d3select(itemName,salesAmount)values("test8",20);
insert into d3select(itemName,salesAmount)values("test9",70);
insert into d3select(itemName,salesAmount)values("test10",30);
insert into d3select(itemName,salesAmount)values("test11",300);
insert into d3select(itemName,salesAmount)values("test12",60);
insert into d3select(itemName,salesAmount)values("test13",80);
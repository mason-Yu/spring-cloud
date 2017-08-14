/*CREATE DATABASE springbootdb;*/
drop table if exists province;
create table province (
id int(10) unsigned not null auto_increment comment 'province number',
province_name varchar(25) default null comment 'city name',
description varchar(50) default null comment 'desrciption',
primary key(id)
) engine = innoDB auto_increment=1 default charset=utf8;

drop table if exists city;
create table city (
id int(10) unsigned not null auto_increment comment 'city number',
province_id int(10) unsigned not null comment 'province number',
city_name varchar(25) default null comment 'city name',
description varchar(50) default null comment 'desrciption',
primary key(id)
) engine = innoDB auto_increment=1 default charset=utf8;

drop table if exists user;
create table user (
id int(10) unsigned not null auto_increment comment 'user number',
user_name varchar(25) default null comment 'user name',
description varchar(50) default null comment 'desrciption',
primary key(id)
)engine = innoDB auto_increment=1 default charset=utf8;

insert into province(province_name, description)value('上海', '上海');
insert into province(province_name, description)value('广州', '广州');
insert into province(province_name, description)value('湖北', '湖北');
insert into province(province_name, description)value('河南', '河南');
select * from province;

insert into city(city_name, province_id, description)value('上海', 8, '');
insert into city(city_name, province_id, description)value('深圳', 9, '');
insert into city(city_name, province_id, description)value('武汉', 10, '');
insert into city(city_name, province_id, description)value('郑州', 11, '');
select * from city;

insert into user(user_name, description)value('sam', '');
insert into user(user_name, description)value('pop', '');
insert into user(user_name, description)value('administrator', 'administrator');
insert into user(user_name, description)value('system', 'administrator');
select * from user;
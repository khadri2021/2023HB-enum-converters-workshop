create table RESTUARENT (
ORDER_ID bigint not null, 
PERMENENT_DOOR_NO varchar(255), 
PERMENENT_LAND_MARK varchar(255), 
PERMENENT_STREET_NAME varchar(255), 
PHONE_NUMBER varchar(255) not null, 
PIZZA_NAME varchar(255) not null, 
PRESENT_DOOR_NO varchar(255), 
PRESENT_LAND_MARK varchar(255), 
PRESENT_STREET_NAME varchar(255), 
RESTUARENT_NAME varchar(255), 
SIZE char(1) not null, 
primary key (ORDER_ID)
);
select * from RESTUARENT;

use vehicle;

insert into brand(name) values ('BMW');

insert into type(name) values ('Coupé');

insert into model(name, brand_id, type_id) values ('i8', 1, 1);

insert into service(name, description, cost) values ('General Wash', 'General Wash', 100.00);
insert into service(name, description, cost) values ('Premium Wash','Premium Wash', 200.00);

insert into service(name, description, cost) values ('Interior Dirt/Cleaning', 'Interior Dirt/Cleaning', 50.00);
insert into service(name, description, cost) values ('Car Paint Polish', 'Car Paint Polish', 150.00);
insert into service(name) values ('Others');
insert into user_details(id, birth_date,name)
values(1001, current_date(),'Aakash');
insert into user_details(id, birth_date,name)
values(1002, current_date(),'Prakash');
insert into user_details(id, birth_date,name)
values(1003, current_date(),'Vikash');

insert into post(id, description, user_id)
values(20001,'Learning AWS Post', 1001);
insert into post(id, description, user_id)
values(20002,'Learning GCP Post', 1002);
insert into post(id, description, user_id)
values(20003,'Learning OCP Post', 1001);
insert into post(id, description, user_id)
values(20004,'Learning Java Post', 1003);
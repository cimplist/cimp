insert into tbRole (name, description) values ('ROLE_USER','Basic User');
insert into tbRole (name, description) values ('ROLE_MANAGER','Basic User');
insert into tbRole (name, description) values ('ROLE_ADMIN','Admin User');

insert into  tbUser (userName, password, userType, managerID, fname, lname,mname,email,
	enabled ,accountNonExpired ,accountNonLocked ,credentialsNonExpired) values ('johnd','cfb6ee6068ef9645114ef4374d72aa7c','IND', 2,'John','Developer','D','john@cimplist.com',true,true,true,true);
insert into  tbUser (userName, password, userType, managerID, fname, lname,mname,email,
	enabled ,accountNonExpired ,accountNonLocked ,credentialsNonExpired) values ('bobd','cfb6ee6068ef9645114ef4374d72aa7c','IND', 2,'Bob','Developer','D','bob@cimplist.com',true,true,true,true);

insert into  tbUser (userName, password, userType, managerID, fname, lname,mname,email,
	enabled ,accountNonExpired ,accountNonLocked ,credentialsNonExpired) values ('markl','cfb6ee6068ef9645114ef4374d72aa7c','MGR',3,'Mark','Lead','P','mark@cimplist.com',true,true,true,true);
insert into  tbUser (userName, password, userType, managerID, fname, lname,mname,email,
	enabled ,accountNonExpired ,accountNonLocked ,credentialsNonExpired) values ('samm','cfb6ee6068ef9645114ef4374d72aa7c','MGR',4,'Sam','manager','K','sam@cimplist.com',true,true,true,true);
insert into  tbUser (userName, password, userType, managerID, fname, lname,mname,email,
	enabled ,accountNonExpired ,accountNonLocked ,credentialsNonExpired) values ('davevp','cfb6ee6068ef9645114ef4374d72aa7c','MGR',null,'Dave','VP','J','dave@cimplist.com',true,true,true,true);

insert into  tbUserAuthorityJT (userID, roleID) values (0,0);
insert into  tbUserAuthorityJT (userID, roleID) values (1,0);
insert into  tbUserAuthorityJT (userID, roleID) values (2,0);
insert into  tbUserAuthorityJT (userID, roleID) values (3,0);
insert into  tbUserAuthorityJT (userID, roleID) values (4,1);
insert into  tbUserAuthorityJT (userID, roleID) values (5,1);

insert into  tbUserAuthorityJT (userID, roleID) values (3,1);
insert into  tbUserAuthorityJT (userID, roleID) values (3,2);

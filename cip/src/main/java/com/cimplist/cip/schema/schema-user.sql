drop table tbUserAuthorityJT if exists;
drop table tbUser if exists;
drop table tbRole if exists;

create table tbRole (ID integer identity primary key, name varchar(255) not null, description varchar(255) not null);
create table tbUser (ID integer identity primary key, userName varchar(255) not null, password varchar(255) null, userType varchar(100) null, managerID integer null, fname varchar(100) not null, lname varchar(100) null,mname varchar(100) null,email varchar(100) null,
	enabled boolean not null,accountNonExpired boolean not null,accountNonLocked boolean not null,credentialsNonExpired boolean not null);

create table tbUserAuthorityJT (ID integer identity primary key, userID integer not null,roleID integer not null);

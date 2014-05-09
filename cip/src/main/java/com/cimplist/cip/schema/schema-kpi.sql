drop table tbKpiItem if exists;
drop table tbKpiCategoryWeight if exists;
drop table tbKpiHeader if exists;
drop table tbKpiCategory if exists;

drop table tbKpiReviewHeader if exists;
drop table tbKpiReviewItem if exists;

create table tbKpiCategory (ID integer identity primary key, weightPercentBase integer  not null, catdesc varchar(255) not null);

create table tbKpiHeader (ID integer identity primary key, kpiSetupDate date  not null, status varchar(255) not null, userID integer not null, approvedByUserID integer null);


create table tbKpiCategoryWeight (ID integer identity primary key, weightPercent integer  not null, kpicatID integer  not null, kpiHeaderID integer  not null );


create table tbKpiItem (ID integer identity primary key,kpiParameterDesc varchar(255) not null, kpiItemDesc varchar(255) not null, status varchar(255) not null, kpicatWeightID integer not null, kpiHeaderID integer null);

create table tbKpiReviewHeader (ID integer identity primary key, reviewDate date  null, status varchar(255) not null , overallRating decimal  null , kpiHeaderID integer not null, selfReview boolean null, reviewedByUserID integer null);


create table tbKpiReviewItem (ID integer identity primary key, comments varchar(255) null, kpiItemID integer not null, status varchar(255) not null, rating decimal null, kpiReviewHeaderID integer null);

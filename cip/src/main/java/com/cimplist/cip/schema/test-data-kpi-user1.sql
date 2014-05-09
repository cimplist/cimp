insert into tbKpiCategory (catDesc, weightPercentBase) values ('Delivery Management',65);
insert into tbKpiCategory (catDesc, weightPercentBase) values ('Product Knowledge',15);
insert into tbKpiCategory (catDesc, weightPercentBase) values ('Initiatives',10);
insert into tbKpiCategory (catDesc, weightPercentBase) values ('Team Dynamics and mentoring',10);

insert into  tbKpiHeader (kpiSetupDate, status, userID) values (SYSDATE, 'NEW',0);

insert into tbKpiCategoryWeight (kpicatID, weightPercent,kpiHeaderID) values (0,65,0);
insert into tbKpiCategoryWeight (kpicatID, weightPercent,kpiHeaderID) values (1,15,0);
insert into tbKpiCategoryWeight (kpicatID, weightPercent,kpiHeaderID) values (2,10,0);
insert into tbKpiCategoryWeight (kpicatID, weightPercent,kpiHeaderID) values (3,10,0);

insert into tbKpiItem (kpiParameterDesc , kpiItemDesc , status , kpicatWeightID , kpiHeaderID ) values 
('90% defects fixed in same sprint','Resolve defects quickly','NEW',0,0 );

insert into tbKpiItem (kpiParameterDesc , kpiItemDesc , status , kpicatWeightID , kpiHeaderID ) values 
('#Best practices documented','Product knowledgebase improvements','NEW',1,0 );
insert into tbKpiItem (kpiParameterDesc , kpiItemDesc , status , kpicatWeightID , kpiHeaderID ) values 
('E.g. Demo for cube using the latest feature of Cognos Dynamic Cubes','POC on Cognos BI latest features','NEW',2,0 );
insert into tbKpiItem (kpiParameterDesc , kpiItemDesc , status , kpicatWeightID , kpiHeaderID ) values 
('Conduct  3 training session of 1-2 hours each','Provide TOI to team on Cognos Multi dimensional modelling','NEW',3,0 );

insert into tbKpiReviewHeader (reviewDate  , status , overallRating  , kpiHeaderID , selfReview , reviewedByUserID  )  values (SYSDATE,'NEW',3.0,0,true,0);

insert into tbKpiReviewItem (comments , kpiItemID , status , rating , kpiReviewHeaderID  ) values ('Goal Met',0,'NEW',3,0);
insert into tbKpiReviewItem (comments , kpiItemID , status , rating , kpiReviewHeaderID  ) values ('Goal Met',1,'NEW',3,0);
insert into tbKpiReviewItem (comments , kpiItemID , status , rating , kpiReviewHeaderID  ) values ('Goal Met',2,'NEW',3,0);
insert into tbKpiReviewItem (comments , kpiItemID , status , rating , kpiReviewHeaderID  ) values ('Goal Met',3,'NEW',3,0);
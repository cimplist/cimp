insert into  tbKpiHeader (kpiSetupDate, status, userID) values (SYSDATE, 'NEW',1);

insert into tbKpiCategoryWeight (kpicatID, weightPercent,kpiHeaderID) values (0,65,1);
insert into tbKpiCategoryWeight (kpicatID, weightPercent,kpiHeaderID) values (1,15,1);
insert into tbKpiCategoryWeight (kpicatID, weightPercent,kpiHeaderID) values (2,10,1);
insert into tbKpiCategoryWeight (kpicatID, weightPercent,kpiHeaderID) values (3,10,1);

insert into tbKpiItem (kpiParameterDesc , kpiItemDesc , status , kpicatWeightID , kpiHeaderID ) values 
('90% defects fixed in same sprint','Resolve defects quickly','NEW',4,1 );

insert into tbKpiItem (kpiParameterDesc , kpiItemDesc , status , kpicatWeightID , kpiHeaderID ) values 
('#Best practices documented','Product knowledgebase improvements','NEW',5,1 );
insert into tbKpiItem (kpiParameterDesc , kpiItemDesc , status , kpicatWeightID , kpiHeaderID ) values 
('E.g. Demo for cube using the latest feature of Cognos Dynamic Cubes','POC on Cognos BI latest features','NEW',6,1 );
insert into tbKpiItem (kpiParameterDesc , kpiItemDesc , status , kpicatWeightID , kpiHeaderID ) values 
('Conduct  3 training session of 1-2 hours each','Provide TOI to team on Cognos Multi dimensional modelling','NEW',7,1 );

insert into tbKpiReviewHeader (reviewDate  , status , overallRating  , kpiHeaderID , selfReview , reviewedByUserID  )  values (SYSDATE,'NEW',3.0,1,true,1);

insert into tbKpiReviewItem (comments , kpiItemID , status , rating , kpiReviewHeaderID  ) values ('Goal Met',4,'NEW',3,1);
insert into tbKpiReviewItem (comments , kpiItemID , status , rating , kpiReviewHeaderID  ) values ('Goal Met',5,'NEW',3,1);
insert into tbKpiReviewItem (comments , kpiItemID , status , rating , kpiReviewHeaderID  ) values ('Goal Met',6,'NEW',3,1);
insert into tbKpiReviewItem (comments , kpiItemID , status , rating , kpiReviewHeaderID  ) values ('Goal Met',7,'NEW',3,1);
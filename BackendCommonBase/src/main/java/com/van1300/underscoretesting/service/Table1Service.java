package com.van1300.underscoretesting.service;

import com.vs.rappit.base.acl.IPerimeterManager;
import com.van1300.underscoretesting.base.service.Table1BaseService;
import com.van1300.underscoretesting.model.Table1;
import com.van1300.underscoretesting.service.Table1PerimeterImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.van1300.underscoretesting.service.WorkflowHistoryService;
import com.vs.rappit.base.querybuilder.ComplexCondition;


@Service("Table1")
public class Table1Service extends Table1BaseService<Table1> implements ITable1Service<Table1>{

		public Table1Service(ChangelogService changelogService, Table1PerimeterImpl table1PerimeterImpl, WorkflowHistoryService workflowHistoryService, ApplicationUserService applicationUserService) {
		super(Table1.class);	
		setChangelogService(changelogService); 
		setWorkflowHistoryBL(workflowHistoryService);
		setUserPrivilegeService(applicationUserService);
		setPerimeter(table1PerimeterImpl);
		
	}
	
	@Override
	protected boolean resolveCondition(Table1 resolveCondition, ComplexCondition when) {
		super.resolveCondition(resolveCondition, when);
		return true;
	}
}
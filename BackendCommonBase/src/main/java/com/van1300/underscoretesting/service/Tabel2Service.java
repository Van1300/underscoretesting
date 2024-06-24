package com.van1300.underscoretesting.service;

import com.vs.rappit.base.acl.IPerimeterManager;
import com.van1300.underscoretesting.base.service.Tabel2BaseService;
import com.van1300.underscoretesting.model.Tabel2;
import com.van1300.underscoretesting.service.Tabel2PerimeterImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.van1300.underscoretesting.service.WorkflowHistoryService;
import com.vs.rappit.base.querybuilder.ComplexCondition;


@Service("Tabel2")
public class Tabel2Service extends Tabel2BaseService<Tabel2> implements ITabel2Service<Tabel2>{

		public Tabel2Service(ChangelogService changelogService, Tabel2PerimeterImpl tabel2PerimeterImpl, WorkflowHistoryService workflowHistoryService, ApplicationUserService applicationUserService) {
		super(Tabel2.class);	
		setChangelogService(changelogService); 
		setWorkflowHistoryBL(workflowHistoryService);
		setUserPrivilegeService(applicationUserService);
		setPerimeter(tabel2PerimeterImpl);
		
	}
	
	@Override
	protected boolean resolveCondition(Tabel2 resolveCondition, ComplexCondition when) {
		super.resolveCondition(resolveCondition, when);
		return true;
	}
}
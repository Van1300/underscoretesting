package com.van1300.underscoretesting.base.service;

import java.util.Map;
import com.vs.rappit.base.workflow.util.WorkflowMetaInfo;
import com.van1300.underscoretesting.base.model.Table1Base;

public interface IUnderscore_flowWorkflowActions<T extends Table1Base>{
	String underscoreFlow = "underscore_flow";
	
    String openflow = "openflow";
    
    
    T openflow(Object id, Map<String, Object> additionalInfo);
	void onbeforeOpenflow(T model, WorkflowMetaInfo metaInfo);
	void onOpenflow(T model, WorkflowMetaInfo metaInfo);
	void onAfterOpenflow(T model, WorkflowMetaInfo metaInfo);
    
}
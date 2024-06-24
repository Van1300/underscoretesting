package com.van1300.underscoretesting.base.service;

import java.util.Map;
import com.vs.rappit.base.workflow.util.WorkflowMetaInfo;
import com.van1300.underscoretesting.base.model.Tabel2Base;

public interface IBlanks_nameWorkflowActions<T extends Tabel2Base>{
	String blanksName = "blanks_name";
	
    String createopentab2 = "createopentab2";
    
    
    T createopentab2(Object id, Map<String, Object> additionalInfo);
	void onbeforeCreateopentab2(T model, WorkflowMetaInfo metaInfo);
	void onCreateopentab2(T model, WorkflowMetaInfo metaInfo);
	void onAfterCreateopentab2(T model, WorkflowMetaInfo metaInfo);
    
}
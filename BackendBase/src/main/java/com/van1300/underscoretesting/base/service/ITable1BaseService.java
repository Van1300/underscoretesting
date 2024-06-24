package com.van1300.underscoretesting.base.service;

import com.vs.rappit.base.logic.ICRUDOperation;
import com.van1300.underscoretesting.base.model.Table1Base;


public interface ITable1BaseService<T extends Table1Base> extends ICRUDOperation<T>,IUnderscore_flowWorkflowActions<T>{
	
	T getTable1WorkflowModelBySid(Object sid);

}
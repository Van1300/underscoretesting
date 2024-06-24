package com.van1300.underscoretesting.base.service;

import com.vs.rappit.base.logic.ICRUDOperation;
import com.van1300.underscoretesting.base.model.Tabel2Base;


public interface ITabel2BaseService<T extends Tabel2Base> extends ICRUDOperation<T>,IBlanks_nameWorkflowActions<T>{
	
	T getTabel2WorkflowModelBySid(Object sid);

}